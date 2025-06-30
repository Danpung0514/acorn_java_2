package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainClass12 {
	public static void main(String[] args) {
		// 1. 로또 번호를 담을 HashSet 객체를 생성해서 참조값을 Set type set1 이라는 지역 변수에 담아보자.
		Set<Integer> set1 = new HashSet<>();
		
		// 2. Random 객체를 생성해서 참조값을 ran 이라는 지역변수에 담아보자.
		Random ran = new Random();
		
		/*
		 *  3. while 문을 이용해서 랜덤한 로또 번호를 set1 에 반복적으로 담는다.
		 *  
		 *    while 문은 무한 루프로 만들고 while 문 탈출 조건은 set1.size() 가 6 이 되면 탈출
		 *    
		 *    ran.nextInt(45)+1 은 1~45 사이의 랜덤한 정수를 얻어낼 수 있다.
		 *    로또 번호는 총 6개.
		 */
		while(true) {
			int lottonum = ran.nextInt(45)+1;
			set1.add(lottonum);
			if(set1.size() == 6) {
				break;
			}
		}
		
		// 4. set1 에 담긴 번호를 모두 하나씩 콘솔창에 출력 해보자.
		System.out.println("무작위로 담긴 로또번호 입니다.");
//		for(int num : set1) {
//			System.out.println(num);
//		}
		set1.forEach(num->System.out.print(num+" ")); // forEach 문
		
		// 5. AI 에 물어봐서 set1 에 담긴 내용을 List 에 담은 다음 오름차순 정렬 해보자.
		List<Integer> sortedList = new ArrayList<>(set1); // Set 를 ArrayList 생성자에 직접 담으면 Array 에 담긴다
		Collections.sort(sortedList);
		
		System.out.println(); // 직전 print()의 개행
		
		// 6. 오름차순 정렬된 번호를 하나씩 순서대로 콘솔창에 출력 해보자.
		System.out.println("오름차순 정렬된 로또번호 입니다.");
//		for(int num : sortedList) {
//			System.out.println(num);
//		}
		sortedList.forEach(num->System.out.print(num+" ")); // forEach 문
//		System.out.println(sortedList);
	}
}
