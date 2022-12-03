package com.example.first.DaM;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TableLayout;

import com.example.first.PD.Menu.Ingredient;
import com.example.first.PD.Menu.Menu;

import java.util.ArrayList;

public class User_Control {

    User_DAM user_dam;
    SQLiteDatabase sqlite;


    public User_Control(User_DAM dam){
        this.user_dam = dam;
    }
    
    public void insert_own_ingredient(Ingredient i1)
    {
        sqlite = user_dam.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(user_dam.INGREDIENT_NAME,i1.getName());
        values.put(user_dam.CARBOHYDRATE,i1.getCarbohydrate());
        values.put(user_dam.PROTEIN,i1.getProtein());
        values.put(user_dam.SODIUM,i1.getSodium());
        values.put(user_dam.SUGARS,i1.getSugars());
        values.put(user_dam.FAT,i1.getFat());
        values.put(user_dam.PURCHASELINK,i1.getPurchaseLink());
        values.put(user_dam.COUNT,i1.getCount());

        sqlite.insert(user_dam.TABLE_OWN_INGREDIENT, null,values);
        
    }
    
    public void insert_EatenMenu(Menu menu,Ingredient[] ingredientslist) //Menu->EatenMenu바꾸기
    {
        sqlite = user_dam.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(user_dam.MENU_NAME, menu.getName());
        contentValues.put(user_dam.MENU_VIEWS, menu.getViews());
        contentValues.put(user_dam.MENU_CONTENTS, menu.getRecipe().getContents());
        contentValues.put(user_dam.MENU_INGREDIENT_RATIO, menu.getRecipe().getIngredientRatio());
        //EatenMenu 추가
        contentValues.put(user_dam.MENU_EATEN_DATE, menu.getViews()); // ->getEatenDate()로 바꾸기
        for (int i = 0; i < ingredientslist.length; i++) {
            ContentValues ingredient_Values = new ContentValues();
            ingredient_Values.put(user_dam.INGREDIENT_NAME, ingredientslist[i].getName());
            ingredient_Values.put(user_dam.CARBOHYDRATE, ingredientslist[i].getCarbohydrate());
            ingredient_Values.put(user_dam.PROTEIN, ingredientslist[i].getProtein());
            ingredient_Values.put(user_dam.FAT, ingredientslist[i].getFat());
            ingredient_Values.put(user_dam.SODIUM, ingredientslist[i].getSodium());
            ingredient_Values.put(user_dam.SUGARS, ingredientslist[i].getSugars());
            ingredient_Values.put(user_dam.COUNT, ingredientslist[i].getCount());
            ingredient_Values.put(user_dam.PURCHASELINK, ingredientslist[i].getPurchaseLink());
            sqlite.insert(user_dam.TABlE_MENU_INGREDIENT, null, ingredient_Values);


            contentValues.put(user_dam.MENU_INGREDIENT, ingredientslist[i].getName());
            contentValues.put(user_dam.MENU_INGREDIENT_COUNT, ingredientslist[i].getCount());
            //foreign key를 받는 menu_ingredient -> ingredient table의 primarykey = ingredient_name
            sqlite.insert(user_dam.TABLE_MENU, null, contentValues);

        }


    }

