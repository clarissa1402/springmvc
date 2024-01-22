package com.belajarspring.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.belajarspring.entity.Product;
import com.belajarspring.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {
    

    @Autowired
    private ProductService productService;


    @GetMapping
    public String welcome(Model model)
    {
        String messages = "Welcome Clarissa!";
        model.addAttribute("msg",messages);
        model.addAttribute("products", productService.findAll());
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> save(Product product, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors");
        }
        productService.upsertProduct(product);
        return ResponseEntity.ok("Product saved successfully");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Product>> edit(@PathVariable("id") Long id){
        Optional<Product> product = productService.findById(id);
        return product.map(p -> ResponseEntity.ok().body(product)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
