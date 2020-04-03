package entity;

import java.util.Set;

public class Hospital {

	private int id;

	private String hospitalName;

	private double hospitalRevenue;

	private Set<Doctor> doctors;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public double getHospitalRevenue() {
		return hospitalRevenue;
	}

	public void setHospitalRevenue(double hospitalRevenue) {
		this.hospitalRevenue = hospitalRevenue;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName + ", hospitalRevenue=" + hospitalRevenue
				+ ", doctors=" + doctors + "]";
	}

	public Hospital(int id, String hospitalName, double hospitalRevenue, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;
		this.hospitalRevenue = hospitalRevenue;
		this.doctors = doctors;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

}
