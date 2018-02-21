package project.webshop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.webshop.model.Inventory;
import project.webshop.repository.InventoryRepository;


@Service("intentoryService")
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepo;

    public Inventory getInventory(UUID productId) {
        return inventoryRepo.findByProductId(productId);
    }


    public Inventory createInventory(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }


    public void deleteAllInventory() {
        inventoryRepo.deleteAll();
    }

    // find all
    public List<Inventory> getAll() {
        return inventoryRepo.findAll();
    }

}
