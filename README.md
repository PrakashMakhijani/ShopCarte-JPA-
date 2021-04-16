# ShopCarte-JPA-
Shopping Application using JPA

create a clas call
Product {
   productid
   productname
   productdesc
}

Price {
     priceId;
     productId
   
}

Customer {
    List<Product> items
    id
    name
    OrderDate
}

--** Spring with Spring Boot framework **
-- **Used API documentation - Code first Design Approach **
-- Used H2 Memory data base to store Data 
-- Hibernate with JPA API
-- Information and Data is been looged using looging framework

**In Developing **
Shooping cartis a service- Where you will see methods of list Customers by ID and their Ordered Products
