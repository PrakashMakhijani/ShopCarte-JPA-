package my.learning.shopcartdemo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Integer id;

    @Column(name="CustomerName")
    private String name;

    @Column(name="OrderingDate")
    @Builder.Default
    private Instant orderDate = Instant.now();

  @ManyToMany
  @Builder.Default
  private List<Product> product = new ArrayList<>();


}
