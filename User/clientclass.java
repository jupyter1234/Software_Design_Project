package sd_class;

import java.io.*;
import java.util.ArrayList;

class User{
	private String id;
	private String pw;
	private String name;
}
//Info of Ingredient
class Ingredient{
	//menu package에서 가져오기
}
class Menu{
	//menu package에서 가져오기
}
//customer extends user class
class Customer extends User {
    private static Customer instance = null;
    private boolean isActivity = true; //제제대상자가 아닌지 확인
    private ArrayList<Ingredient> owned = new ArrayList<Ingredient>();
    private ArrayList<Menu> eatenMenu = new ArrayList<Menu>();

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
        //리스트에 추기
        eatenMenu.add(m);
        //메뉴의 영양소(menu package) 가져와서 내 영양소 업데이트(nutrient package)
    }

    public ArrayList<Menu> getEatenMenu() {
        return eatenMenu;
    }
}

//관리자 class
class Administer extends User{
	//부적절한 메뉴 삭제
	 ArrayList<Menu> mainmenu = new ArrayList<Menu>();
	//관리자가 UI에서 선택한 메뉴를 삭제
	public void DeleteMenu(Menu m) {
		//카테고리는 메뉴패키지에서 여기서는 대강 구현만
		mainmenu.remove(m);
	}
	public void suspendUser(Customer c) {
		//악성 유저 차단
		c.setIsActivity(false);
	}
}
