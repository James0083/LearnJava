package day07;
//도형 클래스
abstract public  class Shape { //추상 메서드를 갖는 클래스는 추상클래스여야 한다
	int x,y;
	public String toString() {
		return "나는 도형 클래스 Shape";
	}
	abstract public void area(int w, int h); //추상메서드
	
}///////////////////
//추상클래스를 상속받은 자식 클래스는 반드시 추상메서드를 오버라이드 해야 한다.
//오버라이드 하지 않는다면 자식 클래스도 추상 클래스여야 한다
class Rectangle extends Shape{ //사각형
	
	@Override
	public void area(int a, int h) {
		int k=a*h;
		System.out.println("사각형 면젹: "+k);
	}
}///////////////////

class Triangle extends Shape{ //직각삼각형
	@Override
	public void area(int x, int y) {
		int k=x*y/2;
		System.out.println("직각삼각형 면적: "+k);
	}
}///////////////////

abstract class Circle extends Shape{ //원
	double pi=3.14;
	
}/////////////////////////
class SubCircle extends Circle{
	@Override
	public void area(int a, int b) {
	}
	public void area(int r) { //Overload
		System.out.println("원의 면적: "+pi*r*r);
	}
	
}/////////////////////////