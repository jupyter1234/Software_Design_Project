package kr.co.softcampus.dduddu;

import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.softcampus.dduddu.menu.Ingredient;
import kr.co.softcampus.dduddu.menu.IngredientList;
import kr.co.softcampus.dduddu.user.customer.Customer;
public class userActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        //user_info xml에 정의된 view들을 메모리 상에 객체화 시키는 것

        //button 정의
        Button fish = (Button) findViewById(R.id.fish);
        Button potato = (Button) findViewById(R.id.potato);
        Button soysauce = (Button) findViewById(R.id.soysauce);
        Button egg = (Button) findViewById(R.id.egg);
        Button greenonion = (Button) findViewById(R.id.greenonion);
        Button onion = (Button) findViewById(R.id.onion);
        Button lettuce = (Button) findViewById(R.id.lettuce);
        Button spinach = (Button) findViewById(R.id.spinach);
        Button chicken = (Button) findViewById(R.id.chicken);
        Button anchovy = (Button) findViewById(R.id.anchovy);
        Button tofu = (Button) findViewById(R.id.tofu);
    }
    //클릭된 버튼(재료) 값 넣어주고 객체화
    //Ingredient(String name, int carb, int protein, int fat, int sodium, int sugars, int count, String link)
    public void onClickBtn(View v){
        Customer c = Customer.getInstance();
        ArrayList<Ingredient> owned = c.getOwned();
        ArrayList<Ingredient> all = IngredientList.getInstance().getIngredientList();
        Ingredient in = null;  //해당 되는 준비물 객체 저장할 변수
        int cnt = 0;  //보유 개수 저장할 변수
        //근데 이미 있는 재료일 수도 있음 추가 비교 해야됨

        switch (v.getId()){
            case R.id.fish:
                //owned 리스트에 해당 준비물 추가하기
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("생선")){
                        in = all.get(i);  //준비물 객체 찾기
                        break;
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.potato:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("감자")){
                        in = all.get(i);  //준비물 객체 찾기
                        break;
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.soysauce:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("간장")){
                        in = all.get(i);  //준비물 객체 찾기
                        break;
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.egg:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("계란")){
                        in = all.get(i);  //준비물 객체 찾기
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.salt:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("소금")){
                        in = all.get(i);  //준비물 객체 찾기
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.greenonion:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("파")){
                        in = all.get(i);  //준비물 객체 찾기
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.onion:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("양파")){
                        in = all.get(i);  //준비물 객체 찾기
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            case R.id.lettuce:
                for (int i = 0; i < all.size(); i++){
                    if (all.get(i).getName().equals("상추")){
                        in = all.get(i);  //준비물 객체 찾기
                    }
                }
                cnt = in.getCount();
                if(cnt != 0) {  //이미 보유 중
                    cnt++;
                    in.setCount(cnt);
                }
                else {
                    cnt++;
                    in.setCount(cnt);
                    owned.add(in);
                }
                break;
            }
        if(in != null){
            Toast.makeText(getApplicationContext(),in.getName() + in.getCount(), Toast.LENGTH_SHORT).show();
        }

    }
}
