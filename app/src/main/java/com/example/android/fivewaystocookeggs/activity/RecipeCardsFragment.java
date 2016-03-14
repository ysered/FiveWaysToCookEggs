package com.example.android.fivewaystocookeggs.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.fivewaystocookeggs.R;
import com.example.android.fivewaystocookeggs.activity.adapter.RecipeCardsAdapter;
import com.example.android.fivewaystocookeggs.model.Recipe;
import com.example.android.fivewaystocookeggs.model.RecipeDataSource;

public class RecipeCardsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recipe_cards, container, false);
        final RecyclerView recyclerView =
                (RecyclerView) view.findViewById(R.id.recipes_recycler_view);
        setupRecyclerView(recyclerView);
        return view;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        final Recipe[] recipes = new RecipeDataSource(getContext()).getRecipes();
        final MainActivity activity = (MainActivity) getActivity();
        final RecyclerView.Adapter adapter = new RecipeCardsAdapter(recipes, activity);
        recyclerView.setAdapter(adapter);
    }

}
