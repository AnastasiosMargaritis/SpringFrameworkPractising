package com.dto.DTO.mapper;

import com.dto.DTO.domain.Category;
import com.dto.DTO.model.CategoryDTO;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }
}
