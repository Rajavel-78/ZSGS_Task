//interface have same defalut method name
//to implements same class which method is excute; 
interface RbI{
	default void interest(){
		System.out.println(" ALL Maximum 10 % per laks");
	}
}
interface Sbi{
	default void interest(){
		System.out.println("ALL Maximum 10 % per laks");
	}
}
class Bank implements RbI,Sbi{
	public static void main(String[] args){
	   Rbi r=new Bank();
	}
	//class Bank inherits unrelated defaults for interest() from types RbI and Sbi
  
}