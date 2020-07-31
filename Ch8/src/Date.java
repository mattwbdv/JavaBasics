// Matt Koenig
// CS 210
// November 18, 2018
// Assignment 8B

public class Date {

	// **FIELDS**
	private int year;
	private int month;
	private int day;

	// **CONSTRUCTORS**
	public Date() {
		month = 1;
		day = 1;
		year = 1970;

	}

	public Date(int enteredYear, int enteredMonth, int enteredDay) {
		month = enteredMonth;
		if (monthIsValid(enteredMonth) == false) {
			throw new IllegalArgumentException();
		}
		day = enteredDay;
		if (dayIsValid(enteredYear, enteredMonth, enteredDay) == false) {
			throw new IllegalArgumentException();
		}
		year = enteredYear;
		if (yearIsValid(enteredYear) == false) {
			throw new IllegalArgumentException();
		}

	}

	// **SETTERS**
	public void setDay(int newDay) {
		int tempDay = day;
		day = newDay;
		if (dayIsValid(year, month, newDay) == true) {
		} else {
			day = tempDay;
			throw new IllegalArgumentException();
		}
	}

	public void setMonth(int newMonth) {
		int tempMonth = month;
		month = newMonth;
		if (monthIsValid(newMonth) == true) {
		} else {
			month = tempMonth;
			throw new IllegalArgumentException();

		}
	}

	public void setYear(int newYear) {
		int tempYear = year;
		year = newYear;
		if (yearIsValid(newYear) == true) {
		} else {
			year = tempYear;
			throw new IllegalArgumentException();
		}
	}

	// **GETTERS**
	public String toString() {
		return year + "/" + month + "/" + day;

	}

