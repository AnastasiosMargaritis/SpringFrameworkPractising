package com.dto.DTO.mapper;

import com.dto.DTO.domain.Category;
import com.dto.DTO.model.CategoryDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() throws Exception{

        Category category = new Category();
        category.setName("Fruits");
        category.setId(1L);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Fruits", categoryDTO.getName());
    }
}