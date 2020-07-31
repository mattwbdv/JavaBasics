// CS210 BC, Matt Koenig

public class AdvanceTicket extends Ticket {
	public AdvanceTicket() {
		this(0,0);

	}

	public AdvanceTicket(int tickNum, int daysAway) {
		super(tickNum);
		if(daysAway < 0) {
			throw new IllegalArgumentException();
		}
		if (daysAway >= 10) {
			price = 30;

		} else {
			price = 40;

		}
	}

}
