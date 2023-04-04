package day05;

public class Cafe {

	public static void main(String[] args) {
		CoffeeMachine cm = new CoffeeMachine();
		// cm.coffee = 2;
		cm.setCoffee(2);
		// cm.sugar = 1;
		cm.setSugar(1);
		// cm.cream = 3;
		cm.setCream((short)3);
		System.out.println("cm.coffee : "+cm.getCoffee()); //cm.coffee);
		System.out.println("cm.sugar : "+cm.getSugar()); //cm.sugar);
		System.out.println("cm.cream : "+cm.getCream()); //cm.cream);
	}

}
