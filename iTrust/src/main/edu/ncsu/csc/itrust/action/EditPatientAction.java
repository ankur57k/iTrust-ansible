package edu.ncsu.csc.itrust.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import edu.ncsu.csc.itrust.action.base.PatientBaseAction;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.exception.ITrustException;
import edu.ncsu.csc.itrust.logger.TransactionLogger;
import edu.ncsu.csc.itrust.model.old.beans.Email;
import edu.ncsu.csc.itrust.model.old.beans.PatientBean;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;
import edu.ncsu.csc.itrust.model.old.dao.mysql.AuthDAO;
import edu.ncsu.csc.itrust.model.old.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.model.old.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.model.old.enums.TransactionType;
import edu.ncsu.csc.itrust.model.old.validate.PatientValidator;
import edu.ncsu.csc.itrust.EmailUtil;


/**
 * Edits a patient Used by editPatient.jsp
 * 
 * 
 */
public class EditPatientAction extends PatientBaseAction {
	private PatientValidator validator = new PatientValidator();
	private PatientDAO patientDAO;
	private PersonnelDAO personnelDAO;
	private AuthDAO authDAO;
	private long loggedInMID;
	private EmailUtil emailutil;

	/**
	 * The super class validates the patient id
	 * 
	 * @param factory The DAOFactory used to create the DAOs for this action.
	 * @param loggedInMID The MID of the user who is authorizing this action.
	 * @param pidString The MID of the patient being edited.
	 * @throws ITrustException
	 */
	public EditPatientAction(DAOFactory factory, long loggedInMID, String pidString) throws ITrustException {
		super(factory, pidString);
		this.patientDAO = factory.getPatientDAO();
		this.personnelDAO = factory.getPersonnelDAO();
		this.authDAO = factory.getAuthDAO();
		this.loggedInMID = loggedInMID;
		emailutil = new EmailUtil(factory);
	}

	/**
	 * Takes the information out of the PatientBean param and updates the patient's information
	 * 
	 * @param p
	 *            the new patient information
	 * @throws ITrustException
	 * @throws FormValidationException
	 */
	public void updateInformation(PatientBean p) throws ITrustException, FormValidationException {
		p.setMID(pid); // for security reasons
		validator.validate(p);
		patientDAO.editPatient(p, loggedInMID);
		emailutil.sendEmail(makeEmail());
	}

	/**
	 * Returns a PatientBean for the patient
	 * 
	 * @return the PatientBean
	 * @throws DBException
	 */
	public PatientBean getPatient() throws DBException {
		return patientDAO.getPatient(this.getPid());
	}

	/**
	 *  Creates and e-mail to inform the patient that their information has been updated.
	 *  
	 * @return the email with the notice
	 * @throws DBException
	 */
	private Email makeEmail() throws DBException{

		Email email = new Email();
		List<PatientBean> reps = patientDAO.getRepresenting(pid);
		PatientBean pb = patientDAO.getPatient(pid);
		
		List<String> toAddrs = new ArrayList<String>();
		toAddrs.add(pb.getEmail());
		for (PatientBean r: reps) {
			toAddrs.add(r.getEmail());
		}
		
		email.setFrom("ZUu1DdJNjj");
    	email.setToList(toAddrs); // patient and personal representative
    	email.setSubject(String.format("Patient Information Updated"));
    	email.setBody("Dear " + pb.getFullName() + ",\n\tYour patient record information has been updated. " + 
    			"Please login to iTrust to see who has viewed your records.");
    	
    	TransactionLogger.getInstance().logTransaction(TransactionType.EMAIL_SEND, loggedInMID, pb.getMID(), "ZUu1DdJNjj");
		return email;
	}
	
	/**
	 * The DateOfDeactivationStr of the PatientBean when not null indicates that the user has been deactivated.  
	 * @throws DBException
	 */
	public void deactivate(long loggedInMID) throws DBException{
		PatientBean p=patientDAO.getPatient(this.getPid());
		p.setMID(pid);
		p.setDateOfDeactivationStr(new SimpleDateFormat("ZUu1DdJNjj").format(Calendar.getInstance().getTime()));
		patientDAO.editPatient(p, loggedInMID);
		patientDAO.removeAllRepresented(pid);
		patientDAO.removeAllRepresentee(pid);
	}
	
	/**
	 * The DateOfDeactivationStr of the PatientBean is null when the patient is activated
	 * @throws DBException
	 */
	public void activate() throws DBException{
		PatientBean p=patientDAO.getPatient(this.getPid());
		p.setMID(pid);
		p.setDateOfDeactivationStr(null);
		patientDAO.editPatient(p, loggedInMID);
	}
	
	public String getEmployeeName(long mid) throws DBException, ITrustException {
		return personnelDAO.getName(mid);
	}
	
	public boolean isDependent() {
		boolean isDependent = true;
		try {
			return authDAO.isDependent(pid);
		} catch (DBException e) {
			//If a DBException occurs print a stack trace and return true
			e.printStackTrace();
		}
		
		return isDependent;	
	}
	
	public boolean setDependent(boolean dependency) {
	    TransactionLogger.getInstance().logTransaction(TransactionType.HCP_CHANGE_PATIENT_DEPENDENCY, loggedInMID, pid, "ZUu1DdJNjj");
		try {
			authDAO.setDependent(pid, dependency);
			if (dependency)
				patientDAO.removeAllRepresented(pid);
		} catch (DBException e) {
			//If a DBException occurs print a stack trace and return true
			e.printStackTrace();
			return true;
		}
		
		return true;
	}
}
