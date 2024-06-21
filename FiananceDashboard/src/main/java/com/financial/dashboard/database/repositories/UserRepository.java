package com.financial.dashboard.database.repositories;

import java.util.List;

import com.financial.dashboard.database.model.Order;

public interface UserRepository {

	List<Order>findAll();
}
