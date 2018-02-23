package project.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_HEADER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

public class ProductCatalogQueryFilter extends ZuulFilter
{
    @Value("${zuulCustomFilters.productCatalogQuery.serviceId}")
    private String targetService;

    @Value("${zuulCustomFilters.productCatalogQuery.paths}")
    private String[] paths;


    @Override
    public String filterType()
    {
        return ROUTE_TYPE;
    }


    @Override
    public int filterOrder()
    {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }


    @Override
    public boolean shouldFilter()
    {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String method = request.getMethod();
        String requestURI = request.getRequestURI();

        return HttpMethod.GET.matches(method) &&
                Arrays.asList(paths).stream().anyMatch(requestURI::startsWith);
    }


    @Override
    public Object run()
    {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set(SERVICE_ID_KEY, targetService);
        ctx.addOriginResponseHeader(SERVICE_ID_HEADER, targetService);
        ctx.setRouteHost(null); // prevent SimpleHostRoutingFilter from running

        return null;
    }
}
