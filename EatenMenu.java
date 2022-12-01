package Nutrient;
import java.text.SimpleDateFormat;
import java.util.*;

public class EatenMenu {
    public String getdate() {
        // 날짜 포맷 변경
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년 MM월 dd일"); // mm분 ss초
        // 현재 날짜 가져오기
        Date now = new Date();
        String date = dateformat.format(now);

        //System.out.println(date);
        return date;
    }
    //public static void main(String[] args)
    //{
    //    EatenMenu menu = new EatenMenu();
    //    String date;
    //    date = menu.getdate();
    //    System.out.println(date);
    //}

}
