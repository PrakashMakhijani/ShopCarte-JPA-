package my.learning.shopcartdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {
    @Id
    private Integer productID;
    private String productName;
    private String productDesc;

    @OneToOne
    @JoinColumn(name ="prodPrice")
    private Price price;
    @ManyToMany
    @Builder.Default
    private List<Customer> customer =  new ArrayList<>();





}
