package com.srin.bistro;

import com.srin.bistro.model.Category;
import com.srin.bistro.model.Chef;
import com.srin.bistro.model.Ingredient;
import com.srin.bistro.model.Recipe;
import com.srin.bistro.repository.CategoryRepository;
import com.srin.bistro.repository.ChefRepository;
import com.srin.bistro.repository.IngredientRepository;
import com.srin.bistro.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

/**
 * Created by SRIN on 10/11/2016.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category catMain = new Category("Main");
        Category catPudding = new Category("Pudding");

        categoryRepository.save(new HashSet<Category>() {{
            add(catMain);
            add(catPudding);
        }});

        Chef chefLorna = new Chef("Lorna");

        chefRepository.save(new HashSet<Chef>() {{
            add(chefLorna);
        }});

        Ingredient apple = new Ingredient("apple");
        Ingredient banana = new Ingredient("banana");
        Ingredient kiwiFruit = new Ingredient("kiwi fruit");
        Ingredient strawberries = new Ingredient("strawberries");
        Ingredient flour = new Ingredient("flour");
        Ingredient fruitJuice = new Ingredient("fruit juice");
        Ingredient butter = new Ingredient("butter");
        Ingredient sugar = new Ingredient("sugar");

        ingredientRepository.save(new HashSet<Ingredient>() {{
            add(apple);
            add(banana);
            add(kiwiFruit);
            add(strawberries);
            add(flour);
            add(fruitJuice);
            add(butter);
            add(sugar);
        }});

        Recipe appleCrumble = new Recipe(
                "Apple Crumble",
                "Traditional pudding with crunchy crumble layered over sweet fruit and baked",
                new HashSet<Ingredient>(){{
                    add(apple);
                    add(flour);
                    add(butter);
                    add(sugar);
                }},
                catPudding,
                chefLorna
        );

        Recipe fruitSalad = new Recipe(
                "Fruit Salad",
                "Combination of in-season fruits, covered with fruit juice and served chilled",
                new HashSet<Ingredient>(){{
                    add(apple);
                    add(banana);
                    add(kiwiFruit);
                    add(strawberries);
                    add(fruitJuice);
                }},
                catPudding,
                chefLorna
        );

        Recipe weekdayRisotto = new Recipe(
                "Weekday Risotto",
                "Creamy rice-based dish, boosted by in-season ingredients.",
                new HashSet<Ingredient>(),
                catMain,
                chefLorna
        );

        Recipe beansChili = new Recipe(
                "Beans Chili",
                "Vegetarian version of the popular spicy stew, containing mostly beans and vegetables",
                new HashSet<Ingredient>(),
                catMain,
                chefLorna
        );

        Recipe chickenCasserole = new Recipe(
                "Chicken Casserole",
                "Family recipe for a tasty, comforting casserole with chicken, tomato and carrots",
                new HashSet<Ingredient>(),
                catMain,
                chefLorna
        );

        Recipe recipeA = new Recipe(
                "Recipe A",
                "Recipe A description",
                new HashSet<Ingredient>(),
                catMain,
                chefLorna
        );

        Recipe recipeB = new Recipe(
                "Recipe B",
                "Recipe B description",
                new HashSet<Ingredient>(),
                catPudding,
                chefLorna
        );

        recipeRepository.save(new HashSet<Recipe>(){{
            add(appleCrumble);
            add(fruitSalad);
            add(weekdayRisotto);
            add(beansChili);
            add(chickenCasserole);
            add(recipeA);
            add(recipeB);
        }});

        catMain.setRecipes(new HashSet<Recipe>(){{
            add(weekdayRisotto);
            add(beansChili);
            add(chickenCasserole);
            add(recipeA);
        }});

        catPudding.setRecipes(new HashSet<Recipe>(){{
            add(appleCrumble);
            add(fruitSalad);
            add(recipeB);
        }});

        chefLorna.setRecipes(new HashSet<Recipe>() {{
            add(appleCrumble);
            add(fruitSalad);
            add(weekdayRisotto);
            add(beansChili);
            add(chickenCasserole);
            add(recipeA);
            add(recipeB);
        }});
    }
}
