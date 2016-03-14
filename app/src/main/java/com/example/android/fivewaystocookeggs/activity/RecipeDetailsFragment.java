package com.example.android.fivewaystocookeggs.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.model.Recipe;


public class RecipeDetailsFragment extends Fragment {

    private Recipe mRecipe;

    public void setRecipe(Recipe recipe) {
        mRecipe = recipe;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recipe_details, container, false);
        if (mRecipe != null) {
            final ImageView recipeImageView =
                    (ImageView) v.findViewById(R.id.recipe_image_view);
            recipeImageView.setImageResource(mRecipe.imageResource);

            final TextView recipeTitleTextView =
                    (TextView) v.findViewById(R.id.recipe_title_text_view);
            recipeTitleTextView.setText(mRecipe.title);

            final TextView recipeIngredientsTextView =
                    (TextView) v.findViewById(R.id.recipe_ingredients_text_view);
            recipeIngredientsTextView.setText(mRecipe.ingredients);

            final TextView recipeDetailsTextView =
                    (TextView) v.findViewById(R.id.recipe_details_text_view);
            recipeDetailsTextView.setText(mRecipe.details);
            /*RecipeDetailsBinding binding = DataBindingUtil
                    .inflate(inflater, R.layout.fragment_recipe_details, container, false);
            binding.setRecipe(mRecipe);*/
        }
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_recipe_details, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_action_share) {
            Log.d(getClass().getCanonicalName(), "Share menu item selected");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
