package project.webshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.webshop.model.Product;
import project.webshop.repository.ProductDetailsRepository;
import project.webshop.service.ProductService;

import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/products")
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;


    @Autowired
    private ProductDetailsRepository productDetailsRepository;


    // get all products
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Product> listAllProducts() throws JSONException   {
        return productService.listAll();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getProductInfo(@PathVariable("productId") String productId) {
        Product returnedProduct = new Product();
        returnedProduct = productService.getProductInfo(productId);
        return new ResponseEntity<Product>(returnedProduct,HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getProductInfo() {

        if(productService.addProducts())
            return new ResponseEntity<Product>(HttpStatus.OK);
        return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
    }

    // handle exception
    @ExceptionHandler(Exception.class)
    void handleExceptions(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error. We will be addressing this issue soon.");
    }

}
