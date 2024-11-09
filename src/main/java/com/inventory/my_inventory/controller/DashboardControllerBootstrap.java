package com.inventory.my_inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventory.my_inventory.entity.Product;
import com.inventory.my_inventory.service.ProductService;

@Controller
public class DashboardControllerBootstrap {

    @Autowired
    private ProductService productService; // Autowire the ProductService

    @GetMapping("/dashboard_bootstrap")
    public String dashboardBootstrap(Model model) {
        model.addAttribute("products", productService.getAllProducts()); // Add products to the model
        return "dashboard_bootstrap"; // Return the name of the HTML file
    }
    
    
    @GetMapping("/dashboard_bootstrap/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update_product"; // Assuming this page exists with the update form
    }

    @PostMapping("/dashboard_bootstrap/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/dashboard_bootstrap";
    }
    @PostMapping("/dashboard_bootstrap/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/dashboard_bootstrap";
    }

    @PostMapping("/dashboard_bootstrap/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/dashboard_bootstrap";
    }
}

