package day08;

import java.io.*;

import javax.swing.JOptionPane;

//파일을 읽어서 콘솔에 출력하는 프로그램
//[1] try ~ catch
//[2] throws
/*  Exception
* 		|
* 	IOException
* 		+-------FileNotFoundException
* 
* <1> try~catch로 예외처리 하세요(실습)
* */
//  /Users/jaewonyou/myjava/WorkSpace/Begin/src/day05/Cafe.java
//  ./src/day05/Aquaman.java
public class FileIO {

	public static String reading(String fileName) {
		System.out.println("----"+fileName+"----");
		String content="";
		FileReader fr=null;
		char[] data=new char[1000]; //파일 데이터를 담을 배열-1000자
		try {
			fr=new FileReader(fileName);//파일과 노드 연결
			//FileNotFoundException
			
			int n=fr.read(data,0,1000); //파일을 읽어서 data배열에 담는다
			//IOException

			fr.close(); //파일 리소스를 반환
			//IOException
		} catch (FileNotFoundException e) {
//			System.out.println("--파일을 찾기 에러 발생 : "+e);
			System.out.println(fileName+"이란 파일은 없어요!!");
		} catch (IOException e) {
			System.out.println("--파일을 입출력 에러 : "+e);
		}
		content = new String(data, 0, data.length); //char[] -> String
		//파일 내용을 문자열로 만든다
		
		return content;
	}//reading()-----
	
	public static void main(String[] args) {
		
		String fname = JOptionPane.showInputDialog("읽을 파일 내용");
		if(fname==null) return;
		String str=reading(fname);
		System.out.println(str);
	}//main()------------

}
