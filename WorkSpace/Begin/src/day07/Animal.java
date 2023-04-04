package day07;

abstract public class Animal {
	abstract void crySound();
	abstract void getBaby(int num);
}

class Dog extends Animal{
	@Override
	public void crySound() {
		System.out.println("멍멍");
	}
	@Override
	public void getBaby(int num) {
		System.out.println(num+"마리의 새끼를 낳았어요");
	}
}

class Cat extends Animal{
	@Override
	public void crySound() {
		System.out.println("야옹야옹");
	}
	@Override
	public void getBaby(int num) {
		System.out.println(num+"마리의 새끼를 낳았어요");
	}
}

class Duck extends Animal{
	@Override
	public void crySound() {
		System.out.println("꽥꽥");
	}
	@Override
	public void getBaby(int num) {
		System.out.println(num+"개의 알을 낳았어요");
	}
}
