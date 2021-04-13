package my.learning.shopcartdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@AttributeOverride(name = "ProducID", column = @Column(name ="productID"))
public class Price {

    @Id
    private Integer priceid;
    //private Product product;
     private int prodPrice;

}
