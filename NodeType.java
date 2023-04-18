public class NodeType<T extends Comparable<T>> {
	public T info;
	public NodeType<T> next;
	public NodeType<T> back;
	
	public NodeType(T info2, NodeType<T> next, NodeType<T> back) {
        this.info = info2;
        this.next = next;
        this.back = back;
    }
	
	public int compareTo(T object) {
		return info.compareTo(object);
	}
}
