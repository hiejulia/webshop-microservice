package project.webshop.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.webshop.model.Review;
import project.webshop.service.ReviewService;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void retrievesReview()throws Exception {
        List<Review> mockList = Arrays.asList(new Todo(1, "Jack",
                "Learn Spring MVC", new Date(), false), new Todo(2, "Jack",
                "Learn Struts", new Date(), false));

        when(service.retrieveTodos(anyString())).thenReturn(mockList);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/users
                        /Jack/todos").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String expected = "["
                + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" +","
                + "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }
}
