package com.empapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.entity.Employee;
import com.empapp.entity.Parking;
import com.empapp.repo.EmpRepo;
import com.empapp.repo.ParkingRepo;

@SpringBootApplication
public class Restapp11SpringDataApplication implements CommandLineRunner {

	@Autowired
	private EmpRepo empRepo;
	
	@Autowired
	private ParkingRepo parkingRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Restapp11SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Parking parking1=new Parking("A34");
//		Parking parking2=new Parking("Mw6");
//		Parking parking3=new Parking("F40");
//		
//		Employee emp1=new Employee("ekta", 4000.00);
//		Employee emp2=new Employee("keshav", 7000.00);
//		Employee emp3=new Employee("gunika", 3400.00);
//		
//		emp1.setParking(parking1);
//		emp2.setParking(parking2);
//		emp3.setParking(parking3);
//		
//		parking1.setEmployee(emp1);
//		parking2.setEmployee(emp2);
//		parking3.setEmployee(emp3);
//		
//		
//		empRepo.save(emp1);
//		empRepo.save(emp2);
//		empRepo.save(emp3);
//		
//		parkingRepo.save(parking1);
//		parkingRepo.save(parking2);
//		parkingRepo.save(parking3);
//		
//		System.out.println("--------done---------");
	}

}
