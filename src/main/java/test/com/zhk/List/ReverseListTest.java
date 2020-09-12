package test.com.zhk.List; 

import com.zhk.List.ListNode;
import com.zhk.List.ReverseList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReverseList Tester. 
* 
* @author <Authors name> 
* @since <pre>6月 1, 2020</pre> 
* @version 1.0 
*/ 
public class ReverseListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reverseList(ListNode head) 
* 
*/ 
@Test
public void testReverseList() throws Exception { 
//TODO: Test goes here...
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = null;
    ListNode head = new ReverseList().reverseList2(l1);
    System.out.println(listNodeToString(head));
}

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }


} 
