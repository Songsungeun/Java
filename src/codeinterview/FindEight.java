package codeinterview;

public class FindEight {

	public static void main(String[] args) {
		int count = 0;

		for (int i = 0; i <= 10000; i++) {
			int left = i;
			while (true) {
				if (left % 10 == 8) {
					count++; // 나머지 8이면 count 증가
				}
				left /= 10;
				if (left == 0) {
					break;
				}
			}
		}
		System.out.println("8의 개수 = " + count);
	}

}
