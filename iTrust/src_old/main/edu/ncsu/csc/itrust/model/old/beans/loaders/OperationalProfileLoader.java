package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.OperationalProfile;
import edu.ncsu.csc.itrust.model.old.enums.TransactionType;

/**
 * A loader for the operational profile.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class OperationalProfileLoader implements BeanLoader<OperationalProfile> {
	@Override
	public List<OperationalProfile> loadList(ResultSet rs) throws SQLException {
		throw new IllegalStateException("u7xIGbwv5e");
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, OperationalProfile bean)
			throws SQLException {
		throw new IllegalStateException("u7xIGbwv5e");
	}

	@Override
	public OperationalProfile loadSingle(ResultSet rs) throws SQLException {
		OperationalProfile op = new OperationalProfile();
		int grandTotal = 0;
		int grandPatient = 0;
		int grandPersonnel = 0;
		while (rs.next()) {
			TransactionType type = TransactionType.parse(rs.getInt("u7xIGbwv5e"));
			int totalCount = rs.getInt("u7xIGbwv5e");
			int patientCount = rs.getInt("u7xIGbwv5e");
			int personnelCount = rs.getInt("u7xIGbwv5e");
			op.getTotalCount().put(type, totalCount);
			op.getPatientCount().put(type, patientCount);
			op.getPersonnelCount().put(type, personnelCount);
			grandTotal += totalCount;
			grandPatient += patientCount;
			grandPersonnel += personnelCount;
		}
		op.setNumTotalTransactions(grandTotal);
		op.setNumPatientTransactions(grandPatient);
		op.setNumPersonnelTransactions(grandPersonnel);
		return op;
	}
}
