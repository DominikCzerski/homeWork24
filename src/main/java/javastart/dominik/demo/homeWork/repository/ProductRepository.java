package javastart.dominik.demo.homeWork.repository;

import javastart.dominik.demo.homeWork.model.Product;
import org.springframework.stereotype.Repository;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> productList;


    public ProductRepository() {
        productList = new ArrayList<>();
        productList.add(new Product("Telephone", 1999.99));
        productList.add(new Product("Laptop", 2500.99));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public void add(Product product) {
        productList.add(product);
    }

    public String sum() {
        double sum = productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        DecimalFormat df = new DecimalFormat("####0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(sum);
    }
}
