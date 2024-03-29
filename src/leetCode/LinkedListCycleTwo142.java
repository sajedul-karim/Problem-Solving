package leetCode;

public class LinkedListCycleTwo142 {

    // https://leetcode.com/problems/linked-list-cycle-ii/

//    Input: head = [3,2,0,-4], pos = 1
//    Output: tail connects to node index 1
//    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode tempNode = node;
        ListNode cycleNode = null;

        int[] nodeValues = new int[]{1, 3, 8, 10, 5, 100, 7}; // cycle at 10

        for (int i = 1; i < nodeValues.length; i++) {
            tempNode.next = new ListNode(nodeValues[i]);
            tempNode = tempNode.next;
            if (i == 3) {
                cycleNode = tempNode;
            }
        }
        tempNode.next = cycleNode;

        System.out.println(detectCycle(node));
    }

    public static ListNode detectCycle(ListNode head) {

        //1. slowNode1 and fastNode will meet at point a. then it has cycle
        //2. slowNode2 and slowNode1 will start moving and at meeting point it will be the cycle point

        if (head == null) {
            return null;
        }

        ListNode slowNode1 = head;
        ListNode fastNode = head;

        boolean isCycleDetected = false;

        while (fastNode != null && fastNode.next != null) {
            slowNode1 = slowNode1.next;
            fastNode = fastNode.next.next;

            if (slowNode1 == fastNode) {
                isCycleDetected = true;
                break;
            }
        }

        if (!isCycleDetected) {
            return null;
        }

        fastNode = head;

        while (slowNode1 != fastNode) {
            slowNode1 = slowNode1.next;
            fastNode = fastNode.next;
        }

        return slowNode1;
    }
}