    public ArrayList<Ingredient> getdb_own_ingredient()
    {
        ArrayList<Ingredient> ownlist = new ArrayList<>();
        sqlite = user_dam.getReadableDatabase();


        String query_menu = "SELECT * FROM "+ user_dam.TABLE_OWN_INGREDIENT;
        Cursor c_own = sqlite.rawQuery(query_menu,null );

        while(c_own.moveToNext())
        {
            Ingredient ing1 = new Ingredient(
                    c_own.getString(c_own.getColumnIndexOrThrow(user_dam.INGREDIENT_NAME)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.CARBOHYDRATE)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.PROTEIN)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.FAT)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.SODIUM)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.SUGARS)),
                    c_own.getInt(c_own.getColumnIndexOrThrow(user_dam.COUNT)),
                    c_own.getString(c_own.getColumnIndexOrThrow(user_dam.PURCHASELINK))
            );

            ownlist.add(ownlist.size(),ing1);

        }
        return ownlist;
    }

    //EatenMenu로 바꾸기
    public ArrayList<Menu> getdb_EatenMenu()
    {
        sqlite  = user_dam.getReadableDatabase();

        String query_menu = "SELECT * FROM TABLE_MENU JOIN TABLE_MENU_INGREDIENT"+
                " ON TABLE_MENU.MENU_INGREDIENT = TABLE_MENU_INGREDIENT.INGREDIENT_NAME"+
                " AND TABLE_MENU.MENU_INGREDIENT_COUNT = TABLE_MENU_INGREDIENT.COUNT";
        //INGREDIENT
        Cursor c_menu = sqlite.rawQuery(query_menu,null );
        //SELECT * FROM TABLE_MENU
        //JOIN TABLE_INGREDIENT
        //ON TABLE_MENU.MENU_INGREDIENT = TABLE_INGREDIENT.INGREDIENT_NAME
        // AND TABLE_MENU.MENU_INGREDIENT_COUNT = TABLE_INGREDIENT.COUNT;

        String[] columnName = {user_dam.MENU_NAME, user_dam.MENU_VIEWS, user_dam.MENU_CONTENTS, user_dam.MENU_INGREDIENT_RATIO, user_dam.INGREDIENT_NAME};

        ArrayList<Menu> menulist = new ArrayList<>();
        while(c_menu.moveToNext()) {
            if(menulist.size() ==0 ||

                    menulist.get(menulist.size()-1).getName().equals(c_menu.getString(c_menu.getColumnIndexOrThrow(columnName[0]))) == false   )
            //가장 최근에 추가한 것(menulist)과 커서(c_menu)가 같으면 같은 메뉴안에 있는 재료들임 -> 이런 경우는 재료들만 추가함
            {
                //메뉴 객체 생성
                Menu menu1 = new Menu();
                menu1.setName(c_menu.getString(c_menu.getColumnIndexOrThrow(columnName[0])));
                /*code for 조회수 db->object with c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.MENU_VIEWS));*/
                menu1.getRecipe().setContents(c_menu.getString(c_menu.getColumnIndexOrThrow(columnName[2])));
                /*code for ratio db -> object with  c_menu.getDouble(c_menu.getColumnIndexOrThrow(menu_dam.MENU_INGREDIENT_RATIO));*/

                Ingredient ing1 = new Ingredient(
                        c_menu.getString(c_menu.getColumnIndexOrThrow(user_dam.INGREDIENT_NAME)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.CARBOHYDRATE)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.PROTEIN)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.FAT)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.SODIUM)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.SUGARS)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.COUNT)),
                        c_menu.getString(c_menu.getColumnIndexOrThrow(user_dam.PURCHASELINK))
                );
                //메뉴 객체에 필요한 재료 추가
                menu1.getRecipe().addNeededIngredient(ing1);

                //메뉴리스트에 메뉴 추가
                menulist.add(menulist.size(),menu1);

            }
            else {
                Ingredient ing1 = new Ingredient(
                        c_menu.getString(c_menu.getColumnIndexOrThrow(user_dam.INGREDIENT_NAME)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.CARBOHYDRATE)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.PROTEIN)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.FAT)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.SODIUM)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.SUGARS)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(user_dam.COUNT)),
                        c_menu.getString(c_menu.getColumnIndexOrThrow(user_dam.PURCHASELINK))
                );
                //마지막 메뉴에 필요한 재료만 추가
                menulist.get(menulist.size()-1).getRecipe().addNeededIngredient(ing1);
                /*Menu lastmenu = menulist.get(menulist.size());
                lastmenu.getRecipe().addNeededIngredient(ing1);
                menulist.set(menulist.size()-1,lastmenu);*/

            }
        }
        return menulist;

    }

    public void db_close()
    {
        sqlite.close();
        user_dam.close();
    }
}
