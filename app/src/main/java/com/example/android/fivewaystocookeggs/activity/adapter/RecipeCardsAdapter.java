package com.example.android.fivewaystocookeggs.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.model.Recipe;


public class RecipeCardsAdapter extends RecyclerView.Adapter<RecipeCardHolder> {

    private final Recipe[] mRecipes;
    private final RecipeCardHolder.OnClickListener mListener;

    public RecipeCardsAdapter(Recipe[] recipes, RecipeCardHolder.OnClickListener listener) {
        mRecipes = recipes;
        mListener = listener;
    }

    @Override
    public RecipeCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_card_view, parent, false);
        return new RecipeCardHolder(v, mRecipes, mListener);
    }

    @Override
    public void onBindViewHolder(RecipeCardHolder holder, int position) {
        final Recipe recipe = mRecipes[position];
        holder.recipeImageView.setImageResource(recipe.imageResource);
        holder.recipeTitleTextView.setText(recipe.title);
        holder.recipeIngredientsTextView.setText(recipe.ingredientsLine);
    }

    @Override
    public int getItemCount() {
        return mRecipes.length;
    }

}
