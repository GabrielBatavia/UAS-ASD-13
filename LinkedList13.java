public class LinkedList13<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList13() {
        this.head = null;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public T get(int index) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void sort(java.util.Comparator<? super T> comparator) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, comparator);
    }

    private Node mergeSort(Node node, java.util.Comparator<? super T> comparator) {
        if (node == null || node.next == null) {
            return node;
        }
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(node, comparator);
        Node right = mergeSort(nextOfMiddle, comparator);
        return sortedMerge(left, right, comparator);
    }

    private Node sortedMerge(Node left, Node right, java.util.Comparator<? super T> comparator) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node result;
        if (comparator.compare(left.data, right.data) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right, comparator);
        } else {
            result = right;
            result.next = sortedMerge(left, right.next, comparator);
        }
        return result;
    }

    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
