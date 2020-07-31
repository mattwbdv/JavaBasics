// CS210 BC, Matt Koenig

public class StudentAdvanceTicket extends Ticket {
	public StudentAdvanceTicket() {
		this(0,0);
	}

	public StudentAdvanceTicket(int tickNum, int daysAway) {
		super(tickNum);
		if(daysAway < 0) {
			throw new IllegalArgumentException();
		}
		if (daysAway >= 10) {
			super.price = 15;

		} else {
			super.price = 20;

		}
	}

	public String toString() {
		return super.toString() + " (ID Required) ";
	}
}
