package com.group8.cookinBackend.controller;

import com.group8.cookinBackend.dto.*;
import com.group8.cookinBackend.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class RecipeController {
    private final RecipeService recipeService;
    private final EventTypeService eventTypeService;
    private final RecipeTypeService recipeTypeService;
    private final SavedRecipesService savedRecipesService;
    private final UserService userService;


    public RecipeController(RecipeService recipeService, EventTypeService eventTypeService, RecipeTypeService recipeTypeService, SavedRecipesService savedRecipesService, UserService userService) {
        this.recipeService = recipeService;
        this.eventTypeService = eventTypeService;
        this.recipeTypeService = recipeTypeService;
        this.savedRecipesService = savedRecipesService;
        this.userService = userService;
    }

    @GetMapping("/recipes/EventTypes")
    public List<EventTypeDto> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    @PostMapping("/recipes")
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto createdRecipe = recipeService.createRecipe(recipeDto);
        return ResponseEntity.ok(createdRecipe);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable int id) {
        RecipeDto recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        List<RecipeDto> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }


    @GetMapping("recipes/RecipeTypes")
    public ResponseEntity<List<RecipeTypeDto>> getAllRecipeTypes() {
        List<RecipeTypeDto> recipeTypes = recipeTypeService.getAllRecipeTypes();
        return ResponseEntity.ok(recipeTypes);
    }


    @PostMapping("/SavedRecipes")
    public ResponseEntity<SavedRecipesDto> createSavedRecipe(@RequestParam String email,@RequestParam int recipeid) {

      UserDto userDto=  userService.getUserByEmail(email);

      SavedRecipesDto savedRecipesDto = new SavedRecipesDto();
      savedRecipesDto.setUserid(userDto.getId());
      savedRecipesDto.setRecipeid(recipeid);
      SavedRecipesDto createdSavedRecipe = savedRecipesService.createSavedRecipe(savedRecipesDto);

      return ResponseEntity.ok(createdSavedRecipe);
    }

    @GetMapping("/SavedRecipes/{id}")
    public ResponseEntity<SavedRecipesDto> getSavedRecipeById(@PathVariable int id) {
        SavedRecipesDto savedRecipe = savedRecipesService.getSavedRecipeById(id);
        return ResponseEntity.ok(savedRecipe);
    }

    @GetMapping("/SavedRecipes")
    public ResponseEntity<List<SavedRecipesDto>> getAllSavedRecipes() {
        List<SavedRecipesDto> savedRecipes = savedRecipesService.getAllSavedRecipes();
        return ResponseEntity.ok(savedRecipes);
    }

    @DeleteMapping("/SavedRecipes/{id}")
    public ResponseEntity<Void> deleteSavedRecipe(@PathVariable int id) {
        savedRecipesService.deleteSavedRecipe(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/savedrecipes/user/{userId}")
    public ResponseEntity<List<RecipeDto>> getSavedRecipesByUserId(@PathVariable Long userId) {
        List<RecipeDto> savedRecipes = savedRecipesService.getSavedRecipesByUserId(userId);
        return ResponseEntity.ok(savedRecipes);
    }

    @GetMapping("/recipes/RecipeTypes/{id}")
    public ResponseEntity<RecipeTypeDto> getRecipeTypeById(@PathVariable int id) {
        RecipeTypeDto recipeType = recipeTypeService.getRecipeTypeById(id);
        return ResponseEntity.ok(recipeType);
    }

    @GetMapping("/recipes/RecipeType/{recipetypeid}")
    public ResponseEntity<List<RecipeDto>> getRecipesByTypeId(@PathVariable int recipetypeid) {
        List<RecipeDto> recipeTypes = recipeService.getRecipesByTypeId(recipetypeid);
        return ResponseEntity.ok(recipeTypes);
    }

    @GetMapping("/recipes/EventType/{eventtypesid}")
    public ResponseEntity<List<RecipeDto>> getRecipesByEventTypeId(@PathVariable int eventtypesid) {
        List<RecipeDto> recipeTypes = recipeService.getRecipesByEventTypeId(eventtypesid);
        return ResponseEntity.ok(recipeTypes);
    }

    @PostMapping("/recipes/RecipeTypes")
    public ResponseEntity<RecipeTypeDto> createRecipeType(@RequestBody RecipeTypeDto recipeTypeDto) {
        RecipeTypeDto createdRecipeType = recipeTypeService.createRecipeType(recipeTypeDto);
        return ResponseEntity.ok(createdRecipeType);
    }

}
