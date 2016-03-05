package com.example.android.fivewaystocookeggs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.fivewaystocookeggs.databinding.ActivityRecipeBinding;

public class RecipeActivity extends AppCompatActivity {

    public static final String RECIPE_PARCELABLE = "recipe_parcelable";
    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRecipe = getIntent().getParcelableExtra(RECIPE_PARCELABLE);
        ActivityRecipeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe);
        binding.setRecipe(mRecipe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_share:
                ShareAction.share(this, this, mRecipe);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
