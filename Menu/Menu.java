import java.util.Comparator;

public class Menu {
    private String name;
    private int views = 0;
    private Recipe recipe = new Recipe();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addViews() {
        this.views += 1;
    }

    public int getViews() {
        return views;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}

class MenuViewsComparator implements Comparator<Menu> {
    public int compare(Menu m1, Menu m2) {
        if (m1.getViews() > m2.getViews()) {
            return -1;
        } else if (m1.getViews() < m2.getViews()) {
            return 1;
        }
        return 0;
    }
}

class MenuRatioComparator implements Comparator<Menu> {
    public int compare(Menu m1, Menu m2) {
        if (m1.getRecipe().getIngredientRatio() > m2.getRecipe().getIngredientRatio()) {
            return -1;
        } else if (m1.getRecipe().getIngredientRatio() < m2.getRecipe().getIngredientRatio()) {
            return 1;
        }
        return 0;
    }
}
