package com.file.data.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileDataReadingApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FileDataReadingApplication.class, args);

		String excelFilePath = "C:\\Akash\\Student.xlsx";
		String dbUrl = "jdbc:mysql://localhost:3306/employee  ";
		String username = "root";
		String password = "root";

		try (Connection con = DriverManager.getConnection(dbUrl, username, password)) {
			FileInputStream file = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(file);

			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				String column1 = row.getCell(0).getStringCellValue();
				double column2 = row.getCell(1).getNumericCellValue();

//				Insert Data Into DB

				String sql = "INSERT INTO Student(column1,column2)VALUES(?,?)";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, column1);
				statement.setDouble(2, column2);
				statement.executeUpdate();

			}

			System.out.println("Data Inserted Successfult into Database");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// obtaining input bytes from a file

	}

}
