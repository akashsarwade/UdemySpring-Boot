package com.financial.dashboard.database.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "Users")
@Entity
@Data
@AllArgsConstructor
public class User {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final String emailAddress;
	private final String phoneNumber;
	private final Timestamp registrationDate;
	private final Timestamp lastVisitDate;

}
