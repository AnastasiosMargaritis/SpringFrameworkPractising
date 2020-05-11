package com.Recipe.controllers;

import com.Recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    private String getIndexPage(Model model){

        log.debug("Getting Index Page...");

        model.addAttribute("recipes", recipeService.getAllRecipes());


        return "index";
    }
}
