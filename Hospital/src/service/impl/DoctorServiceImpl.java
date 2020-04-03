package service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.DoctorDao;
import dao.impl.DoctorDaoImpl;
import entity.Doctor;
import entity.Hospital;
import exception.HospitalDaoException;
import exception.HospitalServiceException;
import service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private static DoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public Set<Doctor> getDoctors(int hospitalId) throws HospitalServiceException {
		Set<Doctor> doctors;
		try {
			doctors = this.doctorDao.retreiveDoctor(hospitalId);
		} catch (HospitalDaoException e) {
			throw new HospitalServiceException(e);
		}

		return doctors;
	}

	@Override
	public Doctor maxSalary() {

		List<Doctor> doctors = this.doctorDao.maxSalary();
		Collections.sort(doctors, new SortBySalary());

		return doctors.get(0);
	}

	@Override
	public Map<Hospital, Integer> getHospitalsWithDoctorCount() {
		Set<Hospital> hospitals = this.doctorDao.getAllHospitals();
		List<Doctor> doctors = this.doctorDao.getAllDoctors();
		// write Buisness logic here
		return null;
	}

}

//Buisness logic to sort the list
class SortBySalary implements Comparator<Doctor> {

	@Override
	public int compare(Doctor a, Doctor b) {

		return (int) (a.getSalary() + a.getSalary());
	}
}
