package Nutrient;
import Menu.*;

import java.util.*;


public class DietManagement
{
    public int Pro = 18;// 단백질 한끼 기준량 // 하루엔 55g
    public int Car = 33; // 탄수화물 한끼 권장량 // 하루엔 100g
    public int Sod = 1; // 나트륨 한끼 권장량 // g
    public int Sug = 8; // 설탕 한끼 권장량 // 하루에 24g
    public int Fa = 17;// 지방 한끼 권장량 // 하루에 51g
    private int totalProtein;
    private int totalCarbohydrate;
    private int totalFat;
    private int totalSugars;
    private int totalSodium;
    private String contents;

    public void caculateNutritionFacts(Menu m) {
        this.totalCarbohydrate = 0;
        this.totalFat = 0;
        this.totalProtein = 0;
        this.totalSodium = 0;
        this.totalSugars = 0;
        ArrayList<Ingredient> li = m.getRecipe().getNeededIngredient();
        for (int i = 0; i < li.size(); i++) {

            this.totalSugars += li.get(i).getSugars();
            this.totalSodium += li.get(i).getSodium();
            this.totalProtein += li.get(i).getProtein();
            this.totalCarbohydrate += li.get(i).getCarbohydrate();
            this.totalFat += li.get(i).getFat();
    }
}
    public void setContents() {
        if (gettotalCarbohydrate() < Car) {
            if (gettotalFat() < Fa) {
                if (gettotalProtein() < Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod) {
                            this.contents = "탄수화물, 지방, 단백질, 당류, 나트륨 (모든 영양소)을 기준량에 비해 덜 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod) {
                            this.contents = "탄수화물, 지방, 단백질, 당류를 기준량에 비해 덜 섭취하고 나트륨을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod) {
                            this.contents = "탄수화물, 지방, 단백질, 당류를 기준량에 비해 덜 섭취하셨고 나트륨은 기준량 알맞게 섭취하였네요!";

                        }
                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod) {
                            this.contents = "탄수화물, 지방, 단백질, 나트륨을 기준량에 비해 덜 섭취하고, 당류를 기준량에 비해 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod) {
                            this.contents = "탄수화물, 지방, 단백질을 기준량에 비해 덜 섭취하고, 당류와 나트륨을 기준량에 비해 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod) {
                            this.contents = "탄수화물, 지방, 단백질을 기준량에 비해 덜 섭취하고, 당류를 기준량보다 더 섭취했고 나트륨은 알맞게 드셨네요!";
                        }

                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 단백질, 나트륨을 비해 덜 섭취하고, 당류는 알맞게 먹음";
                        } else if (gettotalSodium() > Sod) {
                            this.contents = "탄수화물, 지방, 단백질, 나트륨을 기준량에 비해 덜 섭취하고, 당류는 알맞게 먹음";
                        } else if (gettotalSodium() == Sod) {
                            this.contents = "탄수화물, 지방, 단백질을 기준량에 비해 덜 섭취하고, 당류와 나트륨은 알맞게 먹음";
                        }
                    }
                } else if (gettotalProtein() > Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 당류, 나트륨을 기준량에 비해 덜 섭취하고, 단백질을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod) {
                            this.contents = "탄수화물, 지방, 당류를 기준량에 비해 덜 섭취하고, 단백질과 나트륨을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod) {
                            this.contents = "탄수화물, 지방, 당류를 기준량에 비해 덜 섭취하였고, 단백질을 기준량보다 더 섭취하였으며, 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 나트륨을 기준량에 비해 덜 섭취하고, 단백질과 당류를 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 지방을 기준량에 비해 덜 섭취하고, 단백질, 당류, 나트륨을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 지방을 기준량에 비해 덜 섭취하고, 단백질,당류를 기준량 보다 더 섭취하였으며, 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 나트륨을 기준량에 비해 덜 섭취하고, 단백질을 기준량보다 더 섭취했으며 , 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물과 지방을 기준량에 비해 덜 섭취하고, 단백질과 나트륨을 기준량보다 더 섭취했으며, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물고 지방을 기준량에 비해 덜 섭취하고, 단백질을 기준량보다 더 섭취했으며, 당류와 나트륨을 알맞게 섭취하셨네요!";
                        }
                    }
                } else if (gettotalProtein() == Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 나트륨을 기준량에 비해 덜 섭취하고, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 지방, 당류를 기준량에 비해 덜 섭취하고, 나트륨을 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 지방, 당류를 기준량에 비해 덜 섭취하고, 단백질과 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {

                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 나트륨을 기준량에 비해 덜 섭취하고, 당류를 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod) {
                            this.contents = "탄수화물, 지방을 기준량에 비해 덜 섭취하고, 당류와 나트륨을 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 지방을 기준량에 비해 덜 섭취하고, 당류를 기준량보다 더 섭취하였으며, 단백질과 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 지방, 나트륨을 기준량에 비해 덜 섭취하고, 단백질과 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물과 지방을 기준량에 비해 덜 섭취하고, 나트륨을 기준량보다 더 섭취했으며, 단백질과 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물과 지방을 기준량에 비해 덜 섭취하고, 단백질, 당류, 나트륨을 알맞게 섭취하셨네요!";
                        }
                    }
                }
            } else if (gettotalFat() > Fa) {
                if (gettotalProtein() < Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질, 당류, 나트륨을 기준량에 비해 덜 섭취하고, 지방을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 단백질, 당류를 기준량에 비해 덜 섭취하고, 지방, 나트륨을 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 단백질, 당류를 기준량에 비해 덜 섭취하셨고, 지방을 기준량보다 더 섭취하였으며, 나트륨은 알맞게 드셨네요!";

                        }

                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents =  "탄수화물, 단백질, 나트륨을 기준량에 비해 덜 섭취하고, 지방과 당류는 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents =  "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 지방, 당류, 나트륨은 기준량보다 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents =  "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 지방과 당류는 기준량보다 더 섭취하였으며, 나트륨은 알맞게 드셨네요!";
                        }

                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질, 나트륨은 기준량에 비해 덜 섭취하고, 지방은 기준량보다 더 많이 섭취하였으며, 당류는 알맞게 드셨습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 나트륨과 지방은 기준량보다 더 많이 섭취하였으며,  당류는 알맞게 드셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 지방은 기준량보다 더 많이 섭취하였으며, 당류와 나트륨을 알맞게 드셨네요!";
                        }
                    }
                } else if (gettotalProtein() > Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents =  "탄수화물, 당류, 나트륨을 기준량에 비해 덜 섭취하고, 지방과 단백질을 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents =  "탄수화물과 당류를 기준량에 비해 덜 섭취하고, 지방, 단백질, 나트륨을 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents =  "탄수화물과 당류를 기준량에 비해 덜 섭취하고, 지방과 단백질을 기준량 보다 더 섭취하였으며 나트륨은 알맞게 드셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {

                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물과 나트륨을 기준량에 비해 덜 섭취하고, 지방, 단백질, 당류를 더 섭취하였습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 지방, 나트륨, 단백질, 당류를 더 섭취하였습니다.";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 지방, 단백질, 당류를 기준량보다 더 섭취하였으며 나트륨은 알맞게 드셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량보다 덜 섭취하였고, 지방을 기준량보다 더 섭취하였으며, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물이 기준량에 비해 덜 섭취하고, 지방, 단백질, 나트륨을 기준량보다 더 섭취했으며, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물이 기준량에 비해 덜 섭취하고, 지방과 단백질을 기준량보다 더 섭취했으며 당류와 나트륨을 알맞게 섭취하셨네요!";
                        }
                    }
                } else if (gettotalProtein() == Pro) {
                    if (gettotalSugars() < Sug) {

                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물,당류, 나트륨을 기준량에 비해 덜 섭취하고, 지방을 기준량보다 더 많이 섭취했으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 당류를 기준량에 비해 덜 섭취하고, 당류, 나트륨을 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 당류를 기준량에 비해 덜 섭취하고, 지방을 기준량보다 더 많이 섭취했으며, 단백질과 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {

                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 나트륨을 기준량에 비해 덜 섭취하고, 지방과 당류를 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 당류, 나트륨, 지방을 기준량보다 더 섭취하였으며, 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 당류, 지방을 기준량 보다 더 섭취하였으며, 단백질과 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {

                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 나트륨을 기준량에 비해 덜 섭취하고, 지방을 기준량보다 더 섭취했으며 , 단백질, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 지방, 나트륨을 기준량보다 더 섭취했으며, 단백질, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 단백질을 기준량보다 더 섭취했으며, 단백질, 당류와 나트륨을 알맞게 섭취하셨네요!";
                        }
                    }
                }
            } else if (gettotalFat() == Fa) {
                if (gettotalProtein() < Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질, 당류, 나트륨을 기준량에 비해 덜 섭취하고, 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 단백질, 당류를 기준량에 비해 덜 섭취하고, 나트륨을 기준량보다 더 섭취하였으며, 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 단백질, 당류를 기준량에 비해 덜 섭취하셨고, 지방과 나트륨은 알맞게 드셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents =  "탄수화물, 단백질, 나트륨을 기준량에 비해 덜 섭취하고, 당류는 기준량보다 더 섭취하였으며 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents =  "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 당류, 나트륨은 기준량보다 더 섭취하였으며 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents =  "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 당류는 기준량보다 더 섭취하였으며, 지방과 나트륨은 알맞게 드셨네요!";
                        }

                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질, 나트륨은 기준량에 비해 덜 섭취하고, 지방과 당류는 알맞게 드셨습니다.";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 나트륨은 기준량보다 더 많이 섭취하였으며, 지방과 당류는 알맞게 드셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량에 비해 덜 섭취하고, 지방, 당류와 나트륨을 알맞게 드셨네요!";
                        }
                    }
                } else if (gettotalProtein() > Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents =  "탄수화물, 당류, 나트륨을 기준량에 비해 덜 섭취하고, 단백질을 더 섭취하였으며, 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물과 당류를 기준량에 비해 덜 섭취하고, 단백질, 나트륨을 더 섭취하였으며, 지방을 알맞게 섭취하셨네요 !";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물과 당류를 기준량에 비해 덜 섭취하고, 단백질을 기준량 보다 더 섭취하였으며, 지방과 나트륨은 알맞게 드셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물과 나트륨을 기준량에 비해 덜 섭취하고, 단백질과 당류를 기준량보다 더 섭취하셨으며, 지방은 알맞게 드셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 단백질, 당류를 기준량보다 더 섭취하였으며, 지방은 알맞게 드셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 단백질, 당류를 기준량보다 더 섭취하였으며 지방과 나트륨은 알맞게 드셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 단백질을 기준량보다 덜 섭취하였고, 지방과 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물이 기준량에 비해 덜 섭취하고, 단백질, 나트륨을 기준량보다 더 섭취했으며, 지방과 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물이 기준량에 비해 덜 섭취하고, 단백질을 기준량보다 더 섭취했으며 지방, 당류, 나트륨을 알맞게 섭취하셨네요!";
                        }
                    }
                } else if (gettotalProtein() == Pro) {
                    if (gettotalSugars() < Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물,당류, 나트륨을 기준량에 비해 덜 섭취하고, 지방과 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물, 당류를 기준량에 비해 덜 섭취하고, 나트륨을 기준량보다 더 섭취하였으며, 지방과 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물, 당류를 기준량에 비해 덜 섭취하고, 지방, 단백질, 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() > Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 나트륨을 기준량에 비해 덜 섭취하고, 당류를 기준량보다 더 섭취하였으며, 지방과 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 당류, 나트륨을 기준량보다 더 섭취하였으며, 지방과 단백질은 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 당류를 기준량 보다 더 섭취하였으며, 지방, 단백질과 나트륨은 알맞게 섭취하셨네요!";
                        }
                    } else if (gettotalSugars() == Sug) {
                        if (gettotalSodium() < Sod ) {
                            this.contents = "탄수화물, 나트륨을 기준량에 비해 덜 섭취하고, 지방, 단백질, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() > Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 나트륨을 기준량보다 더 섭취했으며, 지방, 단백질, 당류는 알맞게 섭취하셨네요!";
                        } else if (gettotalSodium() == Sod ) {
                            this.contents = "탄수화물을 기준량에 비해 덜 섭취하고, 단백질, 당류, 단백질, 지방을 알맞게 섭취하셨네요!";
                        }
                    }
                }
            }
        } // 다른 예외는 만들다가 덜만들어서 파일 다른 파일에 옮겨뒀어요 ㅠㅠ 필요하시면 빨리 작업해서 올릴게요
    }
    public String getContents() {
        return contents;
    }


    public int gettotalCarbohydrate() {

        return totalCarbohydrate;
    }

    public int gettotalFat() {

        return totalFat;
    }

    public int gettotalProtein() {

        return totalProtein;
    }

    public int gettotalSodium() {
        return totalSodium;
    }

    public int gettotalSugars() {
        return totalSugars;
    }
}


// coment : 설탕이 너무 많습니다.
// : 나트륨이 너무 많습니다.
// : 단백질이 너무 많습니다.
// : 탄수화물이 너무 많습니다.
// : 지방이 너무 많습니다.

// 음식 칼로리 표 : https://m.blog.naver.com/min02299/221177656019
// 영양성분표 :https://health.amc.seoul.kr/health/maintain/guide.do



