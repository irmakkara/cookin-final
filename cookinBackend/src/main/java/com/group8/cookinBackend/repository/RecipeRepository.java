package com.group8.cookinBackend.repository;

import com.group8.cookinBackend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query("SELECT s FROM Recipe s  WHERE s.recipeType.recipetypeid = :recipetypeid")
    List<Recipe> findByRecipeTypeId(@Param("recipetypeid") int recipetypeid);

    @Query("SELECT r FROM Recipe r WHERE r.eventType.eventtypesid = :eventtypesid")
    List<Recipe> findByEventTypeId(@Param("eventtypesid") int eventtypesid);
}
