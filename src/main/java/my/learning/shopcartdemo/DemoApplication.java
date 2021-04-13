package my.learning.shopcartdemo;

import my.learning.shopcartdemo.entities.Customer;
import my.learning.shopcartdemo.entities.Price;
import my.learning.shopcartdemo.entities.Product;
import my.learning.shopcartdemo.repo.PriceRepo;
import my.learning.shopcartdemo.service.CustomerService;
import my.learning.shopcartdemo.service.ProductService;
import my.learning.shopcartdemo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CustomerService custService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PriceRepo priceRepo;
    @Autowired
    private ShoppingCartService shoppingCartService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); }

        @Bean
    CommandLineRunner runner(){
        return args ->{

//            Price.builder()
//                    .prodPrice(25);


            Customer secondCustomer = Customer.builder()
                    .name("Navleen")
                    .build();
            Customer thirdCustomer = Customer.builder()
                    .name("Amit")
                    .build();
            Customer fourthCustomer = Customer.builder()
                    .name("Keval")
                    .build();


            custService.createCustomer(secondCustomer);
            custService.createCustomer(thirdCustomer);
            custService.createCustomer(fourthCustomer);


            Price priceFV= Price.builder().priceid(1).prodPrice(25).build();
            priceRepo.save(priceFV);

            Product firstProduct = Product.builder().productID(1).productName("French Vanila").productDesc("Hot and Sweet Drink").price(priceFV).build();
            productService.createProduct(firstProduct);
            Price priceIC= Price.builder().priceid(2).prodPrice(20).build();
            Product secondProduct = Product.builder().productID(2).productName("Ice Coffee").productDesc("Cold Drink").price(priceIC).build();
            Price priceOJ= Price.builder().priceid(3).prodPrice(30).build();
            Product thirdProduct = Product.builder().productID(3).productName("Orange Juice").productDesc("Cold and Sweet Drink").price(priceOJ).build();
            Price priceAJ= Price.builder().priceid(4).prodPrice(35).build();
            Product fourthProduct = Product.builder().productID(4).productName("Apple Juice").productDesc("Real Fruit Drink").price(priceAJ).build();
            priceRepo.save(priceIC);
            priceRepo.save(priceOJ);
            priceRepo.save(priceAJ);


            productService.createProduct(firstProduct);
            productService.createProduct(secondProduct);
            productService.createProduct(thirdProduct);
            productService.createProduct(fourthProduct);

            Customer firstCustomer = Customer.builder()
                    .name("Prakash")
                    .product(Arrays.asList(firstProduct,secondProduct))
                    .build();
            custService.createCustomer(firstCustomer);

            shoppingCartService.productBoughtByID(4);


        };
        }

}
