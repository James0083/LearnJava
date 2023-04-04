package day07;

import java.awt.geom.Area;

public class ShapeTest {
	public static void main(String[] args) {
		System.out.println("각 도형의 면적을 구합시다~~");
		System.out.printf("가로 %d, 세로 %d 인 도형의 면적-----\n", 8, 10);
		
		//사각형 객체 생성 후 area()호
		Rectangle rt = new Rectangle();
		rt.area(8, 10);
		
		//직각삼각형 객체 생성 후 area()호
		Triangle tr = new Triangle();
		tr.area(8, 10);
		
		//원 객체 생성 후 area()호
		//원: 반지름 8
//		Circle cr = new Circle();
		//Circle => 추상클래스
		//추상클래스는 타입선언은 할 수 있으나 인스턴스화 할 수 없다
		Circle cr = new SubCircle(); // [O]
		cr.area(8, 0);
		//cr.area(8); //[X]
		((SubCircle)cr).area(8);
		
		SubCircle cr2 = new SubCircle();
		cr2.area(10);

		System.out.println("cr.pi: "+cr.pi);
		
		Shape r  = new Rectangle();
		r.area(5, 6);
		
		//rt, tr, cr, cr2, r를 배열에 저장한 후 반복문을 돌려서 각 도형의 면적을 출력하세요
		//12, 24, 반지름:12
		Shape[] arr = {rt, tr, cr, cr2, r};
		for(Shape sp:arr) {
			if(sp instanceof Circle) {	//부모타입으로도 인식 가능, cr은 객체선언을 SubCircle 객체로 선언했기 때문에 SubCircle로도 인식가능
				((SubCircle)sp).area(12);
			}
			else {
				sp.area(12, 24);
			}
			System.out.println("---------");
		}
		
	}
}