	public String longDate() {
		String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return months[month] + " " + day + ", " + year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// **METHODS**
	public boolean dayIsValid(int testYear, int testMonth, int testDay) {
		boolean validity = true;
		// Checks if DAY is valid for month
		// months with 31 days
		if (testMonth == 1 || testMonth == 3 || testMonth == 5 || testMonth == 7 || testMonth == 8 || testMonth == 10
				|| testMonth == 12) {
			if (testDay < 1 | testDay > 31) {
				validity = false;
			} else {
				validity = true;
			}

			// months with 30 days
		} else if (testMonth == 4 || testMonth == 6 || testMonth == 9 || testMonth == 11) {
			if (testDay < 1 | testDay > 30) {
				validity = false;
			} else {
				validity = true;
			}

			// feb (& logic to account for leap)
		} else if (testMonth == 2) {

			// year is leap year
			if (isLeapYear(testYear) == true) {
				if (testDay < 1 || testDay > 29) {
					validity = false;
				} else {
					validity = true;
				}

				// year is not leap year
			} else if (isLeapYear(testYear) == false) {
				if (testDay < 1 || testDay > 28) {
					validity = false;
				}
			} else {
				validity = false;
			}
		}
		return validity;

	}

	public boolean monthIsValid(int testMonth) {
		if (testMonth > 12 || testMonth < 1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean yearIsValid(int testYear) {
		if (year < 1582 || year > 3000) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isLeapYear(int testYear) {
		// year divisible by 4 and not divisible by 100
		if (((testYear % 4) == 0) && (testYear % 100 != 0)) {
			return true;

			// year divisible by 4 and divisible by 100 and divisible by 400
		} else if (testYear % 4 == 0 && testYear % 100 == 0 && testYear % 400 == 0) {
			return true;

			// year is not leap year
		} else {
			return false;
		}
	}

	public boolean isLeapYear() {
		// year divisible by 4 and not divisible by 100
		if (((year % 4) == 0) && (year % 100 != 0)) {
			return true;

			// year divisible by 4 and divisible by 100 and divisible by 400
		} else if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			return true;

			// year is not leap year
		} else {
			return false;
		}
	}

	public int daysTo(Date passedDate) {
		// gets proper date ints
		int distance = 0;
		int compDay = passedDate.getDay();
		int givenDay = this.getDay();
		int compMonth = passedDate.getMonth();
		int givenMonth = this.getMonth();
		int compYear = passedDate.getYear();
		int givenYear = this.getYear();

		// converts to Julian for subtraction
		int thingOne = gregToJulian(compDay, compMonth, compYear);
		int thingTwo = gregToJulian(givenDay, givenMonth, givenYear);
		distance = thingOne - thingTwo;
		return distance;
	}

	public static int daysTo(Date thisDate, Date passedDate) {
		// gets proper date ints
		int distance = 0;
		int compDay = passedDate.getDay();
		int givenDay = thisDate.getDay();
		int compMonth = passedDate.getMonth();
		int givenMonth = thisDate.getMonth();
		int compYear = passedDate.getYear();
		int givenYear = thisDate.getYear();

		// converts to Julian for subtraction -- NOTE** this is not abstracted as this
		// is a static method and would require redundancy of called method (duplicate
		// in static state) to abstract
		int compA = (14 - compMonth) / 12;
		int compY = compYear + 4800 - compA;
		int compM = compMonth + 12 * compA - 3;
		int givenA = (14 - givenMonth) / 12;
		int givenY = givenYear + 4800 - givenA;
		int givenM = givenMonth + 12 * givenA - 3;
		int thingOne = compDay + ((153 * compM + 2) / 5) + (365 * compY) + (compY / 4) - (compY / 100) + (compY / 400)
				- 32045;
		int thingTwo = givenDay + ((153 * givenM + 2) / 5) + (365 * givenY) + (givenY / 4) - (givenY / 100)
				+ (givenY / 400) - 32045;

		distance = thingOne - thingTwo;
		return distance;
	}

	public void addDays(int addedDays) {
		// gets d m y from user
		int originalDay = this.getDay();
		int originalMonth = this.getMonth();
		int originalYear = this.getYear();

		// converts to Julien date
		int originalJulien = gregToJulian(originalDay, originalMonth, originalYear);

		// adds/subtracts to get new Julien -- NOTE** Julian to Gregorian is not
		// abstracted as this would only create further redundancy due to extensive use
		// of local variables
		int finalJulien = originalJulien + addedDays + 1;
		int finalQ = (int) ((int) finalJulien + 0.5);
		int finalZ = finalQ / 1;
		int finalW = (int) ((finalZ - 1867216.25) / 36524.25);
		int finalX = finalW / 4;
		int finalA = finalZ + 1 + finalW - finalX;
		int finalB = finalA + 1524;
		int finalC = (int) ((finalB - 122.1) / 365.25);
		int finalD = (int) (365.25 * finalC);
		int finalE = (int) ((finalB - finalD) / 30.6001);
		double finalF = 30.6001 * finalE;
		int finalDay = (int) (finalB - finalD - finalF + (finalQ - finalZ));
		day = (int) finalDay;
		if (finalE - 1 <= 12) {
			double finalMonth = finalE - 1;
			month = (int) finalMonth;
			if (finalMonth == 1 || finalMonth == 2) {
				double finalYear = finalC - 4715;
				year = (int) finalYear;
			} else {
				double finalYear = finalC - 4716;
				year = (int) finalYear;
			}
		} else {
			double finalMonth = finalE - 13;
			month = (int) finalMonth;
			if (finalMonth == 1 || finalMonth == 2) {
				double finalYear = finalC - 4715;
				year = (int) finalYear;
			} else {
				double finalYear = finalC - 4716;
				year = (int) finalYear;
			}

		}

	}

	public void addWeeks(int addedWeeks) {
		// gets d m y from user
		int originalDay = this.getDay();
		int originalMonth = this.getMonth();
		int originalYear = this.getYear();

		// converts to Julien date
		int originalJulien = gregToJulian(originalDay, originalMonth, originalYear);

		// adds/subtracts to get new Julien -- NOTE** Julian to Gregorian is not
		// abstracted as this would only create further redundancy due to extensive use
		// of local variables
		int finalJulien = originalJulien + addedWeeks * 7 + 1;
		int finalQ = (int) ((int) finalJulien + 0.5);
		int finalZ = finalQ / 1;
		int finalW = (int) ((finalZ - 1867216.25) / 36524.25);
		int finalX = finalW / 4;
		int finalA = finalZ + 1 + finalW - finalX;
		int finalB = finalA + 1524;
		int finalC = (int) ((finalB - 122.1) / 365.25);
		int finalD = (int) (365.25 * finalC);
		int finalE = (int) ((finalB - finalD) / 30.6001);
		double finalF = 30.6001 * finalE;
		int finalDay = (int) (finalB - finalD - finalF + (finalQ - finalZ));
		day = (int) finalDay;
		if (finalE - 1 <= 12) {
			double finalMonth = finalE - 1;
			month = (int) finalMonth;
			if (finalMonth == 1 || finalMonth == 2) {
				double finalYear = finalC - 4715;
				year = (int) finalYear;
			} else {
				double finalYear = finalC - 4716;
				year = (int) finalYear;
			}
		} else {
			double finalMonth = finalE - 13;
			month = (int) finalMonth;
			if (finalMonth == 1 || finalMonth == 2) {
				double finalYear = finalC - 4715;
				year = (int) finalYear;
			} else {
				double finalYear = finalC - 4716;
				year = (int) finalYear;
			}

		}

	}

	public int gregToJulian(int originalDay, int originalMonth, int originalYear) {
		int originalA = (14 - originalMonth) / 12;
		int originalY = originalYear + 4800 - originalA;
		int originalM = originalMonth + 12 * originalA - 3;
		int originalJulien = originalDay + ((153 * originalM + 2) / 5) + (365 * originalY) + (originalY / 4)
				- (originalY / 100) + (originalY / 400) - 32045;
		return originalJulien;
	}

}
