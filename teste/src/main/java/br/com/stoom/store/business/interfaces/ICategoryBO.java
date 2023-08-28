package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Brand;
import br.com.stoom.store.model.Category;

import java.util.List;

public interface ICategoryBO {

    Category findById(Long id);

    List<Category> findAll();

    void insert(Category category);

    void update(Category category);

    void delete(Category category);

    List<Category> findByActive(boolean active);

}
