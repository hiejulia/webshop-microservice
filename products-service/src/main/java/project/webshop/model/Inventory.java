package project.webshop.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection="Inventory")
@JsonRootName("Inventory")
public class Inventory {
    // productId
    // available number of stock

    @Id
    private String productId;

    @NotNull
    private Integer availableStock;

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Integer getAvailableStock() {
        return availableStock;
    }
    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }
    public Inventory(String productId, Integer availableStock) {
        super();
        this.productId = productId;
        this.availableStock = availableStock;
    }
    public Inventory() {
        super();

    }




}
