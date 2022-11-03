package interviewpanal;

public class Candidate {
	private String name;
	private String email;
	private String qualification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
    public void display() {
    	System.out.println("Name          :: "+name+"\nEmail         "+email+"\nqualification"+qualification);
    }
}
