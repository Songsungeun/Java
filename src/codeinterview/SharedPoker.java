package codeinterview;

public class SharedPoker {
	// 1. 4명의 플레이어가 7장의 카드를 받음 (카드는 4가지 무늬 각 1~13까지, 무늬는 S, H, C, D로 표시)
	// 2. 본인이 가진 7장 카드의 숫자를 합한 수가 가장 작은 사람이 승자
	// 3. 동률이 있을 경우 다시
	// 4. 출력 예)
	// Player1: S7, H3, H2, H1, C5, S5, C8 : sum= 31
	// Player2: D8, C12, C4, S1, H10, D4, D1 : sum= 71
	// Player3: C10, C7, H11, S13, S6, S12, D3 : sum= 133
	// Player4: D13, D7, S9, S3, C2, D2, C9 : sum= 178
	// Winner : Player1
	public static void main(String[] args) {
		String[] card = new String[52];
		String[] shape = {"S", "H", "C", "D"};
		String[][] people = new String[4][8];
		
		boolean loopCheck = true;
		
		while (loopCheck) {

			int temp = 0;
			int cardQun = 0;

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= 13; j++) {
					card[cardQun] = shape[temp] + Integer.toString(j);
					cardQun += 1;
				}
				temp += 1;
			} // card 배열에 카드 삽입

			for (int i = 0; i < card.length; i++) {
				String temp1;
				temp = (int)(Math.random() * card.length);
				temp1 = card[i];
				card[i] = card[temp];
				card[temp] = temp1;
			} //카드 섞기
			
			System.out.println("카드 리스트");
			for (String cardList : card) {
				System.out.println(cardList);
			}
			
			temp = 0;
			for (int i = 0; i < 4; i ++) {
				cardQun = 0;
				
				switch (i) {
				case 0: System.out.print("Player1: "); break;
				case 1: System.out.print("Player2: "); break;
				case 2: System.out.print("Player3: "); break;
				case 3: System.out.print("Player4: "); break;
				}
		
				for (int j = 0; j < 7; j++) {
					people[i][j] = card[temp];
					temp += 1;
					cardQun += Integer.parseInt(people[i][j].substring(1));
					if (j == 6) {
						System.out.print(people[i][j] + " : ");
					} else {
						System.out.print(people[i][j] + ", ");
					}
				}
				people[i][7] = Integer.toString(cardQun);
				System.out.println("sum= " + people[i][7]);
			} // 카드 배분 및 sum 입력, 프린트
			
			int min = Integer.parseInt(people[0][7]);
			int winner = 0;
			boolean checkFlag = true;
			
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					if (people[i][7] == people[j][7]) {
						checkFlag = false;
					} else if (Integer.parseInt(people[i][7]) > Integer.parseInt(people[j][7])){
						min = Integer.parseInt(people[j][7]);
						winner = j;
					} else {
						continue;
					}
				}
			} // 동일한 합계가 있는지 비교 및 최소값 찾기
			
			if (checkFlag) {
				System.out.println("Winner : Player" + (winner + 1));
				loopCheck = false;
			} else {
				continue;
			}
			
		}
	}

}
