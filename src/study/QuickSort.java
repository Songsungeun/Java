package study;

public class QuickSort {
	static int[] element = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
	
	public static void main(String[] args) {
		quickSort(0, element.length - 1);
		print();
	}

	private static void quickSort(int startIndex, int endIndex) {
		if ((endIndex - startIndex) <= 0) {
			return;
		}
		
		int pivotIndex = startIndex;
		int storeIndex = pivotIndex + 1;
		
		for (int i = pivotIndex + 1; i <= endIndex; i++) {
			if (element[i] < element[pivotIndex]) {
				swap(i, storeIndex);
				storeIndex++;
			}
		} // element[pivotIndex] 보다 작은 놈을 옆으로 옮겨놓는다.
		swap(pivotIndex, storeIndex - 1);
		// 위치를 변경하여 pivotIndex기준 좌측은 pivot보다 작은수, 우측은 pivot보다 큰
		
		// 재귀함수 사용
		quickSort(startIndex, storeIndex - 2);// pivot보다 작은수들 다시 정렬
		quickSort(storeIndex, endIndex);// pivot보다 큰 수들 다시 정렬
	}
	
	static void swap(int index1, int index2) {
		if (index1 == index2) {
			return;
		}
		
		int tmp = element[index1];
		element[index1] = element[index2];
		element[index2] = tmp;
	}
	
	static void print() {
		for (int value : element) {
			System.out.printf("%d, ", value);
		}
	}

}
