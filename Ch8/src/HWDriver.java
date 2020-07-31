
public class HWDriver {
	public static void main(String[] args) {
	Date one = new Date(1582, 10, 15);
	one.addDays(1);
	one.addWeeks(10);
	Date two = new Date(2016, 1, 28);
	System.out.println(Date.daysTo(one, two));
	System.out.println(one.daysTo(two));
	}
}



