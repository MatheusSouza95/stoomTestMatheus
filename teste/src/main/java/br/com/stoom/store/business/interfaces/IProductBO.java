package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Category;
import br.com.stoom.store.model.Product;

import java.util.List;

public interface IProductBO {

    Product findById(Long id);

    List<Product> findAll();

    void insert(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findByBrand(Long brand,boolean active);

    List<Product> findByCategory(Long category,boolean active);

    List<Product> findByActive(boolean active);


}
