package com.example.android.fivewaystocookeggs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.fivewaystocookeggs.data.Recipe;

public class RecipeActivity extends AppCompatActivity {

    public static final String RECIPE_PARCELABLE = "recipe_parcelable";

    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecipe = getIntent().getParcelableExtra(RECIPE_PARCELABLE);

        ImageView recipeImageView = (ImageView) findViewById(R.id.recipe_image_view);
        recipeImageView.setImageResource(mRecipe.imageResource);

        TextView recipeTitleTextView = (TextView) findViewById(R.id.recipe_title_text_view);
        recipeTitleTextView.setText(mRecipe.title);

        TextView recipeIngredientsTextView = (TextView) findViewById(R.id.recipe_ingredients_text_view);
        recipeIngredientsTextView.setText(mRecipe.ingredients);

        TextView recipeDetailsTextView = (TextView) findViewById(R.id.recipe_details_text_view);
        recipeDetailsTextView.setText(mRecipe.details);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (R.id.menu_action_share == item.getItemId()) {
            ShareAction.share(this, this, mRecipe);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
