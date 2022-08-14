package com.example.supplychainmanagement;

import com.example.supplychainmanagement.entities.Discount;
import com.example.supplychainmanagement.entities.ProductCategory;
import com.example.supplychainmanagement.repositories.product.DiscountRepo;
import com.example.supplychainmanagement.repositories.product.ProductCategoryRepo;
import com.example.supplychainmanagement.services.product.DiscountService;
import com.example.supplychainmanagement.services.product.ProductCategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SupplyChainManagementApplication{

    private LocalDate localDate = LocalDate.now();

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainManagementApplication.class, args);
    }




    @Bean
    CommandLineRunner category(ProductCategoryService service){
        return args -> {
            List<ProductCategory> categories = new ArrayList<>();
            ProductCategory category = new ProductCategory();
            category.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category.setName("Fashion".toUpperCase());
            category.setDescription("Daraz has several options for Men's and Women's fashion.");
            categories.add(category);

            ProductCategory category1 = new ProductCategory();
            category1.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category1.setName("Electronics".toUpperCase());
            category1.setDescription("Daraz offers electronic items for personal and home use.");
            categories.add(category1);

            ProductCategory category2 = new ProductCategory();
            category2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category2.setName("Health & Beauty".toUpperCase());
            category2.setDescription("You will find all your care needs on Daraz.");
            categories.add(category2);

            ProductCategory category3 = new ProductCategory();
            category3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category3.setName("Groceries".toUpperCase());
            category3.setDescription("Order the food staples used daily in your household from Daraz.");
            categories.add(category3);

            ProductCategory category4 = new ProductCategory();
            category4.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category4.setName("Home & Lifestyle".toUpperCase());
            category4.setDescription("Home decoration and improvement have been made easy with Daraz. ");
            categories.add(category4);

            ProductCategory category5 = new ProductCategory();
            category5.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            category5.setName("Sports".toUpperCase());
            category5.setDescription("Love being active and playing sports?");
            categories.add(category4);

            service.addAllCategoryRunTime(categories);
//            repo.saveAll(List.of(category, category1, category2, category3, category4, category5));
        };
    }

    @Bean
    CommandLineRunner discount(DiscountService service){
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
            discount2.setDescription("In some situations, businesses may offer early ");
            discount2.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            Discount discount3 = new Discount();
            discount3.setName("Overstock sales".toUpperCase());
            discount3.setDescription("When a business holds a surplus of stock of a product, it creates a loss.");
            discount3.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            Discount discount4 = new Discount();
            discount4.setName("Price bundling".toUpperCase());
            discount4.setDescription("Often used by phone and internet service providers, price bundling allows customers to bundle several services under the same plan for a discounted price");
            discount4.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            List<Discount> discounts = new ArrayList<>(List.of(discount, discount1, discount2, discount3, discount4));
            service.addAllDiscountRunTime(discounts);


//            repo.saveAll(List.of(discount, discount1, discount2, discount3, discount4));
        };
    }



}
