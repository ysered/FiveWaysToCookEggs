package com.example.android.fivewaystocookeggs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeCardOnClickHandler implements CardView.OnClickListener {

    private final Context mContext;
    private final Activity mActivity;
    private final Recipe mRecipe;
    private final ImageView mRecipeImageView;
    private final TextView mRecipeTitleTextView;

    public RecipeCardOnClickHandler(Context context, Activity activity, Recipe recipe, CardView recipeCardView) {
        mContext = context;
        mActivity = activity;
        mRecipe = recipe;
        mRecipeImageView = (ImageView) recipeCardView.findViewById(R.id.recipe_image_view);
        mRecipeTitleTextView = (TextView) recipeCardView.findViewById(R.id.card_title_text_view);
    }

    @Override
    public void onClick(View v) {
        final Intent recipeActivityIntent = new Intent(mContext, RecipeActivity.class);
        recipeActivityIntent.putExtra(RecipeActivity.RECIPE_PARCELABLE, mRecipe);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> image = Pair.create(
                    (View) mRecipeImageView,
                    mContext.getString(R.string.recipe_image_transition_name));

            Pair<View, String> title = Pair.create(
                    (View) mRecipeTitleTextView,
                    mContext.getString(R.string.recipe_title_transition_name));

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            mActivity, image, title);

            mContext.startActivity(recipeActivityIntent, options.toBundle());
        } else {
            mContext.startActivity(recipeActivityIntent);
        }
    }

}
