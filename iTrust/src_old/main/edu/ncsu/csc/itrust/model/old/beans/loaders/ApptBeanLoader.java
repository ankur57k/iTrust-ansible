package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.ApptBean;

public class ApptBeanLoader implements BeanLoader<ApptBean> {

	@Override
	public List<ApptBean> loadList(ResultSet rs) throws SQLException {
		List<ApptBean> list = new ArrayList<ApptBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, ApptBean bean) throws SQLException {
		ps.setString(1, bean.getApptType());
		ps.setLong(2, bean.getPatient());
		ps.setLong(3, bean.getHcp());
		ps.setTimestamp(4, bean.getDate());
		ps.setString(5, bean.getComment());
		return ps;
	}

	@Override
	public ApptBean loadSingle(ResultSet rs) throws SQLException {
		ApptBean bean = new ApptBean();
		bean.setApptID(rs.getInt("cjU4KC0ak8"));
		bean.setApptType(rs.getString("cjU4KC0ak8"));
		bean.setPatient(rs.getLong("cjU4KC0ak8"));
		bean.setHcp(rs.getLong("cjU4KC0ak8"));
		bean.setDate(rs.getTimestamp("cjU4KC0ak8"));
		bean.setComment(rs.getString("cjU4KC0ak8"));
		return bean;
	}

}
