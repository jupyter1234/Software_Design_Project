package kr.co.softcampus.dduddu.user.customer;

import java.util.ArrayList;

import kr.co.softcampus.dduddu.menu.*;

public class Customer {
    private static Customer instance = null;
    private boolean isActivity = true; //제제대상자가 아닌지 확인

    //owned ingredient list
    private ArrayList<Ingredient> owned = new ArrayList<Ingredient>();
    //eaten menu list (association)
    private static ArrayList <Menu> eatenMenu = new ArrayList<Menu>();

    private Customer(){}

    public static Customer getInstance(){
        if(instance == null)
            instance = new Customer();
        return instance;
    }

    public void setIsActivity(boolean isActivity) {
        this.isActivity = isActivity;
    }
    public boolean getIsActivity() {
        return isActivity;
    }
    //최대 등록 재료 정의?
    //요리하게 된다면 요리의 ingredient만큼 내 리스트에서 삭제해야함
    //그것 제외하고도 사용자가 삭제할 수 있어야함

    public void setOwned(ArrayList<Ingredient> owned) {
        this.owned = owned;
    }

    public void addOwnedIngredient(Ingredient i){
        //UI에서 선택된 재료 i를 내 리스트에 추가해야함
        owned.add(i);
    }

    public ArrayList<Ingredient> getOwned() {
        return owned;
    }

    public void deleteOwnIngredient(Ingredient d) {
        owned.remove(d);
    }

    public void setEatenMenu(ArrayList<Menu> eatenMenu) {
        this.eatenMenu = eatenMenu;
    }

    public void addEatenMenu(Menu m) {
        //리스트에 추가
        eatenMenu.add(m);
    }

    public ArrayList<Menu> getEatenMenu() {
        return eatenMenu;
    }
}
