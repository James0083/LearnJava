package day04;
// 객체=속성(member variable)+행동양식(method)
public class House {
	//1. 속성 - has a 관계가 성립해야 한다.
	int room;	//House has a room
	String owner;
	String addr;
	
	//2. 행동양식(기능)
	public void printInfo() {
		System.out.println("----House 정보----");
		System.out.printf("소유주: %s%n", owner);
		System.out.printf("방  수: %d개%n", room);
		System.out.printf("주  소: %s%n", addr);
	}
	public String existAt(int bunji) {
		String str = "---"+owner+"의 집 상세 주소----\n";
				str += addr+" "+bunji+"번지에 위치해요\n";
				
		return str;
	}
	
	//rent()메서드 구성하기 (집의 거래유형-매매,전세,월세, 가격 : 만원단위)
	//정보를 매개변수로 받아서 문자열로 만들어 반환하는 메서드를 구성하세요
	public String rent(int type, int price) {
		String str = "";
		switch (type) {
		case 1:
			str += "거래유형 : 매매";
			break;
		case 2:
			str += "거래유형 : 전세";
			break;
		case 3:
			str += "거래유형 : 월세";
			break;
		default:
			break;
		}
		
		str += "\n가격 : "+price+"만원\n";
		return str;
		
		// string문자열 값 비교 -> equals()
		// switch문으로 case에 문자열을 쓰면 내용을 비교한다.
		// 문자열 비교에서 '=='를 쓰면 주소값을 비교한다. 문자열의 literal선언과 객체선언 방식은 주소값이 다르다. 
			//따라서 '=='로 비교하면 문자열의 선언방식에 따라 결과가 달라질 수 있다. 
	}
}
