package br.com.stoom.store.business;

import br.com.stoom.store.business.interfaces.IBrandBO;
import br.com.stoom.store.exceptions.DataNotFoundException;
import br.com.stoom.store.model.Brand;
import br.com.stoom.store.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandBO implements IBrandBO {

    @Autowired
    private BrandRepository brandRepository;


    @Override
    public Brand findById(Long id){
        return brandRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Brand not found"));
    }


    @Override
    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    @Override
    public List<Brand> findByActive(boolean active) {
        return brandRepository.findByActive(active);
    }

    @Override
    public void insert(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void update(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

}
