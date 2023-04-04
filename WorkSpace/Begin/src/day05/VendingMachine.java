package day05;

public class VendingMachine {
	
	private int coffee, sugar, cream;
	
	public void makeTea(int coffee, int sugar, int cream) {
		this.coffee=coffee;
		this.sugar=sugar;
		this.cream=cream;
		System.out.println("밀크 커피 나가요~~ 농도 : "+ (this.coffee+this.sugar+this.cream));
		
	}
	public void makeTea(int c, int s) {
		coffee=c; sugar=s;
		System.out.println("설탕 커피 나가요~~ 농도 : "+ (coffee+sugar));
	}
	public String makeTea(int coffee) {
		this.coffee=coffee;
		return "블랙 커피 나가요~~ 농도 : "+this.coffee;
	}
	//크림 커피
	public void makeTea(int coffee, short cream) {
		this.coffee=coffee;
		this.cream=cream;
		System.out.println("크림 커피 나가요~~ 농도 : "+ (this.coffee+this.cream));
	}
	public void makeTea(short cream, int coffee) {
		this.coffee=coffee;
		this.cream=cream;
		System.out.println("크림 커피 나가요~~ 농도 : "+ (this.coffee+this.cream));
	}
	
	//유자차 메서드 오버로드 하기
	public void makeTea(Yuja yuja) {
		System.out.println("유자 농도 : "+ yuja.getYuja());
		System.out.println("설탕 농도 : "+ yuja.getSugar());
		System.out.println("유자차 나가요~~ 농도 : "+ (yuja.getYuja()+yuja.getSugar()));
	}
	
}
