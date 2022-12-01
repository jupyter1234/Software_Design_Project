package Nutrient;
import java.util.*;
public class DietManagement {
    private int totalProtein;
    private int totalCarbohydrate;
    private int totalFat;
    private int totalSugars;
    private int totalSodium;
    private String contents;

// 회원가입할 때 자신의 신체 내용을 입력하는 칸도 있어야할 듯
// 또 자신의 직업을 선택박스에서 선택하고 그 칸에 따라 활동량이 25인지 30인지 40인지 고정시키면 될 것같음

    // 하루 권장 칼로리 섭취량 = 표준 체중 x 활동량
    // 표준 체중은 (자신의 키 - 100) x 0.9)
    // 활동량은 적은 경우 25, 규칙적인 생활을 하는 경우 30~35, 육체노동 등 활동량이 많은 경우 40인데 35~64세에 해당하는 중장년층의 경우 35 정도로 고정 시켜 계산하는 게 맞다고 봄
    // ex) 35세인 나의 키가 171일 때 하루 권장 칼로리는 = ((171-100)x0.9) x 35 = 2236.5이고 이를 세끼로 나누면, 한 끼 섭취량은 745.5kcal이다

    // 음식 칼로리 표 : https://m.blog.naver.com/min02299/221177656019
    // 영양성분표 : http://www.samsunghospital.com/home/healthInfo/content/contenView.do?CONT_SRC_ID=31453&CONT_SRC=HOMEPAGE&CONT_ID=4664&CONT_CLS_CD=001021002001
    // ??
    protected void caculateNutritionFacts(ArrayList<String> eatenMenuList)
    {
        String input;
        Scanner scanner = new Scanner(System.in);

        input = scanner.next();
        eatenMenuList.add(input);

        System.out.println(eatenMenuList.get(0));
        //for( int i = 0; i < eatenMenuList.size(); i++){}

    }
    public static void main(String[] args)
    {
        ArrayList<String> eatenMenuList = new ArrayList<>();
        String input;
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        while(i < 5) {

            input = scanner.next();
            eatenMenuList.add(input);
            i++;
        }
        for(i = 0; i < eatenMenuList.size(); i++)
        {
            System.out.println(eatenMenuList.get(i));
        }

    }

W
}
