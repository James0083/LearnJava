package Recipe_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //[1]
import java.util.ArrayList;

public class HomeGUI extends JFrame { //[2]

	ArrayList<Recipe> myRecipes = new ArrayList<>();
	Recipe res = new Recipe();
	boolean Oven, Stove, Pan, Pot;
	
	Container cp;
	JPanel pN = new JPanel(); 	//FlowLayout //북쪽
	JPanel pC = new JPanel();	//FlowLayout //남쪽
	JPanel pWhite;
	ListPage pList = new ListPage(this);
	AddPage pAdd = new AddPage(this);
	SearchPage pSearch = new SearchPage();
	DeletePage pDel = new DeletePage();
	ViewRecipePage pPrint = new ViewRecipePage();
	EditPage pEdit = new EditPage();
	
	CardLayout card;
	
	JButton btList, btAdd, btSearch, btDel, btPrint
		, btEdit, btSubmit;

	RecipeHandler handler;
	
	public HomeGUI() {
		super(":: 레시피 ::");
		cp = this.getContentPane();
		cp.add(pN, "North");
		cp.add(pC, "Center");

		this.setTestCase();
		
		pC.setBackground(Color.white);
		pC.setLayout(card = new CardLayout());
		pC.add(pWhite = new JPanel(), "White");
		pC.add(pList, "List");
		pC.add(pAdd, "Add");
		pC.add(pSearch, "Search");
		pC.add(pDel, "Delete");
		pC.add(pPrint, "Print");
		pC.add(pEdit, "Edit");

		pN.add(btList=new JButton("목록"));
		pN.add(btAdd=new JButton("추가"));
		pN.add(btSearch=new JButton("검색"));
		pN.add(btDel=new JButton("삭제︎︎"));
		//pN.add(btPrint=new JButton("레시피 출력"));
		pN.add(btEdit=new JButton("수정"));
		
		handler = new RecipeHandler(this);
		
		btList.addActionListener(handler);	//[4]
		btAdd.addActionListener(handler);
		btSearch.addActionListener(handler);
		btDel.addActionListener(handler);
		//btPrint.addActionListener(handler);
		btEdit.addActionListener(handler);
		
		pAdd.btAddIngredients.addActionListener(handler);
		pAdd.btAddTools.addActionListener(handler);
		pAdd.btAddStep.addActionListener(handler);
		
		pSearch.btSearch.addActionListener(handler);
		
		
		
		

		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	public ArrayList<Recipe> searchRecipe(String str) {
		Recipe srcp = new Recipe();
		int i = 1;
		ArrayList<Recipe> Searched = new ArrayList<>();

		//검색어를 포함하는 요리명 검색
		for(Recipe rcp:myRecipes) {
			if(rcp.getFName().contains(str)) {
				Searched.add(rcp);
				//System.out.println((i++)+rcp.getFName());
			}
		}
		//보여지는 목록에서 선택
		/*
		int n = 0;
		while(true) {
			System.out.println(search_str+ "할 레시피 선택(정수) : ");
	//		sc.skip("\n");
			n = sc.nextInt();
			if(n<1||n>=i) {
				System.out.println("잘못된 입력입니다. 다시 선택하세요.");
			}else {
				break;
			}
		}*/
		/*
		//해당하는 레시피 반환변수에 입력
		for(Recipe rcp:myRecipes) {
			if(rcp.compareRecipe(Searched.get(n-1))) {
				srcp = rcp;
				break;
			}
			
		}*/
		return Searched;
	}
	
	
//////테스트용 더미 항목 자동입력
	public void setTestCase() {
		Recipe testRCP = new Recipe();
		testRCP.setFName("마카롱");
		
		testRCP.OSP.setOven(true);
		testRCP.addTool("거품기");
		testRCP.addTool("볼");
		testRCP.addTool("짤주머니");
		testRCP.addTool("스패출러");
		
		testRCP.addIngredients(new Ingredient("아몬드 파우더", 140, "g"));
		testRCP.addIngredients(new Ingredient("슈가파우더", 150, "g"));
		testRCP.addIngredients(new Ingredient("달걀흰자", 6, "개"));
		testRCP.addIngredients(new Ingredient("흰설탕", 150, "g"));
		testRCP.addIngredients(new Ingredient("물", 40, "ml"));
		testRCP.addIngredients(new Ingredient("화이트 커버춰 초콜릿", 75, "g"));
		testRCP.addIngredients(new Ingredient("생크림", 50, "g"));
		testRCP.addIngredients(new Ingredient("바닐라빈", 2, "g"));
		
		testRCP.addSteps("아몬드 가루와 수거파우더를 체쳐놓는다.");
		testRCP.addSteps("1에 달걀흰자를 넣고 잘 섞어준다.");
		testRCP.addSteps("냄비에 설탕과 준비된 물을 넣어 시럽을 만든다.");
		testRCP.addSteps("흰자로 머랭을 만든다.");
		testRCP.addSteps("시럽을 머랭에조금씩 나눠 흘리면서 계속 휘핑해준다.");
		testRCP.addSteps("가루 반죽과 머랭을 잘 섞어준다음 짤 주머니에 넣어 유산지를 깐 후라이팬에 동글동글하게 패닝한다.");
		testRCP.addSteps("실온에서 30분 정도 건조시켜 표면이 꾸덕하게 한다.");
		testRCP.addSteps("생크림에 바닐라빈을 잘라 씨를 긁어 넣고 끓여준다.");
		testRCP.addSteps("화이트 초코렛에 생크림을 녹여부어준다(초코렛이 녹지 않으면 뜨거운 물에 중탕한다).");
		testRCP.addSteps("만든 가나슈 필링를 짤 주머니에 넣고 냉장고에 보관한다.");
		testRCP.addSteps("표면이 꾸덕해진 마카롱을 160도에서 10분간 굽는다(프릴이 생길 때까지 굽는다).");
		testRCP.addSteps("잘 구워진 마카롱을 식혀준 후 잘 떼어낸 후 식힘 망에서 다시 식혀준다.");
		testRCP.addSteps("잘 식은 마카롱에 냉장보관한 가나슈를 샌드한다.");
		
		myRecipes.add(testRCP);
	}
	
	public static void main(String[] args) {
		HomeGUI my = new HomeGUI();
		my.setSize(600, 700);
		my.setLocation(500,300);
		my.setVisible(true);

	}
	
	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str);
	}//---------------------------

}