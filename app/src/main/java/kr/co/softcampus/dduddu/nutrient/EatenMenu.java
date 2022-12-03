package kr.co.softcampus.dduddu.nutrient;
import java.text.SimpleDateFormat;
import java.util.*;

import kr.co.softcampus.dduddu.user.*;
import kr.co.softcampus.dduddu.user.customer.Customer;

public class EatenMenu {
    private String date; // 현재 날짜
    private ArrayList<Customer> eatenMenu = new ArrayList<Customer>();

    public void setEatenMenu(ArrayList<Customer> eatenMenu) {
        this.eatenMenu = eatenMenu;
    }

    public void addEatenMenu(Customer m) {
        //리스트에 추기
        eatenMenu.add(m);
        //메뉴의 영양소(menu package) 가져와서 내 영양소 업데이트(nutrient package)
    }

    public ArrayList<Customer> getEatenMenu() {
        return eatenMenu;
    }


    public String nowdate() {
        // 날짜 포맷 변경
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일"); // mm분 ss초
        // 현재 날짜 가져오기
        Date now = new Date();
        date = dateformat.format(now);
        return date;
    }
}