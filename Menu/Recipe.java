import android.graphics.Bitmap;
import java.util.ArrayList;

public class Recipe {
    private ArrayList<String> contents = new ArrayList<String>();
    private ArrayList<Bitmap> pictures = new ArrayList<Bitmap>();
    private ArrayList<Ingredient> neededIngredients = new ArrayList<Ingredient>();
    private double ingredientRatio;
    private int ownedIntredientCnt = 0;

    public void addContents(String str) {
        this.contents.add(str);
    }

    public ArrayList<String> getContents() {
        return contents;
    }

    public void addNeededIngredients(Ingredient ingredient) {
        this.neededIngredients.add(ingredient);
    }

    public ArrayList<Ingredient> getNeededIngredients() {
        return neededIngredients;
    }

    public void setIngredientRatio(ArrayList<Ingredient> ownedIngredients) {
        for(int i=0;i<neededIngredients.size();i++) {
            for(int j=0;j<ownedIngredients.size();j++){
                if(neededIngredients.get(i).getName().equals(ownedIngredients.get(j).getName()))
                    ownedIntredientCnt++;
            }
        }
        this.ingredientRatio = ownedIntredientCnt/this.neededIngredients.size();
    }

    public double getIngredientRatio() {
        return ingredientRatio;
    }

    public int getOwnedIntredientCnt() {
        return ownedIntredientCnt;
    }

    public void addPhoto(Bitmap b) {
        this.pictures.add(b);
    }

    public ArrayList<Bitmap> getPictures() {
        return pictures;
    }
}
