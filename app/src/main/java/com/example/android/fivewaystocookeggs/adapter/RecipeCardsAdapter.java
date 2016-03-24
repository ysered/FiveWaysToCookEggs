package com.example.android.fivewaystocookeggs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.data.Recipe;

public class RecipeCardsAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final Recipe[] mRecipes;
    private final RecipeViewHolder.OnClickListener mListener;

    public RecipeCardsAdapter(Recipe[] recipes, RecipeViewHolder.OnClickListener listener) {
        mRecipes = recipes;
        mListener = listener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_card_view, parent, false);
        return new RecipeViewHolder(v, mRecipes, mListener);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
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
