package com.srin.bistro.repository;

import com.srin.bistro.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by SRIN on 10/11/2016.
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT cat FROM Category cat WHERE LOWER(cat.name) = LOWER(:name)")
    List<Category> find(@Param("name") String name);

    List<Category> findByName(@Param("name") String name);
}
