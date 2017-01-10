package codeinterview;


//
// 주식투자
//- 최고가인날 이전에는 전부 주식을 사고, 최고가인날 판매하는 것이 최대 이득이므로
//- 설정된 주식가격중 최고가인 날을 찾음
//- 최고가 이전인날은 매일 주식 구매 => 최고가인날 모든 주식 판매
//- 최고가인날 이후에 또 다시 최고가인날을 찾아서 동일한 작업을 진행(반복)
//- 마지막 날까지 진행시 반복 종료
//
import java.util.Scanner;

public class StockInvest {
	
	static int stock; // 구매한 주식 수
	static int purchase; // 총 구매가격
	static int sale; // 총 판매 가격
	
	static int maxIndex(int[] stockPrice, int startIndex, int endDay) {
		int maxCost = stockPrice[startIndex];;
		int maxIndex = startIndex;
		for (int i = startIndex; i <= endDay; i++) {
			if (maxCost < stockPrice[i]) {
				maxCost = stockPrice[i];
				maxIndex = i;
			}
		} // 첫날의 가격을 기준으로, 최대값인 날의 인덱스를 찾아서 리턴
		return maxIndex;
	} // 입력된 주식가격중 가장 높은 날을 찾도록 구현
	
	static void stockCalc(int[] stockPrice, int startIndex, int maxIndex) {
		
		for (int i = startIndex; i < maxIndex; i++) {
			purchase += stockPrice[i];
			stock++;
		} // 최대값인 날 전까지 계속해서 주식 구매
		
		sale += stock * stockPrice[maxIndex]; // 최대값인 날 모든 주식 판매
		stock = 0; // 모든 주식 판매했으므로, 주식수량은 0으로 초기화
	} // 최대값인 날 전까지 매일 주식 구매 후, 최대값인 날 팔도록 구현
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트케이스 횟수 입력
		int[] benefit = new int[testCase]; // 각 테스트케이스별 이익을 저장할 배열
		int k = 0; // benefit 배열의 인덱스를 설정하기 위한 변수
		
		while (0 < testCase) {
			stock = 0; 
			purchase = 0;
			sale = 0; // 새로운 테스트케이스 확인시 값들 모두 0으로 초기화
			int nDay = sc.nextInt(); // 총 일수를 입력
			int maxIndex = 0; // 가장 높은 가격을 가진 인덱스를 저장할 변수
			int[] stockPrice = new int[nDay]; // 각각의 주식 가격을 입력할 배열
			int startIndex = 0; // maxIndex 찾을시 시작할 인덱스를 결정할 변수
			
			for (int i = 0; i < nDay; i++) {
				stockPrice[i] = Integer.parseInt(sc.next());
			}// 주식가격 입력
			
			while (true) {
				maxIndex = maxIndex(stockPrice, startIndex, nDay - 1);
				stockCalc(stockPrice, startIndex, maxIndex);
				startIndex = maxIndex + 1; 
				// 최고가인날 판매 후, 다음날부터 다시 확인하기 위해서
				// startIndex를 maxIndex + 1로 설정
				if (startIndex >= nDay - 1) {
					break;
				} // startIndex가 배열의 끝인 경우 while문 종료
			}
			
			
			benefit[k] = sale - purchase; //각 테스트케이스의 이익 입력
			testCase--;
			k++;
		}
		
		for (int i = 0; i < benefit.length; i++) {
			System.out.println(benefit[i]);
		}
	}
}
