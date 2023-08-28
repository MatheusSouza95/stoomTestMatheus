package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.ICategoryBO;
import br.com.stoom.store.exceptions.DataNotFoundException;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;
import br.com.stoom.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBO implements ICategoryBO {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Category not found"));
    }


    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @Override
    public void insert(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> findByActive(boolean active) {
        return categoryRepository.findByActive(active);
    }

}
