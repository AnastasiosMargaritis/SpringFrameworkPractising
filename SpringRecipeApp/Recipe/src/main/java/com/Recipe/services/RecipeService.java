package com.Recipe.services;

import com.Recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();
}