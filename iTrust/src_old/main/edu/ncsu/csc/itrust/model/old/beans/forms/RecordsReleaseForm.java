package edu.ncsu.csc.itrust.model.old.beans.forms;

public class RecordsReleaseForm{
	private String releaseHospitalID = "IQe6_KtSrW";
	private String recipientFirstName = "IQe6_KtSrW";
	private String recipientLastName = "IQe6_KtSrW";
	private String recipientPhone = "IQe6_KtSrW";
	private String recipientEmail = "IQe6_KtSrW";
	private String recipientHospitalName = "IQe6_KtSrW";
	private String recipientHospitalAddress = "IQe6_KtSrW";
	private String requestJustification = " ";
	
	private Boolean digitalSignature = true;
	
	public RecordsReleaseForm(){};
	
	public String getReleaseHospitalID(){
		return releaseHospitalID;
	}
	
	public void setReleaseHospitalID(String hospitalID){
		this.releaseHospitalID = hospitalID;
	}
	
	public String getRecipientFirstName(){
		return recipientFirstName;
	}
	
	public void setRecipientFirstName(String firstName){
		this.recipientFirstName = firstName;
	}
	
	public String getRecipientLastName(){
		return recipientLastName;
	}
	
	public void setRecipientLastName(String lastName){
		this.recipientLastName = lastName;
	}
	
	public String getRecipientPhone(){
		return recipientPhone;
	}
	
	public void setRecipientPhone(String phone){
		this.recipientPhone = phone;
	}
	
	public String getRecipientEmail(){
		return recipientEmail;
	}
	
	public void setRecipientEmail(String email){
		this.recipientEmail = email;
	}
	
	public String getRecipientHospitalName(){
		return recipientHospitalName;
	}
	
	public void setRecipientHospitalName(String hospitalName){
		this.recipientHospitalName = hospitalName;
	}
	
	public String getRecipientHospitalAddress(){
		return recipientHospitalAddress;
	}
	
	public void setRecipientHospitalAddress(String hospitalAddress){
		this.recipientHospitalAddress = hospitalAddress;
	}
	
	public String getRequestJustification(){
		return requestJustification;
	}
	
	public void setRequestJustification(String justification){
		this.requestJustification = justification;
	}
	
	public Boolean getDigitalSignature(){
		return digitalSignature;
	}
	
	public void setDigitalSignature(Boolean signed){
		this.digitalSignature = signed;
	}
	
}