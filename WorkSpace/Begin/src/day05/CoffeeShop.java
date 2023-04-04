package day05;

public class CoffeeShop {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		// 1. 밀크 커피 내오기
		vm.makeTea(1,2,3);
		
		// 2. 설탕 커피
		vm.makeTea(2, 3);
		
		// 3. 블랙 커피
		System.out.println(vm.makeTea(1));
		
		// 4. 크림 커피
		vm.makeTea(3, (short)5);
		
		// 5. 유자차 내오기
		Yuja yj = new Yuja();
		yj.setYuja(10);
		yj.setSugar(10);
		
		vm.makeTea(yj);
	}

}
