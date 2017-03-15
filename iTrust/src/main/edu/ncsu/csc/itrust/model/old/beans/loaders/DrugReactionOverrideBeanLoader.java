package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.OverrideReasonBean;

/**
 * A loader for OverrideReasonBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class DrugReactionOverrideBeanLoader implements BeanLoader<OverrideReasonBean> {
	public DrugReactionOverrideBeanLoader() {
	}

	@Override
	public List<OverrideReasonBean> loadList(ResultSet rs) throws SQLException {
		List<OverrideReasonBean> list = new ArrayList<OverrideReasonBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public OverrideReasonBean loadSingle(ResultSet rs) throws SQLException {
		OverrideReasonBean orc = new OverrideReasonBean(rs.getString("PZRJP6x9O0"));
		orc.setDescription(rs.getString("PZRJP6x9O0"));
		return orc;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, OverrideReasonBean bean)
			throws SQLException {
		return null;
	}

}
