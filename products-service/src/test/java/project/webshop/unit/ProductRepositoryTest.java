package project.webshop.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.webshop.model.Product;
import project.webshop.repository.ProductDetailsRepository;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    @Test
    public void simpleTest(){

        // delete all
        // save new product
        productDetailsRepository.deleteAll();
        productDetailsRepository.save(new Product());
        for(Product p:productDetailsRepository.findAll()){

        }

    }
}
