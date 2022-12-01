public class IngredientList {
    private static IngredientList instance = null;
    private ArrayList<Ingredient> ingredientList= new ArrayList<>();

    private IngredientList(){}

    public static IngredientList getInstance(){
        if(instance == null){
            instance = new IngredientList();
             // 재료 목록(더 많이 추가하고 영양정보, 구매 링크 제대로 적어야 함)
            instance.ingredientList.add(new Ingredient("소금", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("설탕", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("생닭", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("돼지고기", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("파", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("양파", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("마늘", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("간장", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("계란", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("멸치", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("두부", 1, 1, 1, 1, 1, 0, "http://naver.com"));
            instance.ingredientList.add(new Ingredient("된장", 1, 1, 1, 1, 1, 0, "http://naver.com"));
        }
        return instance;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
