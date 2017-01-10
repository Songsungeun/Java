package codeinterview;

//
// 0과9 찾기
//- 정수 X가 N의 배수이어야 하고,
//- 0과9로 이루어진 수는 9의 배수이므로
//- 9의 소인수인 3과 입력된 정수 N의 최소공배수를 구한 후,
//- 곱증가 시키면서 0,9만 있는지 판별
//
import java.util.Scanner;

public class ZeroNine {

	private static int lcm(int a, int b) {
		int big, small, mok, remain, gcm, lcm;
		if (a >= b) {
			big = a;
			small = b;
		} else {
			big = b;
			small = a;
		}
		while (true) {
			mok = big/small;
			remain = big - (mok * small); 
			
			if (remain == 0) {
				gcm = small;
				lcm = (a * b)/gcm;
				break;
			}
			big = small;
			small = remain;
		}
		return lcm;
	} // 최소공배수를 구하기 위한 함수(유클리드 알고리즘 사용)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); //테스트 케이스 개수 입력
		
		int[] tn = new int[testCase]; //테스트 케이스 수만큼 배열 생성
		
		for (int i = 0; i < testCase; i++) {
			tn[i] = sc.nextInt();
		} // 테스트 케이스 수만큼 숫자 입력 받기
		
		for (int j = 0; j < tn.length; j++) {
			
			long lcm = lcm(tn[j], 3); // 입력된 숫자와 3의 최소공배수를 구함
			long tmp = lcm; // 곱 증가를 구하기 위해 임시변수에 최소공배수를 담기
			long smallNum = 0; // Result 값을 출력하기 위한 변수
			// 결과값이 정수값의 범위를 벗어날 수 있으므로 long으로 선언
			int count = 2; 
			// 최소공배수가 0,9로 이루어진 수가 아닐 경우 곱증가를 하기 위한 카운트 변수
			
			while(0 < lcm) { // 0과 9로만 이루어진 수를 찾기 위해 10으로 계속해서 나누므로,
							 // 조건에 부합하는 수를 찾게되면 나눈 몫이 0이 되면서 while종료
				
				if((lcm % 10 == 0) || (lcm % 10 == 9)) {
					lcm /= 10; 
					// 10으로 나눈 나머지가 0,9인경우 => 다시 10나눈 후에 10으로 나눈 나머지 확인
				} else {
					lcm = tmp * count; 
					// 0,9로 이루어진 수가 아니라면 최소공배수의 곱증가값으로 다시 확인
					count++;
				}
			}
			smallNum = tmp * (count - 1); 
			// 0,9로 이루어진 수일경우 while문 빠져나오고 해당 값을 구하기 위해 tmp에 (count - 1)을 곱함
			// count는 곱증가 후 무조건 후위증가되도록 되어있기 때문에 count-1을 곱함
			System.out.println(smallNum);
		}
	}
}
