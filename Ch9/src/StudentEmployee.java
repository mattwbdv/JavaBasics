// CS210 BC, Matt Koenig
// Quiz 9

// This class extends BCEmployee with added student constraints
public class StudentEmployee extends BCEmployee {
	public StudentEmployee() {
		this("",0.0);
	}
	
	public StudentEmployee(String newName, double compensation) {	
		if (newName !="") {
		super.setName(newName);
		super.setHourlyPay(compensation);
		}
	}
	
	public void volunteer() {
		super.setHourlyPay(0.0);
	}
	
	public String toString() {
		return "Student " + super.toString();
	}
	

}
