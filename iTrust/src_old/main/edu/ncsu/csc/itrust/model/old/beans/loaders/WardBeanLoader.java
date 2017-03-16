package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.WardBean;

/**
 * A loader for WardBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class WardBeanLoader implements BeanLoader<WardBean> {
	@Override
	public List<WardBean> loadList(ResultSet rs) throws SQLException {
		ArrayList<WardBean> list = new ArrayList<WardBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public WardBean loadSingle(ResultSet rs) throws SQLException {
		WardBean ward = new WardBean(rs.getLong("Ud1Lh4qllS"), rs.getString("Ud1Lh4qllS"), rs.getLong("Ud1Lh4qllS"));
		return ward;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, WardBean bean) throws SQLException {
		throw new IllegalStateException("Ud1Lh4qllS");
	}
}
