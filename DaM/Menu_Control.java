package com.example.first.DaM;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.first.PD.Menu.Ingredient;
import com.example.first.PD.Menu.IngredientList;
import com.example.first.PD.Menu.Menu;
import com.example.first.PD.Menu.MenuList;

import java.util.ArrayList;

public class Menu_Control {

    Menu_DaM menu_dam;
    SQLiteDatabase sqLiteDatabase;
    public Menu_Control(Menu_DaM menu_dam){ this.menu_dam = menu_dam;}

    private void inserting(Menu menu, Ingredient[] ingredientslist, SQLiteDatabase sqLiteDatabase, Menu_DaM menu_daM, ContentValues contentValues, ContentValues ingredient_values, String Menu_Type)
    {

        //contentValues.put(menu_dam.MENU_ID,1);

        contentValues.put(menu_dam.MENU_NAME,menu.getName());
        contentValues.put(menu_dam.MENU_VIEWS,menu.getViews());
        contentValues.put(menu_dam.MENU_CONTENTS,menu.getRecipe().getContents());
        contentValues.put(menu_dam.MENU_INGREDIENT_RATIO,menu.getRecipe().getIngredientRatio());
        for(int i = 0 ; i<ingredientslist.length;i++)
        {
            ContentValues ingredient_Values = new ContentValues();
            ingredient_Values.put(menu_dam.INGREDIENT_NAME,ingredientslist[i].getName());
            ingredient_Values.put(menu_dam.CARBOHYDRATE,ingredientslist[i].getCarbohydrate());
            ingredient_Values.put(menu_dam.PROTEIN,ingredientslist[i].getProtein());
            ingredient_Values.put(menu_dam.FAT,ingredientslist[i].getFat());
            ingredient_Values.put(menu_dam.SODIUM,ingredientslist[i].getSodium());
            ingredient_Values.put(menu_dam.SUGARS,ingredientslist[i].getSugars());
            ingredient_Values.put(menu_dam.COUNT,ingredientslist[i].getCount());
            ingredient_Values.put(menu_dam.PURCHASELINK,ingredientslist[i].getPurchaseLink());
            sqLiteDatabase.insert(menu_dam.INGREDIENT,null,ingredient_Values);


            contentValues.put(menu_dam.MENU_INGREDIENT,ingredientslist[i].getName());
            contentValues.put(menu_dam.MENU_INGREDIENT_COUNT,ingredientslist[i].getCount());
            //foreign key를 받는 menu_ingredient -> ingredient table의 primarykey = ingredient_name
            sqLiteDatabase.insert(Menu_Type,null,contentValues);
        }
    }

    private ArrayList<Menu> selecting(SQLiteDatabase sqLiteDatabase, Menu_DaM menu_daM, String Menu_type)
    {

        String query_menu = "SELECT * FROM "+ Menu_type+" JOIN TABLE_INGREDIENT"+
                " ON "+Menu_type+".MENU_INGREDIENT = TABLE_INGREDIENT.INGREDIENT_NAME"+
                " AND "+Menu_type+".MENU_INGREDIENT_COUNT = TABLE_INGREDIENT.COUNT";
        //INGREDIENT
        Cursor c_menu = sqLiteDatabase.rawQuery(query_menu,null );
        //SELECT * FROM TABLE_MENU
        //JOIN TABLE_INGREDIENT
        //ON TABLE_MENU.MENU_INGREDIENT = TABLE_INGREDIENT.INGREDIENT_NAME
        // AND TABLE_MENU.MENU_INGREDIENT_COUNT = TABLE_INGREDIENT.COUNT;

        String[] columnName = {menu_dam.MENU_NAME, menu_dam.MENU_VIEWS, menu_dam.MENU_CONTENTS, menu_dam.MENU_INGREDIENT_RATIO, menu_dam.INGREDIENT};

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
                        c_menu.getString(c_menu.getColumnIndexOrThrow(menu_dam.INGREDIENT_NAME)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.CARBOHYDRATE)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.PROTEIN)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.FAT)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.SODIUM)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.SUGARS)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.COUNT)),
                        c_menu.getString(c_menu.getColumnIndexOrThrow(menu_dam.PURCHASELINK))
                );
                //메뉴 객체에 필요한 재료 추가
                menu1.getRecipe().addNeededIngredient(ing1);
                //메뉴리스트에 메뉴 추가
                menulist.add(menulist.size(),menu1);

            }
            else {
                Ingredient ing1 = new Ingredient(
                        c_menu.getString(c_menu.getColumnIndexOrThrow(menu_dam.INGREDIENT_NAME)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.CARBOHYDRATE)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.PROTEIN)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.FAT)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.SODIUM)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.SUGARS)),
                        c_menu.getInt(c_menu.getColumnIndexOrThrow(menu_dam.COUNT)),
                        c_menu.getString(c_menu.getColumnIndexOrThrow(menu_dam.PURCHASELINK))
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
    public void insert_MAIN(Menu menu, Ingredient[] ingredientslist)
    {
        sqLiteDatabase = menu_dam.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues ingredient_Values = new ContentValues();
        inserting(menu,ingredientslist,sqLiteDatabase,menu_dam,contentValues,ingredient_Values,menu_dam.TABLE_MAINMENU);
    }


    public void insert_SIDE(Menu menu, Ingredient[] ingredientslist)
    {
        sqLiteDatabase = menu_dam.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues ingredient_Values = new ContentValues();
        inserting(menu,ingredientslist,sqLiteDatabase,menu_dam,contentValues,ingredient_Values,menu_dam.TABLE_SIDEMENU);
    }
    public void insert_SOUP(Menu menu, Ingredient[] ingredientslist)
    {
        sqLiteDatabase = menu_dam.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues ingredient_Values = new ContentValues();
        inserting(menu,ingredientslist,sqLiteDatabase,menu_dam,contentValues,ingredient_Values,menu_dam.TABLE_SOUPMENU);
    }

    public ArrayList<Menu> getdb_MAIN()
    {
        sqLiteDatabase = menu_dam.getReadableDatabase();
        String menu_type = menu_dam.TABLE_MAINMENU;
        return selecting(sqLiteDatabase,menu_dam,menu_type);

    }
    public ArrayList<Menu> getdb_SIDE()
    {
        sqLiteDatabase = menu_dam.getReadableDatabase();
        String menu_type = menu_dam.TABLE_SIDEMENU;
        return selecting(sqLiteDatabase,menu_dam,menu_type);

    }
    public ArrayList<Menu> getdb_SOUP()
    {
        sqLiteDatabase = menu_dam.getReadableDatabase();
        String menu_type = menu_dam.TABLE_SOUPMENU;
        return selecting(sqLiteDatabase,menu_dam,menu_type);

    }


    public void db_close()
    {
        sqLiteDatabase.close();
        menu_dam.close();
    }

}
