package com.example.supplychainmanagement.services.product;

import com.example.supplychainmanagement.converterDtoToPojo.DiscountDtoToPojo;
import com.example.supplychainmanagement.dto.DiscountDto;
import com.example.supplychainmanagement.dto.ResponseDiscountDto;
import com.example.supplychainmanagement.entities.Discount;
import com.example.supplychainmanagement.repositories.product.DiscountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private DiscountDtoToPojo discountDtoToPojo;
    private final LocalDate localDate = LocalDate.now();



    public List<ResponseDiscountDto> getAllDiscounts(){
        return discountDtoToPojo.entitiesToDto(discountRepo.findAll());
    }

    public Boolean addDiscount(DiscountDto dto) {
        final String name = dto.getName().trim().toUpperCase();
        final boolean present = discountRepo.findByName(name).isPresent();
        if (present){
            return false;
        }
        dto.setName(name);
        final Discount productDiscount = discountDtoToPojo.getProductDiscount(dto);
        productDiscount.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        final Discount save = discountRepo.save(productDiscount);

        if (save.getId() != null){
            System.out.println("Insert success!");
        }

        return true;
    }

    public ResponseDiscountDto getDiscountById(Long id) {
        if (id != null){
            return discountDtoToPojo.getResponseDiscountDto(search(id));
        }
        return null;
    }



    public void updateDiscountById(Long id, Double percent) {
        update(id, percent);
    }

    private void update(Long id,Double percent) {
        discountRepo.updateDiscountById(id,
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                percent);

    }
    private Discount search(Long id){
        final Optional<Discount> byId = discountRepo.findById(id);
        return byId.orElse(null);
    }


    public Boolean delete(Long id) {
        if (id != null){
            final int i = discountRepo.deleteDiscountById(id,
                    Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            );
            return true;
        }



        return false;
    }
}
