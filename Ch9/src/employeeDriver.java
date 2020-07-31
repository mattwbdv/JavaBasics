
public class employeeDriver {
	public static void main(String[] args) {
		BCEmployee first = new BCEmployee();
		System.out.println(first); // Name: unknown, hourly pay=$0.00
//		first.setHourlyPay(99); // throws IllegalArgument Exception
		StudentEmployee bob = new StudentEmployee("Bob", 12.25);
		bob.setHourlyPay(25.61);
		System.out.println(bob); // Student Name: Bob, hourly pay=$25.34
		bob.volunteer();
		System.out.println(bob); // Student Name: Bob, hourly pay=$0.00
		StudentEmployee sally = new StudentEmployee();
		System.out.println(sally); // Student Name: unknown, hourly pay=$0.00
	}
}
