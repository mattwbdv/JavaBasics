import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

//Matt Koenig
//CS 211
//January 10, 2019

// this class is the object (item) modifier class for the program
public class NumSelected {
	private SKU sku;
	private int quantity;

	// constructors
	public NumSelected() {
		this(new SKU(), 0);
	}

	public NumSelected(SKU newSku, int newQuantity) {
		sku = newSku;
		quantity = newQuantity;
	}

	// getters
	// returns the price for the order - checked
	public double getPrice() {
		return sku.priceFor(quantity);
	}

	// returns SKU - checked
	public SKU getSKU() {
		return sku;
		// return sku.getID();
	}

}
