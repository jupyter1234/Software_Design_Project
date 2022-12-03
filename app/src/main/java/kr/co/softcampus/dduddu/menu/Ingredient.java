package kr.co.softcampus.dduddu.menu;

public class Ingredient {
    private String name;
    private int carbohydrate;
    private int protein;
    private int fat;
    private int sodium;
    private int sugars;
    private int count;
    private String purchaseLink;

    Ingredient(String name, int carb, int protein, int fat, int sodium, int sugars, int count, String link) {
        this.name = name;
        this.carbohydrate = carb;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.sugars = sugars;
        this.count = count;
        this.purchaseLink = link;
    }

    public String getName() {
        return name;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getSugars() {
        return sugars;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getPurchaseLink() {
        return purchaseLink;
    }
}
