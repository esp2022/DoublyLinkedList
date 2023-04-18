public class DoublyLinkedList {
	private NodeType head;
	private NodeType tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}

	public int length() {
		// return size;
		int length = 0;
		NodeType curr = head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public <T> void push(T info) {
		NodeType curr = head;
		while (curr != null) {
			if (curr.info.compareTo(info) == 0) {
				return;
			}
			curr = curr.next;
		}
		
		NodeType tmp = new NodeType((Comparable) info, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size++;
	}
	
	public <T> void insertItem(T info) {
		NodeType curr = head;
		while (curr != null) {
			if (curr.info.compareTo(info) == 0) {
				System.out.print("\nItem already exists");
				return;
			}
			curr = curr.next;
		}
		
		NodeType tmp = new NodeType((Comparable) info, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size++;
	}

	public <T> NodeType findLowerBoundNode(T info) {
		NodeType tmp = head;
		while (tmp != null) {
			if (tmp.info.compareTo(info) >= 0) {
				return tmp;
			}
			tmp = tmp.next;
		}
		return null;
	}

	public <T> NodeType findUpperBoundNode(T info) {
		NodeType tmp = head;
		while (tmp != null) {
			if (tmp.info.compareTo(info) == 0) {
				return tmp;
			}
			if (tmp.info.compareTo(info) > 0) {
				return tmp.back;
			}
			if (null == tmp.next) {
				return tmp;
			}
			tmp = tmp.next;
		}
		return tmp;
	}

	public <T> void deleteSubsection(NodeType lbn, NodeType ubn) {
	if (lbn == null || ubn == null) {
			return;
		}
		if (lbn.info.compareTo(ubn.info) > 0) {
			return;
		}
		if (lbn.info.compareTo(ubn.info) == 0) {
			deleteItem(lbn.info);
			return;
		}
		if (lbn.info.compareTo(head.info) == 0 && ubn.info.compareTo(tail.info) == 0) {
			head = null;
			tail = null;
			size = 0;
			return;
		}
		NodeType final_prev_node = lbn.back;
		NodeType final_next_node = ubn.next;
		if (final_next_node != null) {
			final_next_node.back = final_prev_node;
		}
		if (final_prev_node != null) {
			final_prev_node.next = final_next_node;
		}
		if (final_prev_node == null) {
			NodeType tmp = head;
			while (tmp != null) {
				if (tmp.info.compareTo(final_next_node.info) == 0) {
					//tmp = tmp.back;
					head = tmp;
					return;
				}
				tmp = tmp.next;
			}
		}
		if (final_next_node == null) {
			NodeType tmp = tail;
			while (tmp != null) {
				if (tmp.info.compareTo(final_prev_node.info) == 0) {
					//tmp = tmp.back;
					tail = tmp;
					return;
				}
				tmp = tmp.back;
			}
		}
		return;
	}

	private <T> NodeType findHeadNode(T info) {
		NodeType tmp = head;
		while (tmp != null) {
			if (tmp.info.compareTo(info) == 0) {
				return tmp;
			}
			tmp = tmp.next;
		}
		return null;
	}

	public <T> void deleteItem(T info) {
		NodeType del = findHeadNode(info);
		if (del == null) {
			System.out.print("\nThe item is not present in the list");
			return;
		}
		if (head == null) {
			System.out.print("\nYou cannot delete from an empty list");
			return;
		}
		if (head == del) {
			head = del.next;
		}
		if (tail == del) {
			tail = del.back;
		}
		if (del.next != null) {
			del.next.back = del.back;
		}
		if (del.back != null) {
			del.back.next = del.next;
		}
		
		/*NodeType del_tail = findTailNode(info);
		if (tail == del_tail) {
			tail = del_tail.next;
		}
		if (del_tail.next != null) {
			del_tail.next.back = del_tail.back;
		}
		if (del_tail.back != null) {
			del_tail.back.next = del_tail.next;
		}*/
		size--;
		return;
	}

	public <T> void alternateSwap() {
		NodeType odd_node = head;
		NodeType even_node = odd_node != null && odd_node.next != null ? odd_node.next : null;
		
		while (odd_node != null && even_node != null) {
			Comparable even_node_info = (Comparable) even_node.info;
			Comparable odd_node_info = (Comparable) odd_node.info;
			
			odd_node.info = even_node_info;
			even_node.info = odd_node_info;
			
			odd_node = even_node.next != null ? even_node.next : null;
			even_node = odd_node != null && odd_node.next != null ? odd_node.next : null;
		}
		return;
	}

	public void print() {
		NodeType tmp = head;
		while (tmp != null) {
			System.out.print(tmp.info + " ");
			tmp = tmp.next;
		}
	}

	public void printReverse() {
		NodeType tmp = tail;
		while (tmp != null) {
			System.out.print(tmp.info + " ");
			tmp = tmp.back;
		}
	}

	public <T> void sortList() {
		NodeType current = null, index = null;
		T temp;
		if (head == null) {
			return;
		} else {
			for (current = head; current.next != null; current = current.next) {
				for (index = current.next; index != null; index = index.next) {
					if (current.info.compareTo(index.info) > 0) {
						temp = (T) current.info;
						current.info = index.info;
						index.info = (Comparable) temp;
					}
				}
			}
		}
	}
	
	public <T> void deSortList() {
		NodeType current = null, index = null;
		T temp;
		if (head == null) {
			return;
		} else {
			for (current = head; current.next != null; current = current.next) {
				for (index = current.next; index != null; index = index.next) {
					if (current.info.compareTo(index.info) < 0) {
						temp = (T) current.info;
						current.info = index.info;
						index.info = (Comparable) temp;
					}
				}
			}
		}
	}
}
