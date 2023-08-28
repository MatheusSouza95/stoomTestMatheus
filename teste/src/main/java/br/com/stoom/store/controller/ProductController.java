package br.com.stoom.store.controller;

import br.com.stoom.store.business.ProductBO;
import br.com.stoom.store.dto.ProductDTO;
import br.com.stoom.store.model.Product;
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
@RequestMapping("/api/products")
public class ProductController {
    private ProductBO productService;
    private final ModelMapper mapper;

    @Autowired
    public ProductController(ProductBO productService, ModelMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> findAll(@RequestParam("active") Optional<Boolean> active) {
        List<Product> productList = new ArrayList<>();

        if(active.isPresent()){
            productList = productService.findByActive(active.get());
        }else{
            productList = productService.findAll();
        }
        if(!productList.isEmpty())
            return new ResponseEntity<>(productList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/brand/{brand}")
    public ResponseEntity<List<Product>> findAllByBrand(@PathVariable Long brand, @RequestParam("active") Optional<Boolean> active) {
        List<Product>  productList = productService.findByBrand(brand,active.isPresent()?active.get():true);

        if(!productList.isEmpty())
            return new ResponseEntity<>(productList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/category/{category}")
    public ResponseEntity<List<Product>> findAllByCategory(@PathVariable Long category, @RequestParam("active") Optional<Boolean> active) {
        List<Product>  productList = productService.findByCategory(category,active.isPresent()?active.get():true);

        if(!productList.isEmpty())
            return new ResponseEntity<>(productList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ProductDTO> insert(@Valid  @RequestBody ProductDTO dto) {
        Product product = convertToEntity(dto);
        productService.insert(product);
        dto.setId(product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @PutMapping(value = "/")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO dto) {
        Product product = convertToEntity(dto);
        productService.update(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id) {
        Product product = productService.findById(id);
        productService.delete(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    private ProductDTO convertToDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return mapper.map(productDTO, Product.class);
    }

}
