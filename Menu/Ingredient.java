import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private double carbohydrate;
    private double protein;
    private double fat;
    private double sodium;
    private double sugars;
    private double amount;
    private String unit;
    private String purchaseLink = "https://www.coupang.com/np/search?q=";

    Ingredient(String name, double carb, double protein, double fat, double sodium, double sugars, double amount, String unit) {
        this.name = name;
        this.carbohydrate = carb;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.sugars = sugars;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSodium() {
        return sodium;
    }

    public double getSugars() {
        return sugars;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getPurchaseLink() {
        return purchaseLink;
    }
}
