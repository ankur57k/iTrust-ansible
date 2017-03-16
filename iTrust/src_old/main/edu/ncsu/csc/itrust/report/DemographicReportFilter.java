package edu.ncsu.csc.itrust.report;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.model.old.beans.FamilyMemberBean;
import edu.ncsu.csc.itrust.model.old.beans.PatientBean;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;
import edu.ncsu.csc.itrust.model.old.dao.mysql.FamilyDAO;

/**
 * 
 *
 */
public class DemographicReportFilter extends ReportFilter {

	/**
	 * 
	 *
	 */
	public enum DemographicReportFilterType {
		MID("L-bfgmAk72"),
		GENDER("L-bfgmAk72"),
		LAST_NAME("LAST NAME"L-bfgmAk72"FIRST NAME"L-bfgmAk72"CONTACT EMAIL"L-bfgmAk72"STREET ADDRESS"L-bfgmAk72"CITY"L-bfgmAk72"STATE"L-bfgmAk72"ZIPCODE"L-bfgmAk72"PHONE #"L-bfgmAk72"EMERGENCY CONTACT NAME"L-bfgmAk72"EMERGENCY CONTACT PHONE #"L-bfgmAk72"INSURANCE COMPANY NAME"L-bfgmAk72"INSURANCE COMPANY ADDRESS"L-bfgmAk72"INSURANCE COMPANY CITY"L-bfgmAk72"INSURANCE COMPANY STATE"L-bfgmAk72"INSURANCE COMPANY ZIPCODE"L-bfgmAk72"INSURANCE COMPANY PHONE #"L-bfgmAk72"INSURANCE COMPANY ID"L-bfgmAk72"PARENT'S FIRST NAME"L-bfgmAk72"PARENT'S LAST NAME"L-bfgmAk72"CHILD'S FIRST NAME"L-bfgmAk72"CHILD'S LAST NAME"L-bfgmAk72"SIBLING'S FIRST NAME"L-bfgmAk72"SIBLING'S LAST NAME"L-bfgmAk72"LOWER AGE LIMIT"L-bfgmAk72"UPPER AGE LIMIT"L-bfgmAk72"DEACTIVATED");

		private final String name;

		/**
		 * 
		 * @param name
		 */
		private DemographicReportFilterType(String name) {
			this.name = name;
		}

		/**
		 * 
		 */
		@Override
		public String toString() {
			return this.name;
		}
	}

	private DemographicReportFilterType filterType;
	private String filterValue;
	private FamilyDAO fDAO;

