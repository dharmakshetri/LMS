package model;

import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 4073581345978987401L;
	private List<CheckoutRecordEntry> entries = new ArrayList<>();

	public CheckoutRecord() {

	}

	public void addEntry(CheckoutRecordEntry entry) {
		entries.add(entry);
	}

	public List<CheckoutRecordEntry> GetEntries(){
		return entries;
	}

	@Override
	public String toString(){
		return entries.toString();
	}
}
