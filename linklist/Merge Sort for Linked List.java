/**

https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1#

Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= N <= 105
*/


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head.next == null) return head;
        
        Node middle = getMiddle(head);
        Node middleNext = middle.next;
        middle.next = null; //separate the link list into 2.. first is head second is middleNext
        
        Node part1 = mergeSort(head);
        Node part2 = mergeSort(middleNext);
        
        return merge(part1, part2);
    }
    
    static Node merge(Node p1, Node p2) {
        Node head = null; //start of this list
        Node current = null; //pointer of new list
    
        Node p1Pointer = p1;
        Node p2Pointer = p2;
        
        while (p1Pointer != null && p2Pointer != null) {
            if(p1Pointer.data < p2Pointer.data) {
                if(head == null) {
                    head = p1Pointer;
                    current = head;
                    p1Pointer = p1Pointer.next;
                } else {
                    current.next = p1Pointer;
                    current = current.next;
                    p1Pointer = p1Pointer.next;
                }
            } else {
                if (head == null) {
                    head = p2Pointer;
                    current = head;
                    p2Pointer = p2Pointer.next;
                } else {
                    current.next = p2Pointer;
                    current = current.next;
                    p2Pointer = p2Pointer.next;
                }
            }
        }
        
        if (p1Pointer!=null) {
            current.next = p1Pointer;
        }
        if (p2Pointer!=null) {
            current.next = p2Pointer;
        }
        
        return head;
        
    }
    
    static Node getMiddle(Node head) {
        
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        
        Node n = head;
        Node nn = head;
        while(nn != null && nn.next != null) {
            n = n.next;
            nn = nn.next.next;
        }
        return n;
    }
}


