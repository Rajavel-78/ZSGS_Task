package zsgstask;

import java.util.*;

public class FourteGame {
static Scanner scan=new Scanner(System.in);
static FourteGame game=new FourteGame();	
public static void main(String[] args)throws Exception {
		
		game.operation();
	}
	private void operation() {
		System.out.println("Enter the Resul number");
		int resultNumber=scan.nextInt();
		ArrayList<String>options=new ArrayList<String>();
		ArrayList<String>operator=new ArrayList<String>();
		operator.add("+");
		operator.add("-");
		operator.add("-");
		operator.add("+");
		
		for(int i=0;i<4;i++) {
			System.out.println("Enter the "+(i+1)+" option");
			options.add(scan.next());
		}
	    
		int result=0;
		String equation="";
		boolean isValid=true;
		int j=0;
		int k=0;
		int l=1;
		int n=2;
		while(isValid) {
		
		for(int i=0;i<options.size();i++){
			if(k>options.size()-1) {
				k=3;
			}
			 equation+=options.get(k++);
			 equation+=operator.get(j);
			 if(k>options.size()-1) {
					k=2;
				}
			 equation+=options.get(k++);
			 equation+=operator.get(l);
			 if(k>options.size()-1) {
					k=1;
				}
			 equation+=options.get(k++);
			 equation+=operator.get(n);
			 if(k>options.size()-1) {
					k=0;
				}
			 equation+=options.get(k++);
			System.out.println(equation);
			String[] arr=equation.split("");
			String a1="1+1+!+1";
			for(int a=0;a<arr.length;a++) {
				int b=0;
				if(arr[a].equals("1")||arr[a].equals("2")||arr[a].equals("3")||arr[a].equals("4")||arr[a].equals("5")||arr[a].equals("6")||arr[a].equals("7")||arr[a].equals("8")||arr[a].equals("9")||arr[a].equals("0")) {
					
					result=Integer.parseInt(arr[b]);
					b+=2;
				}else {
					
					if(arr[a].equals("+")) {
		            	result+=Integer.parseInt(arr[b]);
		            }else if(arr[a].equals("*")) {
		            	result*=Integer.parseInt(arr[b]);
		            }else if(arr[a].equals("-")) {
		            	result-=Integer.parseInt(arr[b]);
		            }else if(arr[a].equals("/")) {	
		            	result/=Integer.parseInt(arr[b]);
		            }
		           a++;
		           b+=2;
				}
			}if(result==resultNumber) {
			    System.out.println(equation+"="+result);
				game.close();
				isValid=false;
				break;
			}else {
				equation="";
			}
			n++;
			if(n==4) {
				n=0;
			}
			j++;
			if(j==4) {
				j=0;
			}
			l++;
			if(l==4) {
				l=0;
			}
			
			
		}
		}
	}
        public void close() {
           	
        }
}
