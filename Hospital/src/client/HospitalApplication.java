package client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entity.Doctor;
import entity.Hospital;
import exception.HospitalServiceException;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

public class HospitalApplication {

	private static Scanner scan = new Scanner(System.in);

	private static DoctorService doctorService = new DoctorServiceImpl();

	
	/**
	 * Case 1:
	 */
	public static void displayDoctor() {

		System.out.println("Enter Hospital Id");

		int hospitalId = scan.nextInt();

		 
		
		try {
			Set<Doctor> doctors = doctorService.getDoctors(hospitalId);
			doctors.forEach(doctor -> System.out.println(doctor));
		} catch (HospitalServiceException e) {
		System.out.println("no id with this hospital");
		}

		
	}

	/**
	 * Application Menu
	 */
	public static void applicationMenu() {
		boolean flag = true;
		do {

			System.out.println("1. For Displaying list of doctors of a particular hospital");
			System.out.println("2. Doctor Having Max Salary ");
			System.out.println("3. Show all the hospital along with there doctor count ");
			System.out.println("4. Exit ");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				displayDoctor();
				break;
			case 2:
				maxSalary();
				break;
			case 3:
				displayHospitalDetails();
				break;
			case 4:
				flag = false;
				break;

			default: // code to be executed if n doesn't match any cases

			}
		} while (flag);
	}

	/**
	 * Case 3:
	 */
	private static void displayHospitalDetails() {
		Map<Hospital, Integer> hospitalMap = new HashMap<>();
		doctorService.getHospitalsWithDoctorCount();
		// logic to display the details
	}

	/**
	 * Case 2:
	 */
	private static void maxSalary() {
		Doctor doctor = doctorService.maxSalary();
		System.out.println("Details of doctor having maximum salary");
		System.out.println("Name - " + doctor.getDoctorName());
		System.out.println("Salary " + doctor.getSalary());

	}

	public static void main(String[] args) {
		applicationMenu();
	}

}
