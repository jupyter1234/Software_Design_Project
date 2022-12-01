package sd_class;

import java.io.*;
import java.util.ArrayList;

class User{
	private String id;
	private String pw;
	private String name;
}
//Info of Ingredient
class Ingredient{
	//menu package���� ��������
}
class Menu{
	//menu package���� ��������
}
//customer extends user class
class Customer extends User{
	private boolean isActivity = true; //��������ڰ� �ƴ��� Ȯ��
	
	public void setIsActivity(boolean isActivity) {
		this.isActivity = isActivity;
	}
	public boolean getIsActivity() {
		return this.isActivity;
	}
	//�ִ� ��� ��� ����?
	//�丮�ϰ� �ȴٸ� �丮�� ingredient��ŭ �� ����Ʈ���� �����ؾ���
	//�װ� �����ϰ� ����ڰ� ������ �� �־����
	ArrayList<Ingredient> owned = new ArrayList<Ingredient> ();
	ArrayList<Menu> eatenMenu = new ArrayList<Menu> ();
	public void addOwnIngredient(Ingredient i){
		//UI���� ���õ� ��� i�� �� ����Ʈ�� �߰��ؾ���
		owned.add(i);
	}
	public void deleteOwnIngredient(Ingredient d) {
		owned.remove(d);
	}
	public void addEatenMenu(Menu m) {
		//����Ʈ�� �߱�
		eatenMenu.add(m);
		//�޴��� �����(menu package) �����ͼ� �� ����� ������Ʈ(nutrient package)
	}
}

//������ class
class Administer extends User{
	//�������� �޴� ����
	 ArrayList<Menu> mainmenu = new ArrayList<Menu>();
	//�����ڰ� UI���� ������ �޴��� ����
	public void DeleteMenu(Menu m) {
		//ī�װ��� �޴���Ű������ ���⼭�� �밭 ������
		mainmenu.remove(m);
	}
	public void suspendUser(Customer c) {
		//�Ǽ� ���� ����
		c.setIsActivity(false);
	}
}