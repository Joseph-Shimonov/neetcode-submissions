class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class LinkedList {

    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        // iterate thru head and find the val at the index
        ListNode curr = head.next;
        int i = 0;
        while (curr != null) {
            System.out.println(curr.val);
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }

        // if we came out of this loop, then that mean that the value does not exist
        return -1;
    }

    public void insertHead(int val) {
        // create a new listnode, and make the pointer head
        ListNode temp = new ListNode(val);
        temp.next = this.head.next;
        head.next = temp;

        if (temp.next == null) {
            this.tail = temp;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        ListNode curr = this.head;
        int i = 0;

        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        // at this point we want curr.next to be equal to curr.next.next
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = this.head.next;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
