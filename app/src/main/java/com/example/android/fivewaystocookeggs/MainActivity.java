package com.example.android.fivewaystocookeggs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.android.fivewaystocookeggs.adapter.RecipeCardsAdapter;
import com.example.android.fivewaystocookeggs.adapter.RecipeViewHolder;
import com.example.android.fivewaystocookeggs.data.Recipe;
import com.example.android.fivewaystocookeggs.data.RecipeDataSource;

public class MainActivity extends AppCompatActivity implements RecipeViewHolder.OnClickListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recipesRecyclerView = (RecyclerView) findViewById(R.id.recipes_recycler_view);
        recipesRecyclerView.setHasFixedSize(true);

        Recipe[] recipes = new RecipeDataSource(this).getRecipes();
        RecyclerView.Adapter adapter = new RecipeCardsAdapter(recipes, this);
        recipesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onCardClicked(RecipeViewHolder holder, Recipe recipe) {
        Log.d(MainActivity.class.getCanonicalName(), "clicked on card");
        final Intent recipeActivityIntent = new Intent(this, RecipeActivity.class);
        recipeActivityIntent.putExtra(RecipeActivity.RECIPE_PARCELABLE, recipe);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> image = Pair.create(
                    (View) holder.recipeImageView,
                    holder.recipeImageView.getTransitionName());

            Pair<View, String> title = Pair.create(
                    (View) holder.recipeTitleTextView,
                    holder.recipeTitleTextView.getTransitionName());

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, image, title);

            startActivity(recipeActivityIntent, options.toBundle());
        } else {
            startActivity(recipeActivityIntent);
        }
    }

    @Override
    public void onShareButtonClicked(RecipeViewHolder holder, Recipe recipe) {
        Log.d(LOG_TAG, "share button clicked");
        ShareAction.share(this, this, recipe);
    }

}
