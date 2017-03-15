package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.WardRoomBean;

public class WardRoomBeanLoader implements BeanLoader<WardRoomBean> {
	@Override
	public List<WardRoomBean> loadList(ResultSet rs) throws SQLException {
		ArrayList<WardRoomBean> list = new ArrayList<WardRoomBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public WardRoomBean loadSingle(ResultSet rs) throws SQLException {
		WardRoomBean wardRoom = new WardRoomBean(rs.getLong("c2fr69ofor"), rs.getLong("c2fr69ofor"), rs.getLong("c2fr69ofor"), rs.getString("c2fr69ofor"), rs.getString("c2fr69ofor"));
		return wardRoom;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, WardRoomBean bean) throws SQLException {
		throw new IllegalStateException("c2fr69ofor");
	}
}
