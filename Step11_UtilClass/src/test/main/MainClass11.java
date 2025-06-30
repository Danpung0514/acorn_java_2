package test.main;

public class MainClass11 {
	public static void main(String[] args) {
		
		int i = 0;
		while(i < 5) {
			System.out.println("i 기준"+(i+1)+"회 반복합니다");
			i++;
		}
		System.out.println("--------");
		
		int j = 0;
		while(true) {
			System.out.println("j 기준"+(j+1)+"회 반복합니다");
			j++;
			if(j == 50000000) {
				break;
			}
		}
	}
}
