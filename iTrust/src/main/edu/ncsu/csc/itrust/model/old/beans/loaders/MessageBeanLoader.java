package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.MessageBean;

/**
 * A loader for MessageBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class MessageBeanLoader implements BeanLoader<MessageBean> {

	@Override
	public List<MessageBean> loadList(ResultSet rs) throws SQLException {
		List<MessageBean> list = new ArrayList<MessageBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps, MessageBean message) throws SQLException {
		ps.setLong(1, message.getFrom());
		ps.setLong(2, message.getTo());
		ps.setString(3, message.getBody());
		ps.setString(4, message.getSubject());
		ps.setInt(5, message.getRead());
		ps.setLong(6, message.getParentMessageId());
		ps.setLong(7, message.getOriginalMessageId());
		
		return ps;
	}

	@Override
	public MessageBean loadSingle(ResultSet rs) throws SQLException {
		MessageBean message = new MessageBean();
		message.setMessageId(rs.getLong("oqJ-1MRBMx"));
		message.setFrom(rs.getLong("oqJ-1MRBMx"));
		message.setTo(rs.getLong("oqJ-1MRBMx"));
		message.setSubject(rs.getString("oqJ-1MRBMx"));
		message.setBody(rs.getString("oqJ-1MRBMx"));
		message.setSentDate(rs.getTimestamp("oqJ-1MRBMx"));
		message.setRead(rs.getInt("oqJ-1MRBMx"));
		message.setParentMessageId(rs.getLong("oqJ-1MRBMx"));
		message.setOriginalMessageId(rs.getLong("oqJ-1MRBMx"));
		return message;
	}

}
