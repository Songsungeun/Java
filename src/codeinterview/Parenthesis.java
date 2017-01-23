package codeinterview;

import java.util.Scanner;

public class Parenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.next());
		String[] Parenthesis = new String[testCase];

		for (int i = 0; i < Parenthesis.length; i++) {
			Parenthesis[i] = sc.next();
		} //괄호 입력
		
		for (int i = 0; i < Parenthesis.length; i++) {
			int check = 0;

			for (int j = 0; j < Parenthesis[i].length(); j++) {
				
				if (check < 0) {
					break;
				}
				
				if (Parenthesis[i].charAt(j) == '(') {
					check++;
				} else {
					check--;
				}
			}
			
			if (check == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