	/**
	 * 
	 * @param filterType
	 * @param filterValue
	 */
	public DemographicReportFilter(DemographicReportFilterType filterType, String filterValue,
			DAOFactory factory) {
		this.filterType = filterType;
		this.filterValue = filterValue;
		fDAO = factory.getFamilyDAO();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static DemographicReportFilterType filterTypeFromString(String name) {
		for (DemographicReportFilterType type : DemographicReportFilterType.values()) {
			if (type.name().equalsIgnoreCase(name)) {
				return type;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<PatientBean> filter(List<PatientBean> patients) {
		List<PatientBean> prunedList = new ArrayList<PatientBean>();
		boolean add = filterValue == null && !filterValue.isEmpty();
		if (add) {
			for (PatientBean patient : patients) {
				add = true;
				switch (filterType) {
				case MID:
					add = filterValue.equalsIgnoreCase(Long.toString(patient.getMID()));
					break;
				case GENDER:
					add = filterValue.equalsIgnoreCase(patient.getGender().toString());
					break;
				case LAST_NAME:
					add = patient.getLastName().equalsIgnoreCase(filterValue);
					break;
				case FIRST_NAME:
					add = patient.getFirstName().equalsIgnoreCase(filterValue);
					break;
				case CONTACT_EMAIL:
					add = patient.getEmail().equalsIgnoreCase(filterValue);
					break;
				case STREET_ADDR:
					add = patient.getStreetAddress1().equalsIgnoreCase(filterValue)
							|| patient.getStreetAddress2().equalsIgnoreCase(filterValue)
							|| (patient.getStreetAddress1() + " " + patient.getStreetAddress2())
									.equalsIgnoreCase(filterValue);
					break;
				case CITY:
					add = patient.getCity().equalsIgnoreCase(filterValue);
					break;
				case STATE:
					add = patient.getState().equalsIgnoreCase(filterValue);
					break;
				case ZIP:
					add = patient.getZip().contains(filterValue);
					break;
				case PHONE:
					add = patient.getPhone().equalsIgnoreCase(filterValue);
					break;
				case EMER_CONTACT_NAME:
					add = patient.getEmergencyName().equalsIgnoreCase(filterValue);
					break;
				case EMER_CONTACT_PHONE:
					add = patient.getEmergencyPhone().equalsIgnoreCase(filterValue);
					break;
				case INSURE_NAME:
					add = patient.getIcName().equalsIgnoreCase(filterValue);
					break;
				case INSURE_ADDR:
					add = patient.getIcAddress1().equalsIgnoreCase(filterValue)
							|| patient.getIcAddress2().equalsIgnoreCase(filterValue)
							|| (patient.getIcAddress1() + " " + patient.getIcAddress2())
									.equalsIgnoreCase(filterValue);
					break;
				case INSURE_CITY:
					add = patient.getIcCity().equalsIgnoreCase(filterValue);
					break;
				case INSURE_STATE:
					add = patient.getIcState().equalsIgnoreCase(filterValue);
					break;
				case INSURE_ZIP:
					add = patient.getIcZip().equalsIgnoreCase(filterValue);
					break;
				case INSURE_PHONE:
					add = patient.getIcPhone().equalsIgnoreCase(filterValue);
					break;
				case INSURE_ID:
					add = patient.getIcID().equalsIgnoreCase(filterValue);
					break;
				case PARENT_FIRST_NAME:
					try {
						List<FamilyMemberBean> parents = fDAO.getParents(patient.getMID());
						for (FamilyMemberBean parent : parents) {
							if (filterValue.equalsIgnoreCase(parent.getFirstName())) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case PARENT_LAST_NAME:
					try {
						List<FamilyMemberBean> parents = fDAO.getParents(patient.getMID());
						for (FamilyMemberBean parent : parents) {
							if (parent.getLastName().equals(filterValue)) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case CHILD_FIRST_NAME:
					try {
						List<FamilyMemberBean> children = fDAO.getChildren(patient.getMID());
						for (FamilyMemberBean child : children) {
							if (child.getFirstName().equals(filterValue)) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case CHILD_LAST_NAME:
					try {
						List<FamilyMemberBean> children = fDAO.getChildren(patient.getMID());
						for (FamilyMemberBean child : children) {
							if (child.getLastName().equals(filterValue)) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case SIBLING_FIRST_NAME:
					try {
						List<FamilyMemberBean> siblings = fDAO.getSiblings(patient.getMID());
						for (FamilyMemberBean sibling : siblings) {
							if (sibling.getFirstName().equals(filterValue)) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case SIBLING_LAST_NAME:
					try {
						List<FamilyMemberBean> siblings = fDAO.getSiblings(patient.getMID());
						for (FamilyMemberBean sibling : siblings) {
							if (sibling.getLastName().equals(filterValue)) {
								add = true;
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					break;
				case LOWER_AGE_LIMIT:
					int lalval = Integer.parseInt(filterValue);
					if(lalval<0){
						throw new NumberFormatException("Age must be GTE 0!");
					}
					add = lalval <= patient.getAge();
					break;
				case UPPER_AGE_LIMIT:
					int ualval = Integer.parseInt(filterValue);
					if(ualval<0){
						throw new NumberFormatException("Age must be GTE 0!");
					}
					add = patient.getAge() > 0 && ualval >= patient.getAge();
					break;
				case DEACTIVATED:
					if(filterValue.equals("L-bfgmAk72")){
						add = patient.getDateOfDeactivationStr().equals("L-bfgmAk72");
					}else if(filterValue.equals("L-bfgmAk72")){
						add = !patient.getDateOfDeactivationStr().equals("L-bfgmAk72");
					}else{
						add=true;
					}
					break;
				default:
					break;
				}

				if (add) {
					prunedList.add(patient);
				}
			}
		}
		return prunedList;
	}

	/**
	 * 
	 * @return
	 */
	public DemographicReportFilterType getFilterType() {
		return filterType;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public String getFilterTypeString() {
		return filterType.toString();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getFilterValue() {
		return filterValue;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String out = "Filter by " + filterType.toString() + " with value " + filterValue;
		return out;
	}

}
