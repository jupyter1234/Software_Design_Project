package kr.co.softcampus.dduddu.menu;
import java.io.File;
import java.util.ArrayList;

public class Recipe {
    private String contents;
    // ?��진�? �? ?�� ?���?
    private ArrayList<File> pictures;
    private ArrayList<Ingredient> neededIngredient = new ArrayList<Ingredient>();
    private double ingredientRatio;

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void addNeededIngredient(Ingredient ingredient) {
        this.neededIngredient.add(ingredient);
    }

    public ArrayList<Ingredient> getNeededIngredient() {
        return neededIngredient;
    }

    public void setIngredientRatio(ArrayList<Ingredient> ownedIngredients) {
        double count = 0;
        for(Ingredient e:neededIngredient) {
            if(ownedIngredients.contains(e)){
                count += 1;
            }
        }
        this.ingredientRatio = count/this.neededIngredient.size();
    }

    public double getIngredientRatio() {
        return ingredientRatio;
    }

    // ?��진�? �? ?�� ?���?
    public ArrayList<File> getPictures() {
        return pictures;
    }

    public void addPhoto() {

    }
}
