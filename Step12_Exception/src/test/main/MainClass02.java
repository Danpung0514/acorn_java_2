package test.main;

import java.util.Scanner;

public class MainClass02 {
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
		} catch (NumberFormatException nfe) {
			// 예외 객체에 담긴 메세지
			System.out.println(nfe.getMessage());
			System.out.println("좋은말할 때 숫자 형식으로 입력하시오!");
		} catch (ArithmeticException ae) { // catch()를 여러개 사용 가능하다.
			System.out.println("어떤 수를 0 으로 나눌 수 없습니다.");
		}
		System.out.println("main 메소드가 정상 종료 됩니다.");
	}
}
