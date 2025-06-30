package test.main;

import test.mypac.MyUtil;
import test.mypac.WowException;

public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작됨");
//		MyUtil.generate(); // RuntimeException 을 상속 받았기 때문에 예외처리가 강제 아님.
		// 그래서 try / catch 로 묶어서 흐름이 지속되게 한다.
		try {
			MyUtil.generate();
		} catch (WowException we) {
			System.out.println("WowException 이 발생");
			System.out.println("예외 메세지:"+we.getMessage());
		}
		
		System.out.println("main 메소드가 종료됨");
	}
}
