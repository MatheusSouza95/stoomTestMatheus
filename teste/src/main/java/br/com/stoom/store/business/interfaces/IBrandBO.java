package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Brand;

import java.util.List;

public interface IBrandBO {

    Brand findById(Long id);

    List<Brand> findAll();

    List<Brand> findByActive(boolean active);

    void insert(Brand brand);

    void update(Brand brand);

    void delete(Brand brand);
}
