package com.example.supplychainmanagement;

import com.example.supplychainmanagement.entities.Discount;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.repositories.product.DiscountRepo;
import com.example.supplychainmanagement.repositories.product.ProductCategoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SupplyChainManagementApplication{

    private LocalDate localDate = LocalDate.now();

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner category(ProductCategoryRepo repo){
        return args -> {
            ProductCategory category = new ProductCategory();
            category.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category.setName("Home exercise equipment".toUpperCase());
            category.setDescription("Stationary bikes and other workout gear replaced trips to the gym.");
            ProductCategory category1 = new ProductCategory();
            category1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            category1.setName("Electronics".toUpperCase());
            category1.setDescription("The uptick in consumer electronics sales was driven.");

            ProductCategory category2 = new ProductCategory();
            category2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category2.setName("Meal boxes and kitchen accessories".toUpperCase());
            category2.setDescription("Meal box companies did well.");
            ProductCategory category3 = new ProductCategory();
            category3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category3.setName("Creative home entertainment".toUpperCase());
            category3.setDescription("For those who wanted to unplug, puzzles and etc.");
            ProductCategory category4 = new ProductCategory();
            category3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category4.setName("Furniture".toUpperCase());
            category4.setDescription("Spending more time at home motivated some shoppers and etc.");

            repo.saveAll(List.of(category, category1, category2, category3));
        };
    }

    @Bean
    CommandLineRunner discount(DiscountRepo repo){
        return args -> {
            Discount discount = new Discount();
            discount.setName("Buy one, get one free discounts".toUpperCase());
            discount.setDescription("A buy-one-get-one-free discount, also called a BOGO discount");
            discount.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            Discount discount1 = new Discount();
            discount1.setName("Percentage sales".toUpperCase());
            discount1.setDescription("A percentage sale is discounts an item based on a percentage of its value.");
            discount1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            Discount discount2 = new Discount();
            discount2.setName("Early payment discounts".toUpperCase());
            discount2.setDescription("In some situations, businesses may offer early payment discounts to encourage customers to fulfill their payments within a specific period.");
            discount2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            Discount discount3 = new Discount();
            discount3.setName("Overstock sales".toUpperCase());
            discount3.setDescription("When a business holds a surplus of stock of a product, it creates a loss.");
            discount3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            repo.saveAll(List.of(discount, discount1, discount2, discount3));
        };
    }



}
