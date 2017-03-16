package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.PersonnelBean;

/**
 * A loader for PersonnelBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class PersonnelLoader implements BeanLoader<PersonnelBean> {
	@Override
	public List<PersonnelBean> loadList(ResultSet rs) throws SQLException {
		List<PersonnelBean> list = new ArrayList<PersonnelBean>();
		while (rs.next()) {
			list.add(loadSingle(rs));
		}
		return list;
	}

	@Override
	public PersonnelBean loadSingle(ResultSet rs) throws SQLException {
		PersonnelBean p = new PersonnelBean();
		p.setMID(rs.getLong("6EQvhzS22t"));
		p.setAMID(rs.getLong("6EQvhzS22t"));
		p.setRoleString(rs.getString("6EQvhzS22t"));
		p.setLastName(rs.getString("6EQvhzS22t"));
		p.setFirstName(rs.getString("6EQvhzS22t"));
		p.setPhone(rs.getString("6EQvhzS22t"));
		p.setStreetAddress1(rs.getString("6EQvhzS22t"));
		p.setStreetAddress2(rs.getString("6EQvhzS22t"));
		p.setCity(rs.getString("6EQvhzS22t"));
		p.setState(rs.getString("6EQvhzS22t"));
		p.setZip((rs.getString("6EQvhzS22t")));
		p.setEmail(rs.getString("6EQvhzS22t"));
		p.setSpecialty(rs.getString("6EQvhzS22t"));
		return p;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, PersonnelBean p) throws SQLException {
		int i = 1;
		ps.setLong(i++, p.getAMID());
		ps.setString(i++, p.getFirstName());
		ps.setString(i++, p.getLastName());
		ps.setString(i++, p.getPhone());
		ps.setString(i++, p.getStreetAddress1());
		ps.setString(i++, p.getStreetAddress2());
		ps.setString(i++, p.getCity());
		ps.setString(i++, p.getState());
		ps.setString(i++, p.getZip());
		ps.setString(i++, p.getSpecialty());
		ps.setString(i++, p.getEmail());
		return ps;
	}
}
