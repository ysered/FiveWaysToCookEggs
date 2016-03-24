package com.example.android.fivewaystocookeggs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recipesRecyclerView = (RecyclerView) findViewById(R.id.recipes_recycler_view);
        recipesRecyclerView.setHasFixedSize(true);

        final Recipe[] recipes = new RecipeDataSource(this).getRecipes();
        final RecyclerView.Adapter adapter =
                new RecipeCardsAdapter(this, MainActivity.this, recipes);
        recipesRecyclerView.setAdapter(adapter);
    }

}
