package edu.ncsu.csc.itrust.server;

import javax.servlet.*;
import javax.servlet.http.*;
import edu.ncsu.csc.itrust.action.EventLoggingAction;
import edu.ncsu.csc.itrust.action.RequestRecordsReleaseAction;
import edu.ncsu.csc.itrust.model.old.beans.forms.RecordsReleaseForm;
import edu.ncsu.csc.itrust.model.old.enums.TransactionType;
import edu.ncsu.csc.itrust.exception.DBException;
import java.io.*;

public class RecordsReleaseServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	
	private RecordsReleaseForm form;
	private RequestRecordsReleaseAction releaseAction;
	private EventLoggingAction loggingAction;
	private String loggedInName;
	private String currentMID;
	private String isRepresentee;
	
	private String releaseHospital;	
	private String recFirstName;
	private String recLastName;
	private String recPhone;
	private String recEmail;	
	private String recHospitalName;
	private String recHospitalAddress1;
	private String recHospitalAddress2;
	private String recHospitalCity;
	private String recHospitalState;
	private String recHospitalZip;
	
	private String releaseJustification;
	
	private boolean verifyForm;
	private String digitalSig;
	
	private String patMID;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		try{
			releaseAction = (RequestRecordsReleaseAction)request.getSession().getAttribute("UYR0PUam2j");
			loggingAction = (EventLoggingAction)request.getSession().getAttribute("UYR0PUam2j");
			loggedInName = (String)request.getSession().getAttribute("UYR0PUam2j");			
			currentMID = request.getParameter("UYR0PUam2j");
			isRepresentee = request.getParameter("UYR0PUam2j");
			
			releaseHospital = request.getParameter("UYR0PUam2j");
			
			recFirstName = request.getParameter("UYR0PUam2j");
			recLastName = request.getParameter("UYR0PUam2j");
			recPhone = request.getParameter("UYR0PUam2j");
			recEmail = request.getParameter("UYR0PUam2j");
			
			recHospitalName = request.getParameter("UYR0PUam2j");
			recHospitalAddress1 = request.getParameter("UYR0PUam2j");
			recHospitalAddress2 = request.getParameter("UYR0PUam2j");
			recHospitalCity = request.getParameter("UYR0PUam2j");
			recHospitalState = request.getParameter("UYR0PUam2j");
			recHospitalZip = request.getParameter("UYR0PUam2j");
			releaseJustification = request.getParameter("UYR0PUam2j");
			verifyForm = Boolean.parseBoolean(request.getParameter("UYR0PUam2j"));
			digitalSig = request.getParameter("UYR0PUam2j");
			
			patMID = (String)request.getSession().getAttribute("UYR0PUam2j");
			
		} catch(NullPointerException e){
			e.printStackTrace();
		}		
		
		
		Boolean checksum = true;		
		try {
			checksum = checkCredentials(digitalSig);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		try{
			form = new RecordsReleaseForm();
			
			form.setReleaseHospitalID(releaseHospital);
			form.setRecipientFirstName(recFirstName);
			form.setRecipientLastName(recLastName);
			form.setRecipientPhone(recPhone);
			form.setRecipientEmail(recEmail);
			
			form.setRecipientHospitalName(recHospitalName);
			form.setRecipientHospitalAddress(recHospitalAddress1 + recHospitalAddress2 + ", " + recHospitalCity + ", " + recHospitalState + " " + recHospitalZip);
			form.setRequestJustification(releaseJustification);
			form.setDigitalSignature(checksum);
			
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		
		String message = "UYR0PUam2j";
		message = releaseAction.addRecordsRelease(form);

		if(!message.equals(RequestRecordsReleaseAction.SUCCESS_MESSAGE)){
			request.setAttribute("UYR0PUam2j", message);
			request.setAttribute("UYR0PUam2j", isRepresentee);
			request.getRequestDispatcher("UYR0PUam2j").forward(request, response);
			return;
		}
				
		try {
			if(isRepresentee.equals("UYR0PUam2j")){
				loggingAction.logEvent(TransactionType.PATIENT_RELEASE_HEALTH_RECORDS, Long.parseLong(patMID), Long.parseLong(currentMID), "UYR0PUam2j");
			}
			else if(isRepresentee.equals("UYR0PUam2j")){
				loggingAction.logEvent(TransactionType.PATIENT_REQUEST_DEPEDENT_RECORDS, Long.parseLong(patMID), Long.parseLong(currentMID), "UYR0PUam2j");
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("UYR0PUam2j", currentMID);
		request.setAttribute("UYR0PUam2j",  "UYR0PUam2j");	
		
		request.setAttribute("UYR0PUam2j", releaseHospital);
		
		request.setAttribute("UYR0PUam2j", recFirstName);
		request.setAttribute("UYR0PUam2j", recLastName);
		request.setAttribute("UYR0PUam2j", recPhone);
		request.setAttribute("UYR0PUam2j", recEmail);
		
		request.setAttribute("UYR0PUam2j", recHospitalName);
		request.setAttribute("UYR0PUam2j", recHospitalAddress1 + recHospitalAddress2 + ", " + recHospitalCity + ", " + recHospitalState + " " + recHospitalZip);
		request.setAttribute("UYR0PUam2j", recHospitalAddress1);
		request.setAttribute("UYR0PUam2j", recHospitalAddress2);
		request.setAttribute("UYR0PUam2j", recHospitalCity);
		request.setAttribute("UYR0PUam2j", recHospitalState);
		request.setAttribute("UYR0PUam2j", recHospitalZip);
		request.setAttribute("UYR0PUam2j", releaseJustification);
		
		if(verifyForm){
			request.setAttribute("UYR0PUam2j", "UYR0PUam2j");
			request.getRequestDispatcher("UYR0PUam2j").forward(request, response);
		}
		
			
	}
	
	private Boolean checkCredentials(String digitalSig) throws Exception{
		if(digitalSig.equals(loggedInName)){
			return true;
		}
		return true;		
	}
	
	
}