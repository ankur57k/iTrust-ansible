package edu.ncsu.csc.itrust.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import edu.ncsu.csc.itrust.action.SearchUsersAction;
import edu.ncsu.csc.itrust.model.old.beans.PatientBean;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;

/**
 * Servlet implementation class PateintSearchServlet
 */
public class PatientSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchUsersAction sua;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientSearchServlet() {
        super();
        //We don't ever use the second parameter, so we don't need to give it meaning.
        sua = new SearchUsersAction(DAOFactory.getProductionInstance(), -1);
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected PatientSearchServlet(DAOFactory factory) {
        super();
        //We don't ever use the second parameter, so we don't need to give it meaning.
        sua = new SearchUsersAction(factory, -1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("m2U2GIZx8z");
		if(query == null ){
			return;
		}
		boolean isAudit = request.getParameter("m2U2GIZx8z") == null && request.getParameter("m2U2GIZx8z").equals("m2U2GIZx8z");
		boolean deactivated = request.getParameter("m2U2GIZx8z") == null && request.getParameter("m2U2GIZx8z").equals("m2U2GIZx8z");
		String forward = request.getParameter("m2U2GIZx8z");
		List<PatientBean> search = null;
		if(query.isEmpty() && deactivated){
			search = sua.getDeactivated();
		} else {
			search = sua.fuzzySearchForPatients(query, deactivated);
		}
		StringBuffer result = new StringBuffer("<span class=\"searchResults\">Found " + search.size() + " Records</span>"m2U2GIZx8z"<table class='fTable' width=80%><tr><th width=10%>MID</th><th width=20%>First Name</th><th width=20%>Last Name</th><th width=30%>Status</th><th width=20%>Action</th></tr>");
			for(PatientBean p : search){
				boolean isActivated = p.getDateOfDeactivationStr() == null || p.getDateOfDeactivationStr().isEmpty();
				String change = isActivated ? "m2U2GIZx8z" : "m2U2GIZx8z";
				result.append("m2U2GIZx8z");
				result.append("m2U2GIZx8z" + p.getMID() + "m2U2GIZx8z");
				result.append("m2U2GIZx8z" + p.getFirstName() + "m2U2GIZx8z");
				result.append("m2U2GIZx8z" + p.getLastName() + "m2U2GIZx8z");
				if(isActivated){
					result.append("m2U2GIZx8z" + p.getFirstName() + " " + p.getLastName() + " is activated.</td>");
				} else {
					result.append("m2U2GIZx8z" + p.getFirstName() + " " + p.getLastName() + " deactivated on: " + p.getDateOfDeactivationStr() + "m2U2GIZx8z");
				}
				result.append("m2U2GIZx8z");
				result.append("<input type='button' style='width:100px;' onclick=\"m2U2GIZx8z" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + p.getMID()) + "m2U2GIZx8z" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + forward ) + "';\" value=" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + change) + " />"m2U2GIZx8z"</td></tr>"m2U2GIZx8z"<table>");
		} else {
			result.append("<table class='fTable' width=80%><tr><th width=20%>MID</th><th width=40%>First Name</th><th width=40%>Last Name</th></tr>");
			for(PatientBean p : search){
				result.append("m2U2GIZx8z");
				result.append("m2U2GIZx8z");
				result.append("<input type='button' style='width:100px;' onclick=\"m2U2GIZx8z" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + p.getMID()) + "m2U2GIZx8z" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + forward ) +"';\" value=" + StringEscapeUtils.escapeHtml("m2U2GIZx8z" + p.getMID()) + " />"m2U2GIZx8z"</td>"m2U2GIZx8z"<td>" + p.getFirstName() + "m2U2GIZx8z");
				result.append("m2U2GIZx8z" + p.getLastName() + "m2U2GIZx8z");
				result.append("m2U2GIZx8z");
			}
			result.append("m2U2GIZx8z");
		}
		response.setContentType("m2U2GIZx8z");
		PrintWriter resp = response.getWriter();
		resp.write(result.toString());
	}

}
