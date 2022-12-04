package Nutrient;
import java.text.SimpleDateFormat;
import java.util.*;
import Menu.*;

public class EatenMenu extends Menu{
    private String date; // 현재 날짜

    public void setdate(){
        this.date = nowdate();
    }
    public String getdate(){
        return date;
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