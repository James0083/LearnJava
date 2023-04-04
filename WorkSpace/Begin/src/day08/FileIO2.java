package day08;

//파일을 읽어서 콘솔에 출력하는 프로그램
//[1] try ~ catch
//[2] throws
/*  Exception
* 		|
* 	IOException
* 		+-------FileNotFoundException
* 
* <2> throw로 예외 선언하세요(실습)
* */
import java.io.*;

import javax.swing.JOptionPane;

public class FileIO2{

	public static String reading(String fileName) throws IOException, FileNotFoundException {
		System.out.println("----"+fileName+"----");
		String content="";
		FileReader fr=null;
		char[] data=new char[1000]; //파일 데이터를 담을 배열-1000자
		
		fr=new FileReader(fileName);//파일과 노드 연결
		//FileNotFoundException
		
		int n=fr.read(data,0,1000); //파일을 읽어서 data배열에 담는다
		//IOException
		
		fr.close(); //파일 리소스를 반환
		//IOException
		content = new String(data, 0, data.length); //char[] -> String
		//파일 내용을 문자열로 만든다
		return content;
	}//reading()-----
	
	public static void main(String[] args){
		
		String fname = JOptionPane.showInputDialog("읽을 파일 내용");
		if(fname==null) return;
		try {
			String str=reading(fname);
			System.out.println(str); //throws한 예외가 함수를 부른 로 나온다.
		} catch (IOException e) {
			System.out.println("파일 입출력 중 예외 발생 : "+e);
		}
	}//main()------------

}
