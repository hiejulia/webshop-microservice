package project.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CategoryController extends ResponseEntityExceptionHandler {
//
//    @RequestMapping(value = "/products/recommendations", method = RequestMethod.GET)
//    public @ResponseBody
//    CompletableFuture<List<Product>> productRecommendations() {
//        return productRepository.findAllProducts();
//    }
//
//    @RequestMapping("/products/{_id}")
//    public CompletableFuture<Product> product(@PathVariable("_id") String _id) throws Exception {
//        return productRepository.findProductById(_id);
//    }
//
//    @RequestMapping(value = "/products", method = RequestMethod.PUT)
//    public CompletableFuture<String> addProduct(@RequestBody Product product) throws Exception {
//        return productRepository.addProduct(product);
//    }
//
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public CompletableFuture<String> updateProduct(@RequestBody Product product) throws Exception {
//        return productRepository.updateProduct(product);
//    }


}