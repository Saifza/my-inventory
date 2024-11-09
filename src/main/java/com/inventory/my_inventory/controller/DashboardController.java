package com.inventory.my_inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventory.my_inventory.service.ProductService;



@Controller
public class DashboardController {

	 @Autowired
	    private ProductService productService;

	    // Existing dashboard endpoint
	    @GetMapping("/dashboard")
	    public String dashboard(Model model) {
	        model.addAttribute("products", productService.getAllProducts());
	        return "dashboard";
	    }

	    // New endpoint for updating product quantity
	    @PostMapping("/updateQuantity")
	    @ResponseBody
	    public String updateQuantity(@RequestParam Long productId, @RequestParam int newQuantity) {
	        try {
	            productService.updateQuantity(productId, newQuantity);
	            return "Quantity updated successfully!";
	        } catch (RuntimeException e) {
	            return "Error: " + e.getMessage();
	        }
	    }
}