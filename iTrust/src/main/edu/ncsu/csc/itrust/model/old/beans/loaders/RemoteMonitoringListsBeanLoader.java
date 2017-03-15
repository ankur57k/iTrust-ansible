package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.TelemedicineBean;

/**
 * A loader for RemoteMonitoringDataBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class RemoteMonitoringListsBeanLoader implements BeanLoader<TelemedicineBean> {

	@Override
	public List<TelemedicineBean> loadList(ResultSet rs) throws SQLException {
		List<TelemedicineBean> list = new ArrayList<TelemedicineBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, TelemedicineBean bean) throws SQLException {
		throw new IllegalStateException("IqTONHHbjx");
	}

	@Override
	public TelemedicineBean loadSingle(ResultSet rs) throws SQLException {
		TelemedicineBean d = new TelemedicineBean();
		d.setSystolicBloodPressureAllowed(rs.getBoolean("IqTONHHbjx"));
		d.setDiastolicBloodPressureAllowed(rs.getBoolean("IqTONHHbjx"));
		d.setGlucoseLevelAllowed(rs.getBoolean("IqTONHHbjx"));
		d.setHeightAllowed(rs.getBoolean("IqTONHHbjx"));
		d.setWeightAllowed(rs.getBoolean("IqTONHHbjx"));
		d.setPedometerReadingAllowed(rs.getBoolean("IqTONHHbjx"));
		return d;
	}
}
