package br.com.stoom.store.controller;

import br.com.stoom.store.business.CategoryBO;
import br.com.stoom.store.dto.CategoryDTO;
import br.com.stoom.store.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/categories")
public class CategoryController {


    private CategoryBO categoryService;
    private final ModelMapper mapper;

    @Autowired
    public CategoryController(CategoryBO categoryService, ModelMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> findAll(@RequestParam("active") Optional<Boolean> active) {

        List<Category> categoryList = new ArrayList<>();

        if(active.isPresent()){
            categoryList = categoryService.findByActive(active.get());
        }else{
            categoryList = categoryService.findAll();
        }

        if(!categoryList.isEmpty())
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(category);


    }

    @PostMapping(value = "/")
    public ResponseEntity <CategoryDTO> insert(@Valid @RequestBody CategoryDTO dto) {
        Category category = convertToEntity(dto);
        categoryService.insert(category);
        dto.setId(category.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @PutMapping(value = "/")
    public ResponseEntity <CategoryDTO> update(@Valid @RequestBody CategoryDTO dto) {
        Category category = convertToEntity(dto);
        categoryService.update(category);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <CategoryDTO> update(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    private CategoryDTO convertToDTO(Category category) {
        return mapper.map(category, CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO dto) {
        return mapper.map(dto, Category.class);
    }

}
