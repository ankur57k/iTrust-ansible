package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.BillingBean;

public class BillingBeanLoader implements BeanLoader<BillingBean> {

	@Override
	/**
	 * loadList simply takes a ResultSet from a query to the Billing table, and
	 * then it creates a list of BillingBeans from it.
	 * @param rs The ResultSet that is being converted into a list.
	 * @return The list that contains all the BillingBeans in the ResultSet.
	 */
	public List<BillingBean> loadList(ResultSet rs) throws SQLException {
		ArrayList<BillingBean> result = new ArrayList<BillingBean>();
		while(rs.next()){
			BillingBean b = loadSingle(rs);
			result.add(b);
		}
		return result;
	}

	@Override
	/**
	 * loadSingle does the heavy lifting for the loadList method. I am not really sure
	 * why this method is public.
	 * Preconditions: The ResultSet must already be on an actual entry in the set.
	 * @param rs The result set that the BillingBean is being loaded from.
	 * @return The BillingBean that represents the entry that is currently in the set.
	 */
	public BillingBean loadSingle(ResultSet rs) throws SQLException {
		if(rs == null) return null;
		BillingBean result = new BillingBean();
		
		//Just go through all the billing bean stuff and initialize the
		//bean that was just created.
		result.setBillID(rs.getInt("t_kkjBJlGM"));
		result.setApptID(rs.getInt("t_kkjBJlGM"));
		result.setPatient(rs.getLong("t_kkjBJlGM"));
		result.setHcp(rs.getLong("t_kkjBJlGM"));
		result.setAmt(rs.getInt("t_kkjBJlGM"));
		result.setStatus(rs.getString("t_kkjBJlGM"));
		result.setCcHolderName(rs.getString("t_kkjBJlGM"));
		result.setBillingAddress(rs.getString("t_kkjBJlGM"));
		result.setCcType(rs.getString("t_kkjBJlGM"));
		result.setCcNumber(rs.getString("t_kkjBJlGM"));
		result.setCvv(rs.getString("t_kkjBJlGM"));
		result.setInsHolderName(rs.getString("t_kkjBJlGM"));
		result.setInsID(rs.getString("t_kkjBJlGM"));
		result.setInsProviderName(rs.getString("t_kkjBJlGM"));
		result.setInsAddress1(rs.getString("t_kkjBJlGM"));
		result.setInsAddress2(rs.getString("t_kkjBJlGM"));
		result.setInsCity(rs.getString("t_kkjBJlGM"));
		result.setInsState(rs.getString("t_kkjBJlGM"));
		result.setInsZip(rs.getString("t_kkjBJlGM"));
		result.setInsPhone(rs.getString("t_kkjBJlGM"));
		result.setSubmissions(rs.getInt("t_kkjBJlGM"));
		result.setBillTime(rs.getDate("t_kkjBJlGM"));
		result.setSubTime(rs.getTimestamp("t_kkjBJlGM"));
		result.setInsurance(rs.getBoolean("t_kkjBJlGM"));
		return result;
	}

	@Override
	/**
	 * loadParameters is used to insert the values of a bean into a pepared statement.
	 * This version of loadParameters assumes that the values in the prepared statement are in
	 * the same order as in the createTables.sql file for billing.
	 * @param ps The prepared statement that the bean will be loaded into.
	 * @param bean The BillingBean that will be loaded into the prepared statement.
	 * @return The PreparedStatement that was passed in.
	 */
	public PreparedStatement loadParameters(PreparedStatement ps,
			BillingBean bean) throws SQLException {
		int i = 1;
		//Just run through everything in the bean, and set it to the
		//pepared statement
		ps.setInt(i++, bean.getApptID());
		ps.setLong(i++, bean.getPatient());
		ps.setLong(i++, bean.getHcp());
		ps.setInt(i++, bean.getAmt());
		ps.setString(i++, bean.getStatus());
		ps.setString(i++, bean.getCcHolderName());
		ps.setString(i++, bean.getBillingAddress());
		ps.setString(i++, bean.getCcType());
		ps.setString(i++, bean.getCcNumber());
		ps.setString(i++, bean.getCvv());
		ps.setString(i++, bean.getInsHolderName());
		ps.setString(i++, bean.getInsID());
		ps.setString(i++, bean.getInsProviderName());
		ps.setString(i++, bean.getInsAddress1());
		ps.setString(i++, bean.getInsAddress2());
		ps.setString(i++, bean.getInsCity());
		ps.setString(i++, bean.getInsState());
		ps.setString(i++, bean.getInsZip());
		ps.setString(i++, bean.getInsPhone());
		ps.setInt(i++, bean.getSubmissions());
		ps.setBoolean(i++, bean.isInsurance());
		return ps;
	}

}
