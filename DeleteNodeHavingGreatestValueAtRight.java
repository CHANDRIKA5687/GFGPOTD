package gkgpotd;
//{ Driver Code Starts
import java.util.*;

class Node
{

  int data;
  Node next;

  Node(int d)
  {
      data = d;
      next = null;
  }
}


public class DeleteNodeHavingGreatestValueAtRight
{
  


  /* Function to print linked list */
 public static void print(Node root)
  {
      Node temp = root;
      while(temp!=null)
      {
          System.out.print(temp.data + " ");
          temp=temp.next;
      }
  }


  /* Driver program to test above functions */
  public static void main(String args[])
  {

      /* Constructed Linked List is 1.2.3.4.5.6.
       7.8.8.9.null */
      int value;
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t > 0 && sc.hasNextInt() )
      {
          int n = sc.nextInt();
          
          //int n=Integer.parseInt(br.readLine());
          int a1 = sc.nextInt();
          Node head = new Node(a1);
          Node tail = head;

          for (int i = 1; i < n && sc.hasNextInt() ; i++)
          {
              int a = sc.nextInt();
              tail.next = new Node(a);
              tail = tail.next;
          }


          Node result = new Solution().compute(head);
          print(result);
          System.out.println();
          t--;
      }
  }
}
//} Driver Code Ends


/*
class Node {
 int data;
 Node next;

Node(int data) {
    this.data = data;
}
}
*/

class Solution
{
  Node compute(Node head)
  {
      if (head == null || head.next == null) {
          return head;
      }

      Node reversedHead = reverse(head); // Reverse the linked list
      Node current = reversedHead;
      Node maxNode = reversedHead; // Initialize maxNode to the first node

      while (current != null && current.next != null) {
          if (current.next.data < maxNode.data) {
              // Delete the node with greater value
              current.next = current.next.next;
          } else {
              // Update maxNode if necessary
              maxNode = current.next;
              current = current.next;
          }
      }

      return reverse(reversedHead); // Reverse the linked list again to get the result
  }

  // Helper function to reverse a linked list
  private Node reverse(Node head) {
      Node prev = null;
      Node current = head;

      while (current != null) {
          Node next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }

      return prev;
  }
}
