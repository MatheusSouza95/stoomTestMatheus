package br.com.stoom.store.repository;

import br.com.stoom.store.model.Category;
import br.com.stoom.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p from Product p where p.brand.id =:brand and p.active =:active")
    List<Product> findByBrand(Long brand, boolean active);


    @Query(value = "select p from Product p where p.category.id =:category and p.active =:active")
    List<Product> findByCategory(Long category, boolean active);

    List<Product> findByActive(boolean active);

}