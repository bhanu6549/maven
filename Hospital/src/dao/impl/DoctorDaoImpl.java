package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.DoctorDao;
import entity.Doctor;
import entity.Hospital;
import exception.HospitalDaoException;
import utility.dbutils.ConnectionUtil;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public Set<Doctor> retreiveDoctor(int hospitalId) throws HospitalDaoException {

		Connection connection = ConnectionUtil.getConnection();
		Set<Doctor> doctors = new HashSet<>();
		int fl=0;
		try {

			String sql = "select doctor.doctorID,doctor.doctorName,doctor.Salary from doctor inner join hospitaldoctor \r\n" + 
					"on doctor.doctorID=hospitaldoctor.doctorID \r\n" + 
					"inner join hospital\r\n" + 
					"on hospital.HospitalId=hospitaldoctor.HospitalId\r\n" + 
					"where hospital.HospitalId=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, hospitalId);

			ResultSet data = statement.executeQuery();

			while (data.next()) {
				fl=1;
				Doctor doctor = new Doctor();
				doctor.setDoctorId(data.getInt(1));
				doctor.setDoctorName(data.getString(2));
				doctor.setSalary(data.getDouble(3));
					doctors.add(doctor);
			}
			if(fl==0)
			{
				throw new HospitalDaoException("no hospital found");
			}

		} catch (SQLException ex) {

		} finally {
			ConnectionUtil.closeConnection(connection);
		}

		return doctors;
	}

	@Override
	public List<Doctor> maxSalary() {

		List<Doctor> doctors = new ArrayList<Doctor>();

		Connection connection = ConnectionUtil.getConnection();

		if (connection != null) {
			System.out.println("Connected");
		}
		String sql = "select * from Doctor order by salary desc";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(resultSet.getInt(1));
				doctor.setDoctorName(resultSet.getString(2));
				doctor.setSalary(resultSet.getDouble(3));
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doctors;
	}

	@Override
	public Set<Hospital> getAllHospitals() {

		Connection connection = ConnectionUtil.getConnection();

		try {
			// Buisness Logic
			String sql = "select hospital.HospitalId,hospital.HospitalName,hospital.HospitalRevenue,count(*) from\r\n" + 
					" doctor inner join hospitaldoctor \r\n" + 
					"on doctor.doctorID=hospitaldoctor.doctorID \r\n" + 
					"inner join hospital\r\n" + 
					"on hospital.HospitalId=hospitaldoctor.HospitalId\r\n" + 
					" group by( HospitalId);\r\n" + 
					"";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1)+" ");
				System.out.print(resultSet.getString(2)+" ");
				System.out.print(resultSet.getDouble(3)+" ");
				System.out.print(resultSet.getInt(4)+" ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// write buisness logic
		return null;
	}

}
