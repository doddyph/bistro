package com.srin.bistro.repository;

import com.srin.bistro.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by SRIN on 10/12/2016.
 */
@RepositoryRestResource(collectionResourceRel = "ingredient", path = "ingredients")
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    @Query("SELECT i FROM Ingredient i WHERE LOWER(i.item) = LOWER(:name)")
    List<Ingredient> find(@Param("name") String name);

    List<Ingredient> findByItem(@Param("name") String name);
}
