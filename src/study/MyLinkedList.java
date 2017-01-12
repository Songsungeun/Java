package study;

import java.util.Iterator;

public class MyLinkedList {
	
	Node head;
	Node tail;
	int count;
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(600);
		list.add(700);
		list.add(800);
		list.add(900);

		list.insert(4, 500); //500 삽입
		list.remove(7); // 800 삭제
		Iterator iterator = list.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	public MyLinkedList() {
		head = new Node();
		tail = head;
	}
	
	public void add(Object value) {
		tail.value = value;
		tail.next = new Node();
		tail = tail.next;
		count++;
	}
	
	public void insert(int index, Object value) {
		if (index < 0 || index >= count) {
			throw new RuntimeException("인덱스 범위가 아닙니다.");
		}
		
		Node currNode = head;
		Node tmp;
		
		int currIndex = index;
		while (--currIndex > 0) {
			currNode = currNode.next;
		} // 해당 인덱스 바로 전 노드를 찾기
		
		tmp = new Node(value);
		if (index == 0) {
			tmp.next = head;
			head = tmp;
			//0번째 인덱스라면, tmp는 기존의 head를 가리키고, head는 tmp가 된다
		} else {
			tmp.next = currNode.next;
			currNode.next = tmp;
		}// 0번째가 아니라면, tmp는 인덱스 바로전 노드가 가리키던 주소를 가리키고
		 // 인덱스 바로전 노드는 tmp를 가리킨다.
		count++;
	}
	
	public Object remove(int index) {
		if (index < 0 || index >= count) {
			throw new RuntimeException("인덱스 범위가 아닙니다.");
		}
		
		Node currNode = head;
		Node prevNode = null;
		
		for (int i = 0; i < index; i++) {
			prevNode = currNode; // 현재 노드 주소를 보관
			currNode = currNode.next; // 다음 노드 주소를 가리킴
		}
		
		if (index == 0) {
			head = head.next; //0번째 인덱스라면 기존의 head가 가리키던 노드가 head가 됨
		} else {
			prevNode.next = currNode.next;
			// 한칸 건너 뛴다. 이전의 노드가 가리키던 주소 =  현재의 노드가 가리키던 주소
		}
		count--;
		return currNode.value;
	}
	
	public Object get(int index) {
		if (index < 0 || index >= count) {
			throw new RuntimeException("인덱스 범위가 아닙니다.");
		}
		Node currNode = head;
		
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		
		return currNode.value;
	}
	
	public int size() {
		return count;
	}
	
	public void print() {
		Node tmp = head;
		while (tmp != null && tmp != tail) {
			System.out.printf("%d - ", (int)tmp.value);
			tmp = tmp.next;
		}
		System.out.println();
	}
	
	public Iterator iterator() {
		return new Iterator() {
			int index;

			@Override
			public boolean hasNext() {
				if (index >= 0 && index < size()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Object next() {
				return get(index++);
			}
		};
	}
	class Node {
		Object value;
		Node next;

		public Node() {}
		
		public Node(Object value) {
			this.value = value;
		}
	}
}
