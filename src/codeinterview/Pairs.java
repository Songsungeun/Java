package codeinterview;


//
// 정수쌍(Pairs)
//- 입력된 수를 짝수와 홀수로 나눔
//- 입력된 차 kgap이 짝수인 경우 => 무조건 짝수끼리 or 홀수끼리의 차이
//  => (짝수, 짝수), (홀수, 홀수) 로 나누어서 확인
//- 입력된 차 kgap이 홀수인 경우 => 무조건 짝수와 홀수의 차이
//- => (짝수, 홀수) 로만 확인
//

import java.util.ArrayList;
import java.util.Scanner;

public class Pairs {
	
	static ArrayList<Integer> evenList = new ArrayList<Integer>();
	static ArrayList<Integer> oddList = new ArrayList<Integer>();
	static int count;
	
	static void forEven(int kgap) {
		for (int i = 0; i < evenList.size() - 1; i++) {
			for (int j = i + 1; j < evenList.size(); j++) {
				if(kgap == Math.abs((evenList.get(i)-evenList.get(j)))) {
					count++;
				}
			}
		}// 짝수리스트 안에서 조건을 확인
		
		for (int i = 0; i < oddList.size() - 1; i++) {
			for (int j = i + 1; j < oddList.size(); j++) {
				if(kgap == Math.abs((oddList.get(i)-oddList.get(j)))) {
					count++;
				}
			}
		}// 홀수리스트 안에서 조건을 확인
	}
	
	private static void forOdd(int kgap) {
		for (int i = 0; i < evenList.size(); i++) {
			for (int j = 0; j < oddList.size(); j++) {
				if(kgap == Math.abs((evenList.get(i)-oddList.get(j)))) {
					count++;
				}
			}
		}// 짝수,홀수의 조합에서만 조건을 확인
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next()); // 정수의 개수 입력
		int kgap = Integer.parseInt(sc.next()); // 차이 입력
		//int[] inputNumArr = new int[num]; // 입력받을 정수의 개수만큼 배열 준비
		
		for (int i = 0; i < num; i++) {
			int tmp = Integer.parseInt(sc.next());
			if (tmp % 2 == 0) { // 짝수인 경우
				evenList.add(tmp);
			} else { // 홀수인 경우
				oddList.add(tmp);
			}
		} // 정수 입력
		
		if (kgap % 2 == 0) {
			forEven(kgap); // 짝수조건 함수 호출
		} else {
			forOdd(kgap); // 홀수조건 함수 호출
		}
		
		System.out.println(count); // 개수 출력
	}

}
