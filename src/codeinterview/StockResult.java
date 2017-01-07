package codeinterview;

import java.util.Scanner;

public class StockResult {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			//1) 첫번째 줄에 투자액 a가 입력됨 (100 <= a <= 10,000)
			System.out.println("투자액 입력(100 ~ 10,000)");
			int money;
			int days;
			double resultMoney;

			Money: while (true) {
				money = sc.nextInt();
				if (!(100 <= money) || !(money <= 10000)) {
					System.out.println("10 ~ 10,000으로 입력해주세요.");
					continue Money;
				} else {
					break Money;
				}
			}

			Period: while (true) {
				//2) 두번째 줄에 투자일 수 b가 입력됨(1 <= b <= 10)
				System.out.println("투자일수 입력(1~10)");
				days = sc.nextInt();
				if (!(1 <= days) || !(days <= 10)) {
					System.out.println("1~10으로 입력해주세요.");
					continue;
				} else {
					break Period;
				}
			}

			//3) 세번째 줄에 일별 변동폭인 데이터가 날짜 갯수(b개)만큼 퍼센트 정수로 입력 (-100 ~ +100)
			System.out.println("변동률을 입력해주세요. -100 ~ 100");
			resultMoney = money + 0d; // 최종 금액
			System.out.println("money= " + money);
			int changeRate;

			System.out.println("투자일수간 변동률 입력");
			for (int i = 0; i < days; i++) {
				changeRate = sc.nextInt();
				if (!(-100 <= changeRate) || !(changeRate <= 100)) {
					System.out.println("당일 변동률은 -100 ~ 100까지입니다.");
					i = i - 1;
				} else {
					resultMoney += (resultMoney * (changeRate / 100d));
				}
			}
			//출력
			//1) 순수익(=총 수익(최종값) - 총 비용(투자금))을 소수점 첫째 자리에서 반올림하여 출력
			double earned = Math.round(resultMoney - money); 
			System.out.println("수익= " + earned);
			//2) 다음줄에 이득인 경우 "good", 본전일 경우 "same", 손해일 경우 "bad" 출력  
			//  * -0.5 < 순수익 < 0.5 인 경우 순수익은 0으로 간주
			if (0.5 <= earned) {
				System.out.println("good");
			} else if (earned <= -0.5) {
				System.out.println("bad");
			} else {
				System.out.println("same");
			}
		} catch (Exception e) {
			throw new Exception("숫자만 입력 가능합니다.");
		}


	}

}
