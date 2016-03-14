package com.example.android.fivewaystocookeggs;

import android.support.v7.widget.CardView;
import android.view.View;


public class RecipeCardOnClickListener implements CardView.OnClickListener {

    /*private final Context mContext;
    private final Activity mActivity;
    private final Recipe mRecipe;
    private final RecipeCardsAdapter.RecipeCardHolder mHolder;

    public RecipeCardOnClickListener(Context mContext, Activity mActivity, Recipe mRecipe,
                                     RecipeCardsAdapter.RecipeCardHolder mHolder) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mRecipe = mRecipe;
        this.mHolder = mHolder;
    }*/

    @Override
    public void onClick(View v) {
        /*final Intent recipeActivityIntent = new Intent(mContext, RecipeActivity.class);
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
        }*/
    }

}
