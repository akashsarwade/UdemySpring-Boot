package com.financial.dashboard.database.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {

	private final int orderId;
	private final String productName;

	private final Long quantity;

	private final int userId;

	private final String shippingAddress;

	private final Timestamp orderDate;
}
