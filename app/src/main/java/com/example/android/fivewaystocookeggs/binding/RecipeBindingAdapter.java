package com.example.android.fivewaystocookeggs.binding;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.Recipe;
import com.example.android.fivewaystocookeggs.RecipeCardOnClickHandler;
import com.example.android.fivewaystocookeggs.ShareAction;
import com.example.android.fivewaystocookeggs.databinding.RecipeCardViewBinding;

import java.util.List;

public class RecipeBindingAdapter extends BindingAdapter<RecipeCardViewBinding> {

    private final Context mContext;
    private final Activity mActivity;
    private final List<Recipe> mRecipes;

    public RecipeBindingAdapter(Context context, Activity activity, List<Recipe> recipes) {
        super(R.layout.recipe_card_view);
        mContext = context;
        mActivity = activity;
        mRecipes = recipes;
    }

    @Override
    protected void updateBinding(RecipeCardViewBinding binding, int position) {
        final Recipe recipe = mRecipes.get(position);
        binding.setRecipe(recipe);
        final CardView recipeCardView = (CardView) binding.getRoot();
        binding.setCardViewOnClickHandler(
                new RecipeCardOnClickHandler(mContext, mActivity, recipe, recipeCardView));
        binding.setShareButtonOnClickHandler(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareAction.share(mContext, mActivity, recipe);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

}
