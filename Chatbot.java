package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class Chatbot {
private Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Chatbot bot=new Chatbot();
		bot.init();

	}
    public void init() {
    	Stack<String>stack=new Stack<String>();
    	System.out.println("Enter how maney bot message insert");
    	int message_count=scan.nextInt();
    	for(int i=0;i<message_count;i++) {
    		stack.push(scan.nextLine());
    	}
    	boolean isValied=true;
    	System.out.println("--------Bot Message  Start---------");
    	while(isValied) {
    		System.out.println("Human:"+scan.nextLine());
    		System.out.println("Robot:"+stack.pop());
    	}
    }
}
