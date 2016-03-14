package com.example.android.fivewaystocookeggs.activity.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.model.Recipe;


public class RecipeCardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public interface OnClickListener {

        void onCardClicked(CardView cardView, Recipe recipe);

        void onShareButtonClicked(Button button, Recipe recipe);

    }

    public final CardView cardView;
    public final TextView recipeTitleTextView;
    public final TextView recipeIngredientsTextView;
    public final ImageView recipeImageView;
    public final Button shareButton;

    private final Recipe[] mRecipes;
    private final OnClickListener mListener;

    public RecipeCardHolder(View itemView, Recipe[] recipes, OnClickListener listener) {
        super(itemView);
        mRecipes = recipes;
        mListener = listener;

        cardView = (CardView) itemView.findViewById(R.id.recipe_card_view);
        recipeTitleTextView = (TextView) cardView.findViewById(R.id.card_title_text_view);
        recipeIngredientsTextView = (TextView) cardView.findViewById(R.id.card_ingredients_line_text_view);
        recipeImageView = (ImageView) cardView.findViewById(R.id.recipe_image_view);
        shareButton = (Button) cardView.findViewById(R.id.share_button);

        cardView.setOnClickListener(this);
        shareButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Recipe recipe = mRecipes[getAdapterPosition()];
        switch (v.getId()) {
            case R.id.recipe_card_view:
                mListener.onCardClicked(cardView, recipe);
                break;
            case R.id.share_button:
                mListener.onShareButtonClicked(shareButton, recipe);
                break;
        }
    }

}