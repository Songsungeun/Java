package codeinterview;


//
// 더 큰 문자열 찾기
//- 입력된 문자열의 마지막 문자부터 좌측으로 비교 검증하여,
//- 좌측값 < 우측값(i - 1 < i) 가 될때의 좌측값(i - 1)이 기준 문자가 되고,
//- 기준 문자의 우측 문자열 중 기준 문자보다 크면서, 그 중 제일 작은 문자와 기준문자의 위치 교체
//- 이후 교체된 기준 문자의 우측 문자열을 오름차순 정렬하면 => 큰 문자중 가장 작은 문자가 됨
//
//- 결과는 좌측문자열 + 변환된 우측문자열로 출력
//	 	=> ex) "abezxj" 입력
//			   기준문자 = 'e' (i - 1 < i)가 될때의 문자
//			   기준문자의 우측 문자열 ("zxj")에서 기준문자(e)보다 크면서,
//			   그 중 가장 작은 j와 기준 문자 e를 swap. => "abjzxe"
//             이후 기준문자 위치 기준으로 우측 문자열을 오름차순 정렬.
//		       "zxe" => "exz"로 정렬  ----> result = "abj" + "exz" = "abjexz"
//
import java.util.Scanner;

public class MoreThanString {

	private static String findMinChar(String text) {
		StringBuffer bigText = new StringBuffer(); // 기준문자보다 큰 문자들을 담을 변수
		StringBuffer smallText = new StringBuffer(); // 기준문자보다 작은 문자들을 담을 변수
		
		// 반복문을 통하여 기준문자보다 큰 문자들과 작은 문자들을 분리.
		for (int i = 1; i < text.length(); i++) {
			if (text.charAt(0) < text.charAt(i)) {
				bigText.append(text.charAt(i));
			} else {
				smallText.append(text.charAt(i));
			}
		}
		
		// 기준문자보다 큰 문자들 중 가장 작은 문자를 찾기 위해 문자들을 정렬한 후
		// sortString 변수에 정렬된 문자의 참조값을 할당한다.
		// (이번 정렬은 bigText중 가장 작은 문자를 0번째 인덱스에 위치시키기 위함)
		String sortString = sortString(bigText.toString());
		
		// bigText 중 가장 작은 문자 + 기존이 기준 문자 + smallText로 이루어진 문자열을 반환.
		StringBuffer sortSb = new StringBuffer(sortString.length() + 1);
		sortSb.append(sortString);
		sortSb.append(text.charAt(0));
		sortSb.append(smallText);
		
		return sortSb.toString();
	}
	
	// 문자열 정렬용 메소드(버블 정렬)
	private static String sortString(String text) {
		char[] tmpArr = text.toCharArray();
		for (int i = 0; i < tmpArr.length - 1; i++) {
			for (int j = 1; j < tmpArr.length; j++) {
				if (tmpArr[j - 1] > tmpArr[j]) {
					char tmp = tmpArr[j - 1];
					tmpArr[j - 1] = tmpArr[j];
					tmpArr[j] = tmp;
				}
			}
		}
		return new String(tmpArr);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트케이스 수
		String w = null; // 입력 받을 문자열
		String[] sArr = new String[testCase]; // 출력할 문자열
		String leftText = null; // 기준 문자 좌측 문자열
		String rightText = null; // 기준 문자 우측 문자열
		String tmp; // 임시변수
		int index = 0; // 결과값 출력을 위한 s[]의 인덱스
		
		// 테스트케이스만큼 반복
		while (testCase > 0) {
			w = sc.next();
			for (int i = w.length() - 1; i > 0; i--) {
				StringBuffer reverseText = new StringBuffer(w); // no answer 확인용 변수
				String sortText = sortString(w); // no answer 확인용 변수
				
				// 정렬한 문자열(checkText)과 입력된 문자열의 역순(reverseText)이 같은지 비교
				// 같다면 가장 큰 문자열이므로 "no answer"
				if (sortText.equals(reverseText.reverse().toString())) {
					sArr[index] = "no answer";
					break; // no answer 이므로 이번 TestCase는 break
				
				// 가장 큰 문자열이 아닐 경우에는
				// 기준이 되는 문자를 찾는다.
				} else if (w.charAt(i - 1) < w.charAt(i)) {
					// 위의 조건이 참인 경우 기준이 되는 문자 = w.charAt(i - 1)
					// findMinChar()를 통해 기준문자 포함한 우측 문자열 중
					// 기준문자보다 크면서, 그 중 가장 작은 문자를 찾는다.
					tmp = findMinChar(w.substring(i - 1));
					
					// (반환된 문자열 중 0번째 인덱스 + 나머지 문자열 정렬한 참조값)을 할당.
					rightText = tmp.substring(0, 1) + sortString(tmp.substring(1));
					// 기준문자의 좌측 문자열은 변동 없으므로 그대로 할당.
					leftText = w.substring(0, i - 1);
					// 출력값 할당
					sArr[index] = leftText + rightText; 
					break;
				}
			}
			index++;
			testCase--;
		}
		
		// 결과값 출력
		for (int i = 0; i < sArr.length; i++) {
			System.out.println(sArr[i]);
		}
	}
}
