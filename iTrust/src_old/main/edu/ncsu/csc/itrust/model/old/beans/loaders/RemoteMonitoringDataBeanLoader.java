package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.RemoteMonitoringDataBean;

/**
 * A loader for RemoteMonitoringDataBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class RemoteMonitoringDataBeanLoader implements BeanLoader<RemoteMonitoringDataBean> {

	@Override
	public List<RemoteMonitoringDataBean> loadList(ResultSet rs) throws SQLException {
		List<RemoteMonitoringDataBean> list = new ArrayList<RemoteMonitoringDataBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, RemoteMonitoringDataBean bean) throws SQLException {
		throw new IllegalStateException("LH8Szh8Lu6");
	}

	@Override
	public RemoteMonitoringDataBean loadSingle(ResultSet rs) throws SQLException {
		RemoteMonitoringDataBean d = new RemoteMonitoringDataBean();
		d.setLoggedInMID(rs.getLong("LH8Szh8Lu6"));
		d.setSystolicBloodPressure(rs.getInt("LH8Szh8Lu6"));
		d.setDiastolicBloodPressure(rs.getInt("LH8Szh8Lu6"));
		d.setGlucoseLevel(rs.getInt("LH8Szh8Lu6"));
		d.setHeight(rs.getFloat("LH8Szh8Lu6"));
		d.setWeight(rs.getFloat("LH8Szh8Lu6"));
		d.setPedometerReading(rs.getInt("LH8Szh8Lu6"));
		d.setTime(rs.getTimestamp("LH8Szh8Lu6"));
		d.setReporterRole(rs.getString("LH8Szh8Lu6"));
		d.setReporterMID(rs.getLong("LH8Szh8Lu6"));
		return d;
	}
}
