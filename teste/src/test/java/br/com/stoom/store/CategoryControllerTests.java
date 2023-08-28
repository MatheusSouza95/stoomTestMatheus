package br.com.stoom.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.com.stoom.store.business.CategoryBO;
import br.com.stoom.store.controller.CategoryController;
import br.com.stoom.store.model.Category;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryControllerTests {

    private CategoryBO categoryServiceMock = mock(CategoryBO.class);
    private ModelMapper mapperMock = mock(ModelMapper.class);
    private CategoryController categoryController = new CategoryController(categoryServiceMock,mapperMock);

    @Test
    public void testFindAll() {
        // Cenário de teste
        List<Category> mockCategoryList = new ArrayList<>();
        when(categoryServiceMock.findAll()).thenReturn(mockCategoryList);

        // Executar a função
        ResponseEntity<List<Category>> response = categoryController.findAll(Optional.of(Boolean.TRUE));

        // Verificar resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCategoryList, response.getBody());
    }

}