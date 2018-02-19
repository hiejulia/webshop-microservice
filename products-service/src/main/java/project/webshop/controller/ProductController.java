package project.webshop.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.webshop.model.Product;
import project.webshop.service.ProductService;


@RestController
@RequestMapping("/v1/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
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

}
