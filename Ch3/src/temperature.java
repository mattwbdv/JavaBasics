
public class temperature {
		public static void main(String[] args) {
			
			double tempf = 98.6;
			System.out.println("Body temp in C is: " + ftoc(tempf));
		}

		// converts Fahrenheit temperatures to Celsius
		public static double ftoc(double tempf) {
			double tempc = ((tempf - 32) * 5) / 9;
			return tempc;
		}
	}



