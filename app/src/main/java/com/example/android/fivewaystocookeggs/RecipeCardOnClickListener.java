package com.example.android.fivewaystocookeggs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.view.View;

public class RecipeCardOnClickListener implements CardView.OnClickListener {

    private final Context mContext;
    private final Activity mActivity;
    private final Recipe mRecipe;
    private final RecipeCardsAdapter.RecipeViewHolder mHolder;

    public RecipeCardOnClickListener(Context context, Activity activity, Recipe recipe,
                                     RecipeCardsAdapter.RecipeViewHolder holder) {
        mContext = context;
        mActivity = activity;
        mRecipe = recipe;
        mHolder = holder;
    }

    @Override
    public void onClick(View v) {
        final Intent recipeActivityIntent = new Intent(mContext, RecipeActivity.class);
        recipeActivityIntent.putExtra(RecipeActivity.RECIPE_PARCELABLE, mRecipe);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> image = Pair.create(
                    (View) mHolder.recipeImageView,
                    mHolder.recipeImageView.getTransitionName());

            Pair<View, String> title = Pair.create(
                    (View) mHolder.recipeTitleTextView,
                    mHolder.recipeTitleTextView.getTransitionName());

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            mActivity, image, title);

            mContext.startActivity(recipeActivityIntent, options.toBundle());
        } else {
            mContext.startActivity(recipeActivityIntent);
        }
    }

}
