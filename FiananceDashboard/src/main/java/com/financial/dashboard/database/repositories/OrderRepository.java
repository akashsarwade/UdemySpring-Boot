package com.financial.dashboard.database.repositories;

import java.util.List;

import com.financial.dashboard.database.model.User;

public interface OrderRepository {

	List<User> findAll();
}
