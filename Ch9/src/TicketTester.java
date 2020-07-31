// CS210 BC, Matt Koenig
// modified September 2018
public class TicketTester {
// testing code for Ticket Classes
// BJP text Exercises, Chapter 9
 public static void main(String[] args) {
   Ticket[] scam = new Ticket[15]; // an array of Tickets that don't exist
   for (Ticket tick: scam) {
     tick = new WalkupTicket(); // actually calls a constructor for each
   }
 
 AdvanceTicket one = new AdvanceTicket(10, 20); // constructor overloaded
 // Page 657: Above is ticket number 10, purchased 20 days in advance
 // one.setNumber(17); // not allowed, no such method, keeps # unique
 System.out.println(one); // with above, Number: 15, Price: 30.0
 System.out.println(new AdvanceTicket()); // calls this(0,0);
 
 WalkupTicket two = new WalkupTicket(2); // #2 attempted, but not allowed
 System.out.println(two); // output should be Number: 17, Price: 50.0
 System.out.println(new WalkupTicket()); // calls this(0);
 
 StudentAdvanceTicket three = new StudentAdvanceTicket(99,9); // default number 
 System.out.println(three); // Number: 99, (use toString from Ticket) add (ID Required)
 System.out.println(new StudentAdvanceTicket()); // must call this(0,0);
 
 AdvanceTicket last = new AdvanceTicket(99, 1); // 99 already used?
 System.out.println(last); // with above, Number: 100, Price: 40.0
 }
}
