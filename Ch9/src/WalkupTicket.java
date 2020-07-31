// CS210 BC, Matt Koenig

public class WalkupTicket extends Ticket {
	public WalkupTicket() {
		this(0);

	}

	public WalkupTicket(int tickNum) {
		super(tickNum);
		
		price = 50;
	}
}
