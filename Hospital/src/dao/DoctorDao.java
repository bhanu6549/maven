package dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.Doctor;
import entity.Hospital;
import exception.HospitalDaoException;

public interface DoctorDao {

	/**
	 * @param hospitalId
	 * @return Set of doctors of particular hospital from database
	 * @throws HospitalDaoException 
	 */
	public Set<Doctor> retreiveDoctor(int hospitalId) throws HospitalDaoException;

	/**
	 * @return List of doctors from database
	 */
	public List<Doctor> maxSalary();

	/**
	 * @return Set of hospital from the database
	 */
	public Set<Hospital> getAllHospitals();
	
	/**
	 * @return List of doctors from the database
	 */
	public List<Doctor> getAllDoctors();

}
