package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		MyUtil.draw();
		
		try {
			MyUtil.send();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("main 메소드가 종료 되었습니다.");
	}
		
}
