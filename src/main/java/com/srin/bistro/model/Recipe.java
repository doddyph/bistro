package com.srin.bistro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by SRIN on 10/11/2016.
 */
@Entity
@NamedQuery(name = "Recipe.findbyid",
    query = "SELECT r FROM Recipe r WHERE r.id = :id")
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "recipe_ingredient",
        joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;

    public Recipe() {
    }

    public Recipe(String name, String description, Set<Ingredient> ingredients, Category category, Chef chef) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.category = category;
        this.chef = chef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}
