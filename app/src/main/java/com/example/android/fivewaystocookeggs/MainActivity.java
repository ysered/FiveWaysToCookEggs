package com.example.android.fivewaystocookeggs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.fivewaystocookeggs.binding.RecipeBindingAdapter;
import com.example.android.fivewaystocookeggs.database.RecipesDataSource;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recipesRecyclerView = (RecyclerView) findViewById(R.id.recipes_recycler_view);
        recipesRecyclerView.setHasFixedSize(true);

        try {
            List<Recipe> recipes2 = getRecipes();
            Log.d("Recipes: ", recipes2.toString());

            final RecipeBindingAdapter recipeBindingAdapter =
                    new RecipeBindingAdapter(this, this, recipes2);
            recipesRecyclerView.setAdapter(recipeBindingAdapter);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle error
        }
    }

    private List<Recipe> getRecipes() throws IOException {
        final RecipesDataSource dataSource = new RecipesDataSource(this);
        return dataSource.getRecipes();
    }

}
