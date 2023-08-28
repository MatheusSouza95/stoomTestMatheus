package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.IProductBO;
import br.com.stoom.store.exceptions.DataNotFoundException;
import br.com.stoom.store.model.Product;
import br.com.stoom.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBO implements IProductBO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));
    }
    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findByBrand(Long brand, boolean active) {
        return productRepository.findByBrand(brand,active);
    }

    @Override
    public List<Product> findByCategory(Long category, boolean active) {
        return productRepository.findByCategory(category,active);
    }


    @Override
    public List<Product> findByActive(boolean active) {
        return productRepository.findByActive(active);
    }



}
