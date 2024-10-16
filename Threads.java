package Cycle2;

import java.util.Scanner;


class PrintInt implements Runnable{
	int limit;
	PrintInt(int limit){
		this.limit=limit;
	}
	void CheckNumber(int rand) {
		if(rand%2==0) {
			EvenPrint evn=new EvenPrint(rand);
			Thread t=new Thread(evn);
			t.start();
		}
		else {
			OddPrint odd=new OddPrint(rand);
			Thread t=new Thread(odd);
			t.start();
		}
	}
	public void run() {
		for(int i=0;i<limit;i++) {
			int rand=(int)(Math.random()*100);
			System.out.println("Random number:"+rand);
			CheckNumber(rand);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class EvenPrint implements Runnable{
	int num;
	EvenPrint(int num){
		this.num=num;
	}
	public void run() {
		System.out.println("Square:"+num*num);
	}
}
class OddPrint implements Runnable{
	int num;
	OddPrint(int num){
		this.num=num;
	}
	public void run() {
		System.out.println("Cubee:"+num*num*num);
	}
}
public class Threads {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int limit=sc.nextInt();
		PrintInt print=new PrintInt(limit);
		Thread t=new Thread(print);
		t.start();

	}

}
