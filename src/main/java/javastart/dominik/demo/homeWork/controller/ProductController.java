package javastart.dominik.demo.homeWork.controller;


import javastart.dominik.demo.homeWork.model.Product;
import javastart.dominik.demo.homeWork.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/")
    String add(Product product) {
        productRepository.add(product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    String products(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("productsPrice", productRepository.sum());
        return "products";
    }

    @GetMapping("/products-table")
    String productsTable(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("productsPrice", productRepository.sum());
        return "productsTable";
    }


}
