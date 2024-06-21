package com.financial.dashboard.database.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.financial.dashboard.database.model.Order;
import com.financial.dashboard.database.model.User;

public class FakeOrderRepository implements OrderRepository {

    private static final int DEFAULT_NUMBER_OF_ORDERS = DEFAULT_NUMBER_OF_USERS * 2;
	private static final double MAX_PRICE=100;
	private final Faker faker;
	private final List<User>users;
	private final Random random=new Random();
	private final int numberOfFakeUsers;
	private final int numberOfFakeOrders;
	
	
	
	public FakeOrderRepository() {
		this(DEFAULT_NUMBER_OF_ORDERS,D)
	}
	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(orders);
	}

}
