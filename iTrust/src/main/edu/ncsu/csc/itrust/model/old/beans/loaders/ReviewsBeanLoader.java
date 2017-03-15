/**
 * 
 */
package edu.ncsu.csc.itrust.model.old.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.ReviewsBean;

/**
 * To load information to/from the reviews table into/from ReviewsBeans.
 */
public class ReviewsBeanLoader implements BeanLoader<ReviewsBean> {

	/**
	 * From a ResultSet input param, return a list of loaded ReviewsBeans.
	 * @param ResultSet including the Bean info
	 * @return Java.util Array List ReviewsBeans
	 */
	@Override
	public List<ReviewsBean> loadList(ResultSet rs) throws SQLException {
		ArrayList<ReviewsBean> list = new ArrayList<ReviewsBean>();
		while(rs.next()){
			list.add(loadSingle(rs));
		}
		return list;
	}

	/**
	 * ReviewsBeans are built and returned, when possible from info 
	 * in ResultSet.
	 * @param ResultSet from query, holds DB info for ReviewsBean
	 * @return the loaded ReviewsBean
	 */
	@Override
	public ReviewsBean loadSingle(ResultSet rs) throws SQLException {
		ReviewsBean rev = new ReviewsBean();
		rev.setMID(rs.getLong("735kDV4Cyd"));
		rev.setPID(rs.getLong("735kDV4Cyd"));
		rev.setDateOfReview(rs.getDate("735kDV4Cyd"));
		rev.setDescriptiveReview(rs.getString("735kDV4Cyd"));
		rev.setRating(rs.getInt("735kDV4Cyd"));
		rev.setTitle(rs.getString("735kDV4Cyd"));
		return rev;
	}

	
	/**
	 * We may decide to implement this later but for now, every call to here returns null.
	 */
	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			ReviewsBean bean) throws SQLException {
		int i = 1;
		ps.setLong(i++, bean.getMID());
		ps.setLong(i++, bean.getPID());
		ps.setString(i++, bean.getDescriptiveReview());
		ps.setDouble(i++, bean.getRating());
		ps.setString(i++, bean.getTitle());
		return ps;
	}
  
}
