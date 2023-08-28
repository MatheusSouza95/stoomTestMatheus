package br.com.stoom.store.controller;

import br.com.stoom.store.business.BrandBO;
import br.com.stoom.store.dto.BrandDTO;
import br.com.stoom.store.model.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/brands")
public class BrandController {


    private final BrandBO brandService;
    private final ModelMapper mapper;

    @Autowired
    public BrandController(BrandBO brandService, ModelMapper mapper) {
        this.brandService = brandService;
        this.mapper = mapper;
    }


    @GetMapping(value = "/")
    public ResponseEntity<List<Brand>> findAll(@RequestParam("active") Optional<Boolean> active) {
        List<Brand> brandList = new ArrayList<>();

        if(active.isPresent()){
            brandList = brandService.findByActive(active.get());
        }else{
           brandList = brandService.findAll();
        }

        if(!brandList.isEmpty())
            return new ResponseEntity<>(brandList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Brand> findById(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(brand);

    }

    @PostMapping(value = "/")
    public ResponseEntity<BrandDTO> insert(@Valid @RequestBody BrandDTO dto) {
        Brand brand = convertToEntity(dto);
        brandService.insert(brand);
        dto.setId(brand.getId());
        return  ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Void> update(@Valid @RequestBody BrandDTO dto) {
        Brand brand = convertToEntity(dto);
        brandService.update(brand);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        brandService.delete(brand);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    private BrandDTO convertToDTO(Brand brand) {
        return mapper.map(brand, BrandDTO.class);
    }

    private Brand convertToEntity(BrandDTO dto) {
        return mapper.map(dto, Brand.class);
    }

}
