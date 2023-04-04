package day08;
interface Inter1{
	void a(); //public abstract 가 붙는다
	int b();
	
}/////////////////////
interface Inter2{
	double PI=3.14; //public static final이 붙는다
}/////////////////////
//인터페이스가 인터페이스를 상속받을 때는 extends로 받으며, 여러개 상속 가능하다
interface Inter3 extends Inter1, Inter2
{
	void c();
}/////////////////////
abstract class AbsClass //추상 클래스
{
	abstract void d(); //생략형 접근지정자
}/////////////////////
//[1] MyDemo클래스가 AbsClass, Inter3을 상속받은 뒤 에러 없도록 조치하세요
class MyDemo extends AbsClass implements Inter3
{
	@Override
	public void a() {
		System.out.println("a()###");
	}
	
	@Override
	public int b() {
		return 2;
	}
	
	@Override
	public void c() {
		//System.out.println("c()###");
	}
	
	@Override
	void d() {
		System.out.println("d()@@@");
	}
	
}/////////////////////

public class InterfaceTest2 {

	public static void main(String[] args) {
		// [2] MyDemo객체 생성해서 a(), b(), c(), d()호출하고 PI값 출력하기
		MyDemo md = new MyDemo();
		md.a();
		System.out.println(md.b());
		md.c();
		md.d();
		System.out.println("MyDemo.PI="+MyDemo.PI);
		System.out.println("Inter2.PI="+Inter2.PI);
		
		Inter1 im=new MyDemo();
		Inter2 im2=new MyDemo();
		Inter3 im3=new MyDemo();
		AbsClass ac=new MyDemo();
		
		im.a();
		System.out.println(im.b());
		//im.c(); //[X]
		
		im3.c();
		im3.a();
		im3.b();
		
		//im2.a(); /[X]
		ac.d();
		//ac.a(); //[X]
		((MyDemo)ac).a();
		((Inter1)ac).a();
		
	}

}
