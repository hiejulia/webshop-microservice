package project.webshop.validation;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import project.webshop.model.Product;
import project.webshop.service.ProductService;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.http.ResponseEntity.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductValidationTest {
    // autowired
    @Autowired
    private ProductService productService;

    @Test
    public void createProduct_withValidationError() throws Exception {
//        public Product(String id, String productName, Double productPrice,
//                String description, String category) {


        Product mockProduct = new Product("1","Pencil",10.0,"Studying tool","Study");

        String productJson = "{'id' : '1','productName':'Pencil','productPrice':10.0,'description':'Studying tool','category':'Study'}";

//
//        when( productService.addProduct(
//                anyString(), anyString(), isNull(), anyBoolean()))
//                .thenReturn(mockProduct);
//
//        MvcResult result = mvc.perform(
//                MockMvcRequestBuilders.post("/product/add")
//                        .content(productJson)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(
//                        status().is4xxClientError()).andReturn();
    }


}
