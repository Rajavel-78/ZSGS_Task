
package zsgstask;

import java.util.*;

public class FourteGame2 {
Scanner scan=new Scanner(System.in);
static FourteGame2 game=new FourteGame2();	
	public ArrayList<String> permutation(String a){
		ArrayList<String>operant_permutation=new ArrayList<String>();
		operant_permutation=game.generatePermutation(a,0,a.length(),operant_permutation);
		
		return (operant_permutation);
	}
	public ArrayList<String> generatePermutation(String a, int first, int length,ArrayList<String>arr) {
		if(first==length-1) {
			arr.add(a);
		}
		else {
		    for(int i=first;i<length;i++) {
		    	a=swapString(a, first,i,arr);
		    	game.generatePermutation(a, first+1,length,arr);
		    	a=swapString(a, first,i,arr);
		    }	
		}
	 return arr;
	}public static String swapString(String n,int start,int end,ArrayList<String>arr) {
		char[]operant=n.toCharArray();
		char first;
		first=operant[start];
		operant[start]=operant[end];
		operant[end]=first;
		return String.valueOf(operant);
		
		
	}
}
