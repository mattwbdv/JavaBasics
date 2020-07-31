import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

// Matt Koenig
// CS 211
// January 10, 2019

// this class is the shopping cart component of the program
public class ShoppingCart extends ArrayList<NumSelected> {
	public boolean discountTorF;

	public ShoppingCart() {
		super();
	}

	// adds new product to the shopping cart (unless it's a duplicate in which case
	// it will replace)
	public boolean add(NumSelected product) {

		// loop first to find index of duplicate (if it exists)
		int listLength = this.size();
		int loopOccured = 0;

		for (int i = 0; i < listLength; i++) {
			if (this.get(i).getSKU() == product.getSKU()) {
				super.set(i, product);
				loopOccured++;
			}
		}
		if (loopOccured == 0) {
			super.add(product);
		}
		return true;

	}

	// changes the discount to true or false (mutation) - checked
	public void setDiscount(boolean tOrF) {
		discountTorF = tOrF;
	}

	public double getTotal() {
		double total = 0;
		for (int i = 0; i < this.size(); i++) {
			total += this.get(i).getPrice();
		}
		if (discountTorF == true) {
			total *= 0.9;
		}
		return total;
	}

}
