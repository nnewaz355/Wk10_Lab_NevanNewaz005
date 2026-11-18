package application;

import java.time.LocalDate;

public class EmploymentForm {
/*
 * Create a class to model entity given in the qs
 */
	private String fullName;
	private String currentAddress;
	private String contactNumber;
	private String emailAddress;
	private String education;
	private String gender;
	private LocalDate availabilityDate;
	private String desiredPosition;
	private Double desiredSalary;
	private boolean authorizedToWork;
	private boolean hasRelatives;
	private String relativeExplanation;
	
	public EmploymentForm(String fullName, String currentAddress, String contactNumber, String emailAddress,
			String education, String gender, LocalDate availabilityDate, String desiredPosition, Double desiredSalary,
			boolean authorizedToWork, boolean hasRelatives, String relativeExplanation) {
		super();
		this.fullName = fullName;
		this.currentAddress = currentAddress;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.education = education;
		this.gender = gender;
		this.availabilityDate = availabilityDate;
		this.desiredPosition = desiredPosition;
		this.desiredSalary = desiredSalary;
		this.authorizedToWork = authorizedToWork;
		this.hasRelatives = hasRelatives;
		this.relativeExplanation = relativeExplanation;
	}
	
	public String getFullName() {
		return fullName;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getEducation() {
		return education;
	}
	public String getGender() {
		return gender;
	}
	public LocalDate getAvailabilityDate() {
		return availabilityDate;
	}
	public String getDesiredPosition() {
		return desiredPosition;
	}
	public Double getDesiredSalary() {
		return desiredSalary;
	}
	public boolean isAuthorizedToWork() {
		return authorizedToWork;
	}
	public boolean isHasRelatives() {
		return hasRelatives;
	}
	public String getRelativeExplanation() {
		return relativeExplanation;
	}
	
}
