package Recipe_Management;

import java.util.*;

public class RecipeApp {
	Scanner sc = new Scanner(System.in);
	ArrayList<Recipes> myRecipes = new ArrayList<>();
	int count = 0;
	
	public void menu() {
		System.out.println("------JobKoreaApp v1.1------");
		System.out.println(" 1. 레시피 등록");
		System.out.println(" 2. 레시피 출력");
		System.out.println(" 3. 레시피 삭제");
//		System.out.println(" 4. 레시피 편집");
		System.out.println(" 9. 종  료");
		System.out.println("----------------------------");
		System.out.println(" 메뉴 번호를 선택하세요 =>");
		System.out.println("----------------------------");
		
	}

	public static void main(String[] args) {
		
	}

}
