package codeinterview;

import java.util.Arrays;
import java.util.TreeSet;

//http://codingdojang.com/scode/410?answer_mode=hide
public class NameList {

	public static void main(String[] args) {

		String[] nameArr = {"이유덕","이재영","권종표","이재영","박민호","강상희","이재영",
				"김지완","최승혁","이성연","박영서","박민호","전경헌","송정환","김재성","이유덕","전경헌"};
	
		//1) 김씨와 이씨는 각각 몇 명?  
		//2) "이재영"이라는 이름은 몇 번 반복되는가?
		//3) 중복을 제거한 이름을 출력  
		//4) 중복을 제거한 이름을 오름차순으로 정렬하여 출력
		int countKim = 0;
		int countLee = 0;
		int countLeeJaeYoung = 0;
		TreeSet ts = new TreeSet();
		Object[] removeDupl = null;
		char[][] removeDuplSort = null;

		for (int i = 0; i < nameArr.length; i++) {
			ts.add(nameArr[i]);
			if (nameArr[i].equals("이재영")) {
				countLeeJaeYoung++;
			} // 이재영 찾기
			
			if (nameArr[i].substring(0, 1).equals("김")) {
				countKim++; // 김씨 찾기
			} else if (nameArr[i].substring(0, 1).equals("이")) {
				countLee++; // 이씨 찾기
			}
		}
		removeDupl = ts.toArray();
		
		System.out.println("1)");
		System.out.println("김씨: " + countKim);
		System.out.println("이씨: " + countLee);
		System.out.println("2)");
		System.out.println("이재영 횟수: " + countLeeJaeYoung);
		System.out.println("3)");
		for (int i = 0; i < ts.size(); i++) {
			if (i == ts.size() - 1) {
				System.out.print(removeDupl[i]);
			} else {
				System.out.print(removeDupl[i] + ",");
			}
		}
		System.out.println();
		System.out.println("4)");
		//Arrays.sort(removeDupl);
		System.out.println(Arrays.toString(removeDupl));
		
	}
	

}
