package com.srin.bistro.repository;

import com.srin.bistro.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * Created by SRIN on 10/11/2016.
 */
@RepositoryRestResource(collectionResourceRel = "recipe", path = "recipes")
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Integer> {

    List<Recipe> findbyid(@Param("id") int id);

    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) = LOWER(:name)")
    List<Recipe> findbyname(@Param("name") String name);

    List<Recipe> findById(@Param("id") int id);
    List<Recipe> findByName(@Param("name") String name);

    @Query("SELECT r FROM Recipe r WHERE r.name = :name AND r.description = :description")
    Optional<Recipe> findByNameAndDescription(@Param("name") String name, @Param("description") String description);

    @Query(value = "SELECT * FROM recipe r WHERE r.name = :name AND r.description = :description", nativeQuery = true)
    Optional<Recipe> findByNamaDanDeskripsi(@Param("name") String name, @Param("description") String description);
}
