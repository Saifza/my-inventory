package com.inventory.my_inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import com.inventory.my_inventory.entity.Product;
import com.inventory.my_inventory.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PutMapping("/{id}/updateQuantity")
    public Product updateProductQuantity(@PathVariable Long id, @RequestBody int newQuantity) {
        Product updatedProduct = productService.updateQuantity(id, newQuantity);

        // Send update to subscribers
        messagingTemplate.convertAndSend("/topic/inventoryUpdates", updatedProduct);

        return updatedProduct;
    }
}