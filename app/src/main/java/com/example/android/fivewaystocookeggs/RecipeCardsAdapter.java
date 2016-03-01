package com.example.android.fivewaystocookeggs;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeCardsAdapter extends RecyclerView.Adapter<RecipeCardsAdapter.RecipeViewHolder> {

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final TextView recipeTitleTextView;
        final TextView recipeIngredientsTextView;
        final ImageView recipeImageView;
        final Button shareButton;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            recipeTitleTextView = (TextView) cardView.findViewById(R.id.card_title_text_view);
            recipeIngredientsTextView = (TextView) cardView.findViewById(R.id.card_ingredients_line_text_view);
            recipeImageView = (ImageView) cardView.findViewById(R.id.recipe_image_view);
            shareButton = (Button) cardView.findViewById(R.id.share_button);
        }
    }

    private final Context mContext;
    private final Activity mActivity;
    private final Recipe[] mRecipes;

    public RecipeCardsAdapter(Context context, Activity activity, Recipe[] recipes) {
        mContext = context;
        mActivity = activity;
        mRecipes = recipes;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_card_view, parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        final Recipe recipe = mRecipes[position];
        holder.recipeImageView.setImageResource(recipe.imageResource);
        holder.recipeTitleTextView.setText(recipe.title);
        holder.recipeIngredientsTextView.setText(recipe.ingredientsLine);

        holder.shareButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareAction.share(mContext, mActivity, recipe);
            }
        });
        holder.cardView.setOnClickListener(
                new RecipeCardOnClickListener(mContext, mActivity, recipe, holder));
    }

    @Override
    public int getItemCount() {
        return mRecipes.length;
    }

}
