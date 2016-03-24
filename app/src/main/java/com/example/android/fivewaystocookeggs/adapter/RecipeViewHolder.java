package com.example.android.fivewaystocookeggs.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.data.Recipe;

public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public interface OnClickListener {

        void onCardClicked(RecipeViewHolder holder, Recipe recipe);

        void onShareButtonClicked(RecipeViewHolder holder, Recipe recipe);

    }

    private final Recipe[] mRecipes;
    private final OnClickListener mListener;

    public final CardView cardView;
    public final TextView recipeTitleTextView;
    public final TextView recipeIngredientsTextView;
    public final ImageView recipeImageView;
    public final Button shareButton;

    public RecipeViewHolder(View itemView, Recipe[] recipes, OnClickListener listener) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.card_view);
        recipeTitleTextView = (TextView) cardView.findViewById(R.id.card_title_text_view);
        recipeIngredientsTextView = (TextView) cardView.findViewById(R.id.card_ingredients_line_text_view);
        recipeImageView = (ImageView) cardView.findViewById(R.id.recipe_image_view);
        shareButton = (Button) cardView.findViewById(R.id.share_button);

        mRecipes = recipes;
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        final Recipe recipe = mRecipes[getAdapterPosition()];
        if (R.id.card_view == v.getId()) {
            mListener.onCardClicked(this, recipe);
        } else if (R.id.share_button == v.getId()) {
            mListener.onShareButtonClicked(this, recipe);
        }
    }

}
