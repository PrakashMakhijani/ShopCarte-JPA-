package my.learning.shopcartdemo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.learning.shopcartdemo.entities.Customer;
import my.learning.shopcartdemo.repo.CustomerRepo;
import my.learning.shopcartdemo.repo.PriceRepo;
import my.learning.shopcartdemo.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepo custRepo;
    private final PriceRepo priceRepo;
    private final ProductRepo productRepo;



    public Customer createCustomer(Customer cust1){
        cust1.getProduct().stream().forEach(productRepo::save);
        return this.custRepo.save(cust1);
    }

    public boolean deleteCustomerByid(Integer id){
        Optional<Customer> byId = custRepo.findById(id);
        if(byId.isPresent()){

            custRepo.delete(byId.get());
            return true;
        }
        log.info("Customer is not present {}", byId);
        return false;

    }

    public List<Customer> findAll() {
        return custRepo.findAll();
    }

    public Customer getCustomer(Integer id) {
        Optional<Customer> byId = custRepo.findById(id);
        return byId.get();
    }

    public boolean updateCustomerbyID(Integer id, String name){
        Optional<Customer> byId = custRepo.findById(id);
        if(byId.isPresent()){
            log.info("Updating Customer info {}", byId.get());
            byId.get().setName(name);
            return true;
        }
        byId.orElseThrow(()->new RuntimeException("Customer not present"));
        return false;
    }
}
