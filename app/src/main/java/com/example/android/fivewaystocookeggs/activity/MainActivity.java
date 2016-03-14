package com.example.android.fivewaystocookeggs.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.activity.adapter.RecipeCardHolder;
import com.example.android.fivewaystocookeggs.model.Recipe;


public class MainActivity extends AppCompatActivity implements RecipeCardHolder.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecipeCardsFragment fragment = new RecipeCardsFragment();
        fragment.setRetainInstance(true);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onCardClicked(CardView cardView, Recipe recipe) {
        Log.d(getClass().getCanonicalName(), "User clicked on a card view");

        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        fragment.setRecipe(recipe);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeImageTransform());
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setDuration(300);

            fragment.setSharedElementEnterTransition(transitionSet);
            fragment.setSharedElementReturnTransition(transitionSet);

            final ImageView imageView = (ImageView) cardView.findViewById(R.id.recipe_image_view);
            transaction.addSharedElement(
                    imageView, getString(R.string.recipe_image_transition_name));
        }

        transaction.commit();
    }

    @Override
    public void onShareButtonClicked(Button button, Recipe recipe) {
        Log.d(getClass().getCanonicalName(), "User clicked on a share button");
    }

}
