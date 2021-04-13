package my.learning.shopcartdemo.service;

import lombok.extern.slf4j.Slf4j;
import my.learning.shopcartdemo.entities.Customer;
import my.learning.shopcartdemo.entities.Product;
import my.learning.shopcartdemo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class ShoppingCartService {
    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    public Optional<Customer> productBoughtByID(Integer id){
        Optional<Customer> byId = customerRepo.findById(id);
        byId.ifPresent(p->log.info("Got Product : {}",p));
        return byId;
    }
}
