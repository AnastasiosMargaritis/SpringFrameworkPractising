package com.Recipe.services.impl;

import com.Recipe.domain.Recipe;
import com.Recipe.repositories.RecipeRepository;
import com.Recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {

        log.debug("Get All Recipes");

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {


        Optional<Recipe> recipe = recipeRepository.findById(id);

        if(!recipe.isPresent()){
            throw  new RuntimeException("Recipe Not Found!");
        }

        return recipe;
    }


}
