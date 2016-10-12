package com.srin.bistro.repository;

import com.srin.bistro.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by SRIN on 10/11/2016.
 */
@RepositoryRestResource(collectionResourceRel = "chef", path = "chefs")
public interface ChefRepository extends JpaRepository<Chef, Integer> {

    @Query("SELECT ch FROM Chef ch WHERE LOWER(ch.name) = LOWER(:name)")
    List<Chef> find(@Param("name") String name);

    List<Chef> findByName(@Param("name") String name);
}
