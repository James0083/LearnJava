package day10;
import java.util.*;
import java.io.*;
/*
 * Properties 
 *  - Map계열
 *  - Hashtable의 자식 클래스
 *  - XXX.properties유형의 파일을 읽어서 해당 파일에 저장된 내용을 객체로 옮기고자 할때 사용한다
 */
public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		Properties prop=new Properties();
		System.out.println(prop);
		//database.properties파일을 읽어서 prop객체로 옮겨보자
		prop.load(new FileReader("src/day10/database.properties"));
		System.out.println("파일 로드후-------------");
		System.out.println(prop);
		String db=prop.getProperty("DbType");
		String user=prop.getProperty("DbUser");
		String pwd=prop.getProperty("DbPwd");
		String os=prop.getProperty("os", "Windows");
		
		System.out.println(db);
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(os);
	}
}
