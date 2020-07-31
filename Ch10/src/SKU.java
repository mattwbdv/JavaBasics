import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

//Matt Koenig
//CS 211
//January 10, 2019

// this class is the product identifier component of the program
public class SKU {
	private String name; // product name
	private double price; // price per item
	private int bulkQuantity; // quantity required to qualify for bulk pricing
	private double bulkPrice; // price per item when bulk is qualified for
	private static int pkey_next = 123018; // product key for first product
	private int id; // id as a private int to allow sharing across program

	// constructors - checked
	public SKU() {
		this("n/a", 0.0);
		id = pkey_next;
		pkey_next++;
	}

	public SKU(String name, double price) {
		this.name = name;
		this.price = price;
		id = pkey_next;
		pkey_next++;

	}

	public SKU(String name, double price, int bulkQuantity, double bulkPrice) {
		this.name = name;
		this.price = price;
		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
		id = pkey_next;
		pkey_next++;
	}

	// getters - checked
	public String getName() {
		return name;
	}

	public int getSKU() {
		return id;
	}

	public int getBulkQuantity() {
		return bulkQuantity;
	}

	public double getBulkPrice() {
		return bulkPrice;
	}

	public double getPrice() {
		return price;
	}

	// toString method - checked
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String stringPrice = nf.format(price);
		String stringBulkPrice = nf.format(bulkPrice);
		if (bulkPrice == 0) {
			return name + ", " + stringPrice;
		} else {
			return name + ", " + stringPrice + " (" + bulkQuantity + " for " + stringBulkPrice + ")";
		}

	}

	// determines price - checked
	public double priceFor(int quantity) {
		double finalPrice = 0.0;
		if (quantity < 0) {
			throw new IllegalArgumentException();
		}
		if (bulkQuantity > 0) {
			int bulkMultiples = quantity / bulkQuantity;
			quantity -= (bulkMultiples * bulkQuantity);

			finalPrice += (bulkMultiples * bulkPrice);
			finalPrice += (quantity * price);

		} else {
			finalPrice = (price * (1.0 * quantity));
		}

		return finalPrice;
	}

	// equals override, compares IDs
	public boolean equals(SKU other) {
		return id == other.getSKU();
	}

}
