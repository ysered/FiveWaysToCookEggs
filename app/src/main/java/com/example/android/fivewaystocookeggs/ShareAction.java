package com.example.android.fivewaystocookeggs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.widget.Toast;

import com.example.android.fivewaystocookeggs.data.Recipe;

public class ShareAction {

    public static void share(Context context, Activity activity, Recipe recipe) {
        final String emailText = String.format(context.getString(R.string.share_template),
                recipe.ingredients, recipe.details);
        final Intent shareIntent = ShareCompat.IntentBuilder
                .from(activity)
                .setType("text/html")
                .setSubject(recipe.title)
                .setText(emailText)
                .getIntent();
        if (shareIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(shareIntent);
        } else {
            Toast.makeText(
                    context,
                    context.getResources().getString(R.string.no_mail_clients_installed),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
