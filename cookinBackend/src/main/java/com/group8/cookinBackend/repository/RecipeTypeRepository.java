package com.group8.cookinBackend.repository;

import com.group8.cookinBackend.entity.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeTypeRepository extends JpaRepository<RecipeType, Integer> {
}
