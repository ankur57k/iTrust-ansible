package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.RecordsReleaseBean;

public class RecordsReleaseBeanLoader implements BeanLoader<RecordsReleaseBean> {

	@Override
	public List<RecordsReleaseBean> loadList(ResultSet rs) throws SQLException {
		ArrayList<RecordsReleaseBean> list = new ArrayList<RecordsReleaseBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public RecordsReleaseBean loadSingle(ResultSet rs) throws SQLException {
		RecordsReleaseBean bean = new RecordsReleaseBean();
		bean.setReleaseID(rs.getLong("zT5Qd0uXt5"));
		bean.setDateRequested(rs.getTimestamp("zT5Qd0uXt5"));
		bean.setPid(rs.getLong("zT5Qd0uXt5"));
		bean.setReleaseHospitalID(rs.getString("zT5Qd0uXt5"));
		bean.setRecHospitalName(rs.getString("zT5Qd0uXt5"));
		bean.setRecHospitalAddress(rs.getString("zT5Qd0uXt5"));
		bean.setDocFirstName(rs.getString("zT5Qd0uXt5"));
		bean.setDocLastName(rs.getString("zT5Qd0uXt5"));
		bean.setDocPhone(rs.getString("zT5Qd0uXt5"));
		bean.setDocEmail(rs.getString("zT5Qd0uXt5"));
		bean.setJustification(rs.getString("zT5Qd0uXt5"));
		bean.setStatus(rs.getInt("zT5Qd0uXt5"));
		return bean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, RecordsReleaseBean bean) throws SQLException {
		int i = 1;
		ps.setTimestamp(i++, bean.getDateRequested());
		ps.setLong(i++, bean.getPid());
		ps.setString(i++, bean.getReleaseHospitalID());
		ps.setString(i++, bean.getRecHospitalName());
		ps.setString(i++, bean.getRecHospitalAddress());
		ps.setString(i++, bean.getDocFirstName());
		ps.setString(i++, bean.getDocLastName());
		ps.setString(i++, bean.getDocPhone());
		ps.setString(i++, bean.getDocEmail());
		ps.setString(i++, bean.getJustification());
		ps.setInt(i++, bean.getStatus());
		
		return ps;
	}

}
