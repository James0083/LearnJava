package day11;

public class AccountTest {

	public static void main(String[] args) {
		Account ac = new Account();
		
		UserIn user1 = new UserIn(ac, "개미");
		UserOut user2 = new UserOut(ac, "베짱이");

		user2.start();
		user1.start();
	}

}
