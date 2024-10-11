package Cycle2;
import java.util.*;
public class Doublylinkedlist 
{
	Node head;
	
	class Node
	{
		private int data;
		Node prev;
		Node next;
		
		Node(int data)
		{
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	public void insert(int data)
	{
		Node new_node=new Node(data);
		if(head==null)
			head=new_node;
		else
		{
			Node temp=head;
			while(temp.next!=null)
				temp=temp.next;
			temp.next=new_node;
			new_node.prev=temp;
		}
	}
	void delete(int data)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Node temp=head;
			while(temp.data!=data)
				temp=temp.next;
			if(temp.prev!=null)
				temp.prev.next=temp.next;
			if(temp.next!=null)
				temp.next.prev=temp.prev;
			if(temp==head)
				head=temp.next;
				temp=null;
		}
	}
	void display()
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			System.out.println("List: ");
			Node temp=head;
			while(temp!=null)
			{
				System.out.println(temp.data+"");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		Doublylinkedlist dll=new Doublylinkedlist();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("\n1.Inset\n2.Delete");
			System.out.println("3.Display\n4.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			System.out.println();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the element to be inserted");
				int element=sc.nextInt();
				dll.insert(element);
				dll.display();
				break;
			case 2:
				System.out.println("Enter the element to be deleted:");
				int element1=sc.nextInt();
				dll.delete(element1);
				dll.display();
				break;
			case 3:
				dll.display();
				break;
			case 4:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}
