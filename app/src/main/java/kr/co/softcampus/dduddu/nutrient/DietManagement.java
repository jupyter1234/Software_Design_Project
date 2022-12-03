package kr.co.softcampus.dduddu.nutrient;

import kr.co.softcampus.dduddu.nutrient.*;
import java.util.*;


public class DietManagement //extends User
{
    public int man = 100;
    private int totalProtein;
    private int totalCarbohydrate;
    private int totalFat;
    private int totalSugars;
    private int totalSodium;

    private String contents;

    public int gettotalCarbohydrate() {

        return totalCarbohydrate;
    }

    public int gettotalProtein() {

        return totalProtein;
    }

    public int gettotalFat() {
        return totalFat;
    }

    public int gettotalSodium() {
        return totalSodium;
    }

    public int gettotalSugars() {
        return totalSugars;
    }

    public void caculateNutritionFacts(ArrayList<EatenMenu> eatenMenuList)
    {

    }
}
// 어떤 방식으로 계산을 해야하지?

// 남자 하루 권장 칼로리 2000~2800kcal : 고정 2400kcal, 한끼 기준 800.0kcal
// 여자 하루 권장 칼로리 1600~2400kcal : 고정 2000kcal, 한끼 기준 666.7kcal

// 음식 칼로리 표 : https://m.blog.naver.com/min02299/221177656019
// 영양성분표 : http://www.samsunghospital.com/home/healthInfo/content/contenView.do?CONT_SRC_ID=31453&CONT_SRC=HOMEPAGE&CONT_ID=4664&CONT_CLS_CD=001021002001







        //for( int i = 0; i < eatenMenuList.size(); i++){ } // 여기서 하나하나 값 들고오기
        //addAll 사용시 B의 데이터를 A안에 다 넣을 수 있다.

