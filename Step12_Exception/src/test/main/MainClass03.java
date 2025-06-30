package test.main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("나눌 수 입력: ");
		String inputNum1=scan.nextLine();
		System.out.print("나누어 지는 수 입력: ");
		String inputNum2=scan.nextLine();
		try {
			// 문자열 형태의 숫자를 실제 정수로 변경
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			
			// 계산하기
			int result1=num2/num1; // 몴
			int result2=num2%num1; // 나머지
			System.out.println(num2+" 를 "+num1+" 으로 나눈 몫 :"+result1);
			System.out.println(num2+" 를 "+num1+" 으로 나눈 나머지 :"+result2);
		} catch (Exception e) {
			/*
			 *  모든 예외는 Exception type 이기 때문에 어떤 예외가 발생 하더라도 여기는 반드시 실행.
			 */
			e.printStackTrace();
		} finally {
			// 여기는 예외 발생 여부에 상관없이 반드시 실행이 보장되는 블럭.
			// 중요한 마무리 작업을 여기서 주로 수행.
			System.out.println("중요한 마무리 작업을 합니다.");
		}
		System.out.println("main 메소드가 정상 종료 됩니다.");
	}
}
