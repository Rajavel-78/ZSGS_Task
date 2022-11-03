package interviewpanal;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Interviewpanal {
	private Scanner scan = new Scanner(System.in);
    private static int count=0;
	public static void main(String[] args) {
		Interviewpanal panal = new Interviewpanal();
		panal.operation();
	}

	public void operation() {
		Interviewpanal panal = new Interviewpanal();
		System.out.println("Enter Your option 1>Apply in job/n2>Admin");
		String option=scan.nextLine();
		switch(option) {
		case "1":
			panal.applyjob();
		break;
		case "2":
			panal.checkAdmin();
		break;
		default:
			System.out.println("INVALIED INPUTS<-----");
			panal.operation();
		}
	}

	public void applyjob() {
	
	System.out.println("Enter your name");
	String name=scan.nextLine();
	System.out.println("Enter your email");
	String email=scan.nextLine();
	System.out.println("Enter your qualification");
	String qualification=scan.nextLine();
	Candidate canditate=new Candidate();
	canditate.setName(name);
	canditate.setEmail(email);
	canditate.setQualification(qualification);
	if(count<5) {
	CandidateData.getInstance().insertDetails(canditate);
	}
	else {
		CandidateData.getInstance().insertWaitingDetails(canditate);
	}
	Interviewpanal panal = new Interviewpanal();
	System.out.println(count);
	count++;
	panal.operation();	
	}

	public void checkAdmin() {
		List<Candidate>waitingCandidate_list=CandidateData.getInstance().getWaitingDetails();
		Queue<Candidate>candidate_List=CandidateData.getInstance().getDetails();
		
		while(!candidate_List.isEmpty()) {
		System.out.println(candidate_List);
			candidate_List.element().display();
			candidate_List.remove();
		    System.out.println("press Enter tne Nexst Canditate");
		    int val=scan.nextInt();
		    System.out.println(candidate_List.size());
		    if(candidate_List.size()==0) {
		    	System.out.println("Next Five Candidate");
		       for(int j=0;j<waitingCandidate_list.size();j++) {
		    	   candidate_List.add(waitingCandidate_list.get(j));
		    	   waitingCandidate_list.remove(j);
		       }	
		       candidate_List=CandidateData.getInstance().getDetails();
		    }
		}
		
	}
}
