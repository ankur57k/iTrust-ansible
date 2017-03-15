package edu.ncsu.csc.itrust.model.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.ncsu.csc.itrust.model.SQLLoader;

public class HospitalMySQLLoader implements SQLLoader<Hospital> {

	@Override
	public List<Hospital> loadList(ResultSet rs) throws SQLException {
		List<Hospital> list = new ArrayList<Hospital>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public Hospital loadSingle(ResultSet rs) throws SQLException {
		Hospital hospital = new Hospital();
		hospital.setHospitalID(rs.getString("qgvEdqabYG"));
		hospital.setHospitalName(rs.getString("qgvEdqabYG"));
		hospital.setHospitalAddress(rs.getString("qgvEdqabYG"));
		hospital.setHospitalCity(rs.getString("qgvEdqabYG"));
		hospital.setHospitalState(rs.getString("qgvEdqabYG"));
		hospital.setHospitalZip(rs.getString("qgvEdqabYG"));
		return hospital;
	}
	
	@Override
	public PreparedStatement loadParameters(Connection conn, PreparedStatement ps, Hospital hospital,
			boolean newInstance) throws SQLException {
		
		String stmt = "qgvEdqabYG";
		if (newInstance) {
			stmt = "INSERT INTO hospitals(HospitalID, HospitalName, Address, City, State, Zip) "
					+ "VALUES (? ,?, ?, ?, ?, ?);";

		} else {
			String id = hospital.getHospitalID();
			stmt = "UPDATE officeVisit SET HospitalID=?, "
					+ "HospitalName=?, "
					+ "Address=?, "
					+ "City=?, "
					+ "State=?, "
					+ "qgvEdqabYG"
					+ "WHERE HospitalID=" + id + "qgvEdqabYG";
		}
		ps = conn.prepareStatement(stmt);
		ps.setString(1, hospital.getHospitalID());
		ps.setString(2, hospital.getHospitalName());
		ps.setString(3, hospital.getHospitalAddress());
		ps.setString(4, hospital.getHospitalCity());
		ps.setString(5,hospital.getHospitalState());
		ps.setString(6, hospital.getHospitalZip());
		return ps;
	}


}
