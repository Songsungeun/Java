package codeinterview;

//
// 배열의 무게중심
//- 두번째 입력값 ~ 마지막 바로 전 입력값까지를 기준값으로 설정 후
//- 왼쪽합과 오른쪽합을 구해 비교.
//
import java.util.Scanner;

public class BaryCenter {

	static boolean checkFlag;

	static void compareSum(int[] arr, int pivot) {
		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < pivot; i++) {
			leftSum += arr[i];
		} // pivot 기준 좌측 합 

		for (int j = pivot + 1; j < arr.length; j++) {
			rightSum += arr[j];
		} // pivot 기준 우측 합
		if (leftSum == rightSum) {
			checkFlag = true; // 같으면 checkFlag를 true로 변경
			return;
		} 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트 케이스의 수 입력 받아 초기화
		int index = 0; // 결과값 배열에 이용할 인덱스 변수
		boolean[] outputResultArr = new boolean[testCase];

		while (0 < testCase) {
			int arrSize = sc.nextInt(); //배열의 크기 만큼 받기
			checkFlag = false;
			int[] inputElementArr = new int[arrSize]; // 배열의 크기만큼 초기화

			for (int i = 0; i < arrSize; i++) {
				inputElementArr[i] = Integer.parseInt(sc.next()); // 각 요소 입력
			}

			for (int j = 1; j < arrSize - 1; j++) {
				// 첫번째 인덱스와 마지막 인덱스 제외하고 실행
				compareSum(inputElementArr, j);
				if (checkFlag) { // 함수 호출 후 현재 checkFlag 확인
					outputResultArr[index] = true;
					break; // true이면 해당 TestCase는 무조건 "yes"이므로 break
				} else {
					outputResultArr[index] = false;
				}
			} // 함수 실행하면서 결과값에 true, false로 저장
			index++;
			testCase--;
		}
		
		for (int i = 0; i < outputResultArr.length; i++) {
			if (outputResultArr[i]) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		} // 결과값 출력
	}
}
