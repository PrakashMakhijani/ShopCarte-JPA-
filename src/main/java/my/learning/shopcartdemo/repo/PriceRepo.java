package my.learning.shopcartdemo.repo;

import my.learning.shopcartdemo.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Integer> {
}
