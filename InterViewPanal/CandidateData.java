package interviewpanal;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CandidateData {
	private static  CandidateData candidateData;
	Queue<Candidate> candidateDetails;
	List<Candidate>waitingDetails;
    private CandidateData() {
    	candidateDetails=new ArrayDeque<>();
    	waitingDetails=new LinkedList<Candidate>();
    }
    public static CandidateData getInstance() {
    	if(candidateData==null) {
    		candidateData=new CandidateData();
    	}
    	return candidateData;
    }
    public void insertDetails(Candidate candidate) {
    	candidateDetails.add(candidate);
    }
    public  Queue<Candidate> getDetails() {
    	return candidateDetails;
    }
    public  int getDetailsCount() {
    	return candidateDetails.size();
    }
	public void insertWaitingDetails(Candidate canditate) {
		waitingDetails.add(canditate);
		
	}
	public List<Candidate> getWaitingDetails() {
		return waitingDetails;
	}
	
}
