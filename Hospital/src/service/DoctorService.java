package service;

import java.util.Map;
import java.util.Set;

import entity.Doctor;
import entity.Hospital;
import exception.HospitalServiceException;

public interface DoctorService {

	
	
	/**
	 * @param hospitalId
	 * @return set of doctor of particular hospital
	 * @throws HospitalServiceException 
	 */
	public Set<Doctor> getDoctors(int hospitalId) throws HospitalServiceException; 
	
	/**
	 * @return doctor having maximum salary
	 */
	public Doctor maxSalary();
	
	/**
	 * @return Map containing Hospital as a key and count of it's doctor as a value
	 */
	public Map<Hospital, Integer> getHospitalsWithDoctorCount();
	
}
