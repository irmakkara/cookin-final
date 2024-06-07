package com.group8.cookinBackend.repository;

import com.group8.cookinBackend.entity.Recipe;
import com.group8.cookinBackend.entity.SavedRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecipesRepository extends JpaRepository<SavedRecipes, Integer> {
    @Query("SELECT r FROM Recipe r JOIN SavedRecipes s ON r.recipeid = s.recipe.recipeid WHERE s.user.id = :userId")
    List<Recipe> findSavedRecipesByUserId(@Param("userId") Long userId);

}
