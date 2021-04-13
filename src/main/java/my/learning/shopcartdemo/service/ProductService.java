package my.learning.shopcartdemo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.learning.shopcartdemo.entities.Price;
import my.learning.shopcartdemo.entities.Product;
import my.learning.shopcartdemo.repo.PriceRepo;
import my.learning.shopcartdemo.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;

    @Transactional
    public Product createProduct (Product product){
        return this.productRepo.save(product);
    }

    // Delete Product By ID  if we need to remove from List
    @Transactional
    public Boolean deleteProductByID(Integer id){
        Optional<Product> byId = productRepo.findById(id);
        if (byId.isPresent()) {
            log.info("Deleteing the customer by id {}", byId.get());
            productRepo.delete(byId.get());
            return true;
        }
        return false;
    }


}
