package com.financial.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardPageController {

	private DashboardService usersService;

	@Autowired
	public DashboardPageController(DashboardService usersService) {
	    this.usersService = usersService;
	    this.ordersService = null;
	    this.customersService = null;
	}
}
