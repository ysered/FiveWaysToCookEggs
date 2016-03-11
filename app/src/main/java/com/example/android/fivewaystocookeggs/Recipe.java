package com.example.android.fivewaystocookeggs;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.List;

public class Recipe implements Parcelable {

    private long id;
    private String title;
    private String imageName;
    private int imageResource;
    private List<String> ingredients;
    private List<String> directions;

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        id = in.readLong();
        title = in.readString();
        imageName = in.readString();
        imageResource = in.readInt();
        ingredients = in.createStringArrayList();
        directions = in.createStringArrayList();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(imageName);
        dest.writeInt(imageResource);
        dest.writeStringList(ingredients);
        dest.writeStringList(directions);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public String getIngredientsLine() {
        if (ingredients != null && ingredients.size() > 0) {
            final String line = TextUtils.join(", ", ingredients).toLowerCase();
            return line.substring(0, 1).toUpperCase() + line.substring(1);
        }
        return "";
    }

    public String getIngredientsList() {
        if (ingredients != null && ingredients.size() > 0) {
            StringBuilder list = new StringBuilder();
            for (int i = 0; i < ingredients.size(); i++) {
                list.append("• ");
                list.append(ingredients.get(i));
                if (i != ingredients.size() - 1) {
                    list.append("\n");
                }
            }
            return list.toString();
        }
        return "";
    }

    public String getDirectionsList() {
        if (directions != null && directions.size() > 0) {
            return TextUtils.join("\n\n", directions);
        }
        return "";
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageResource=" + imageResource +
                ", ingredients=" + ingredients +
                ", directions=" + directions +
                '}';
    }

}
