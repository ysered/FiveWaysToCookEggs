package com.example.android.fivewaystocookeggs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.fivewaystocookeggs.binding.RecipeBindingAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recipesRecyclerView = (RecyclerView) findViewById(R.id.recipes_recycler_view);
        recipesRecyclerView.setHasFixedSize(true);

        final RecipeBindingAdapter recipeBindingAdapter =
                new RecipeBindingAdapter(this, this, getRecipes());
        recipesRecyclerView.setAdapter(recipeBindingAdapter);
    }

    private Recipe[] getRecipes() {
        return new Recipe[] {
                new Recipe(
                        R.drawable.egg_in_bread,
                        getString(R.string.eggs_in_bread),
                        getString(R.string.eggs_in_bread_ingredients_line),
                        getString(R.string.eggs_in_bread_ingredients),
                        getString(R.string.eggs_in_bread_details)
                ),
                new Recipe(
                        R.drawable.french_eggs,
                        getString(R.string.french_eggs),
                        getString(R.string.french_eggs_ingredients_line),
                        getString(R.string.french_eggs_ingredients),
                        getString(R.string.french_eggs_details)
                ),
                new Recipe(
                        R.drawable.eggs_in_tomatoes,
                        getString(R.string.eggs_in_tomatoes),
                        getString(R.string.eggs_in_tomatoes_ingredients_line),
                        getString(R.string.eggs_in_tomatoes_ingredients),
                        getString(R.string.eggs_in_tomatoes_details)
                ),
                new Recipe(
                        R.drawable.eggs_in_baskets,
                        getString(R.string.eggs_in_baskets),
                        getString(R.string.eggs_in_baskets_ingredients_line),
                        getString(R.string.eggs_in_baskets_ingredients),
                        getString(R.string.eggs_in_baskets_details)
                ),
                new Recipe(
                        R.drawable.eggs_by_author,
                        getString(R.string.eggs_by_author),
                        getString(R.string.eggs_by_author_ingredients_line),
                        getString(R.string.eggs_by_author_ingredients),
                        getString(R.string.eggs_by_author_details)
                )
        };
    }

}
