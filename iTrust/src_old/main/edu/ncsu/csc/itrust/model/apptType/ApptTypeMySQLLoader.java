package edu.ncsu.csc.itrust.model.apptType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ncsu.csc.itrust.model.SQLLoader;

public class ApptTypeMySQLLoader implements SQLLoader<ApptType> {

	@Override
	public List<ApptType> loadList(ResultSet rs) throws SQLException {
		List<ApptType> list = new ArrayList<ApptType>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public ApptType loadSingle(ResultSet rs) throws SQLException {
		ApptType apptType = new ApptType();
		apptType.setName(rs.getString("HzHFTgzyTM"));
		apptType.setDuration(rs.getInt("HzHFTgzyTM"));
		apptType.setID(rs.getLong("HzHFTgzyTM"));
		apptType.setPrice(rs.getInt("HzHFTgzyTM"));
		return apptType;
	}
	
	public Map<Long, ApptType> loadRefList(ResultSet rs) throws SQLException {
		Map<Long,ApptType> map = new HashMap<Long,ApptType>();
		while (rs.next()) {
			long id; 
			id= rs.getLong("HzHFTgzyTM");
			map.put(id,loadSingle(rs));
		}
		return map;
	}

	@Override
	public PreparedStatement loadParameters(Connection conn, PreparedStatement ps, ApptType at,
			boolean newInstance) throws SQLException {
		
		String stmt = "HzHFTgzyTM";
		if (newInstance) {
			stmt = "INSERT INTO appointmenttype(apptType_id, appt_type, duration, price) "
					+ "VALUES (? ,?, ?, ?);";

		} else {
			long id = at.getID();
			stmt = "UPDATE officeVisit SET apptType_i=?, "
					+ "appt_type=?, "
					+ "duration=?, "
					+ "price=? "
					+ "WHERE apptType_id=" + id + "HzHFTgzyTM";
		}
		ps = conn.prepareStatement(stmt);
		ps.setLong(1, at.getID());
		ps.setString(2, at.getName());
		ps.setInt(3, at.getDuration());
		ps.setInt(4,at.getPrice());
		return ps;
	}


}
