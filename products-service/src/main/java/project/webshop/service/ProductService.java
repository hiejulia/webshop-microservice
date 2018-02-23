package project.webshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.webshop.model.Inventory;
import project.webshop.model.Product;
import project.webshop.repository.ProductDetailsRepository;


import com.mongodb.async.SingleResultCallback;
//import com.mongodb.async.client.MongoCollection;
//import com.mongodb.async.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.mongodb.client.model.Filters.eq;




@Service
public class ProductService {


    @Autowired
    private ProductDetailsRepository productDetailsRepository;

//    final String inventoryURI = "http://ec2-54-67-113-169.us-west-1.compute.amazonaws.com:8084/inventory/";
    // INVENTORY URL = port : 8084
    final String inventoryURI = "http://localhost:8084/inventory/";

    private Log log = LogFactory.getLog(ProductService.class);


    // add Product
    public boolean addProduct(Product product){
        productDetailsRepository.save(product);
        return true;
    }

    // id productId valid
    // check if product id is already exist
    public boolean isValid(String productId) {
        if(!(productDetailsRepository.exists(productId)))
            return false;
        return true;
    }
    // find all products
    public ArrayList<Product> listAll() throws JSONException {
        //if(addProducts())
        return (ArrayList<Product>) productDetailsRepository.findAll();
        //}

        //return null;

	/*if(addProducts()){
		List<Product> productList = productDetailsRepo.findAll();
	    List<JSONObject> products = new ArrayList<JSONObject>();
	    for (Product p : productList) {
	        JSONObject product = new JSONObject();
	        product.put("productId", p.getId());
	        product.put("productName", p.getProductName());

	        products.add(product);
	    }
	    return (ArrayList<JSONObject>) products;
	}

		return null;
		*/
    }

    public boolean addProducts(){

        productDetailsRepository.deleteAll();
        ArrayList<Product> productList= new ArrayList<Product>();
        Product product1 = new Product(UUID.randomUUID().toString(), "Not a Penny More, Not a Penny less",259.23,"Novel by Jeffery Archer", "Novel");
        Product product2 = new Product(UUID.randomUUID().toString(), "Macbeth",40.00,"Play by Sherlock Holmes", "Plays");
        Product product3 = new Product(UUID.randomUUID().toString(), "Head First Java",20.00,"A java beginners reference", "Textbook");
        Product product4 = new Product(UUID.randomUUID().toString(), "Head First Design Patterns",25.00,"A design patterns reference book", "Textbook");
        Product product5 = new Product(UUID.randomUUID().toString(), "fairy Colors",25.00,"Coloring Book", "Kids");
        Product product7 = new Product(UUID.randomUUID().toString(), "Guitar Guide",40.00,"A guitar lesson book", "Music");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product7);

        productDetailsRepository.save(productList);
        createInventory(productList);
        return true;
    }

    // create intentory

    private void createInventory(ArrayList<Product> productList) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(inventoryURI);// delete

        for(Product product:productList){
            Inventory newInventory = new Inventory(product.getId(),100);// default value is 100
            restTemplate.postForObject(inventoryURI + "create", newInventory, Inventory.class);// create inventory
        }


    }

    /**
     * getProductInfo by @productId
     * @param productId
     * @return
     */
    public Product getProductInfo(String productId) {
        Product returnedProduct = new Product();
        returnedProduct = productDetailsRepository.findById(productId);
        return returnedProduct;
    }

}
