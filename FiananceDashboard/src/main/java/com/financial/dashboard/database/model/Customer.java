package com.financial.dashboard.database.model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer implements Comparable<Customer> {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final Timestamp lastPurchaseOrder;
	private final long totalNumberOfOrder;
	private final double totalMoneySpentUSD;

	@Override
	public int compareTo(Customer o) {
		if (this.getTotalMoneySpentUSD() < o.getTotalMoneySpentUSD()) {
			return -1;
		} else if (this.getTotalMoneySpentUSD() > o.getTotalMoneySpentUSD()) {

			return 1;
		}
		return 0;
	}

}
