package kr.co.softcampus.dduddu.user;

import android.view.Menu;

import java.util.ArrayList;

import kr.co.softcampus.dduddu.user.customer.Customer;

public class Administrator extends User {
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
