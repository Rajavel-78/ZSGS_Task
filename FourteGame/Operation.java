package zsgstask;

import java.util.*;

public class Operation {
	Scanner scan=new Scanner(System.in);
	public ArrayList<String> operation(String operant) {
		FourteGame2 game2=new FourteGame2();
		 return game2.permutation(operant);
	}
	public void StartOperation() {
		System.out.println("Enter the inputs");
		int resultentNumber=scan.nextInt();
		String input_operant="";
		for(int i=0;i<4;i++) {
			System.out.println("Enter the "+(i+1)+" Number");
			input_operant+=scan.next();
		}
		FourteGame2 game2=new FourteGame2();
		ArrayList<String>operant=game2.permutation(input_operant);
		ArrayList<String>operator=game2.permutation("+-*");
		operator.add("+++");
		operator.add("---");
		operator.add("+/*");
		operator.add("/*+");
		System.out.println(operant);
		System.out.println(operant);
		int result=0;
		String resultString="";
		aa:
		for(int i=0;i<operant.size();i++) {
		  String[] operant_Split=operant.get(i).split("");
		  for(int k=0;k<operator.size();k++) {
			  int b=0;
		  for(int j=0;j<operant_Split.length;j++) {
			 
		   if(j==0) {
		   result=Integer.parseInt(operant_Split[j]);
		   resultString+=operant_Split[j];
		   }
		   String operator_split=operator.get(k)+" ";
		   switch(operator_split.charAt(b)){
		   case '+':
			   resultString+="+"+operant_Split[++j];
			   result+=Integer.parseInt(operant_Split[j]);
			   j--;
			   
		   break;
		   case '-':
			   resultString+="-"+operant_Split[++j];
			   result-=Integer.parseInt(operant_Split[j]);
			   j--;
			  
		  break;
		   case '*':
			   resultString+="*"+operant_Split[++j];
			   result*=Integer.parseInt(operant_Split[j]);
			   j--;
		  break;
		   case '/':
			   resultString+="*"+operant_Split[++j];
			   result*=Integer.parseInt(operant_Split[j]);
			   j--;
			   
		   }b++;
		  }
		  if(result==resultentNumber){
			  System.out.println(resultString+" = "+result);
			 
			  Operation oper=new Operation();
			  oper.stop();
			 break aa; 
		  }else {
			 
			  result=0;
			  resultString="";
		  }
		 
		 }	
	  }
	}
	public void stop() {
		System.out.println("result published");
	}
}
