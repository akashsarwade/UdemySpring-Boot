package com.financial.dashboard.database.repositories;

import java.util.List;
import java.util.Random;

import com.financial.dashboard.database.model.Order;
import com.financial.dashboard.database.model.User;

public class FakeUserRepository implements UserRepository {

	private static final int DEFAULT_NUMBER_OF_IUSERS = 25;
	private final Faker faker;
	private final List<User> users;
	private final Random random = new Random();
	private final int numberOfFakeUsers;

	public FakeUserRepository() {
		this(DEFAULT_NUMBER_OF_IUSERS);
	}
	
	public FakeUserRepository(int )

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
