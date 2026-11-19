package application;
	
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
	/*
	 * Refer to main page of example
	 */
		EmploymentFormDao employmentFormDao = new EmploymentFormDao();

		
		primaryStage.setTitle("John Comany | Employment Applicaton");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Employment Application");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Text personalInfoTitle = new Text("Personal Information");
		personalInfoTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		grid.add(personalInfoTitle, 0, 1, 2, 1);

		Label fullNameLabel = new Label("Full Name:");
		grid.add(fullNameLabel, 0, 2);
		TextField fullNameTextField = new TextField();
		grid.add(fullNameTextField, 1, 2);
		
		Label currentAddressLabel = new Label("Current Address:");
		grid.add(currentAddressLabel, 0, 3);
		TextField currentAddressTextField = new TextField();
		grid.add(currentAddressTextField, 1, 3);

		Label contactNumberLabel = new Label("Contact Number:");
		grid.add(contactNumberLabel, 0, 4);
		TextField contactNumberTextField = new TextField();
		grid.add(contactNumberTextField, 1, 4);

		Label emailLabel = new Label("Email Address:");
		grid.add(emailLabel, 0, 5);
		TextField emailTextField = new TextField();
		grid.add(emailTextField, 1, 5);
		
		Label educationLabel = new Label("Highest Educational Attainment:");
		grid.add(educationLabel, 0, 6);
		TextField educationTextField = new TextField();
		grid.add(educationTextField, 1, 6);
		
		Label genderLabel = new Label("Gender:");
		grid.add(genderLabel, 0, 7);
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		RadioButton other = new RadioButton("Other");
		ToggleGroup gender = new ToggleGroup();
		male.setToggleGroup(gender);
		female.setToggleGroup(gender);
		other.setToggleGroup(gender);
		HBox genderField = new HBox(20);
		genderField.getChildren().addAll(male,female,other);
		grid.add(genderField, 1, 7);
		
		Text eligibilityTitle = new Text("Employment Eligibility");
		eligibilityTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		grid.add(eligibilityTitle, 0, 8, 2, 1);
		
		Label dateAvailableLabel = new Label ("Date Available:");
		grid.add(dateAvailableLabel, 0, 9);
		DatePicker dateAvailableField = new DatePicker();
		grid.add(dateAvailableField, 1, 9);
		
		Label desiredPositionLabel = new Label("Desired Position:");
		grid.add(desiredPositionLabel, 0, 10);
		TextField desiredPositionTextField = new TextField();
		grid.add(desiredPositionTextField, 1, 10);
		
		Label desiredSalaryLabel = new Label("Desired Salary:");
		grid.add(desiredSalaryLabel, 0, 11);
		TextField desiredSalaryTextField = new TextField();
		grid.add(desiredSalaryTextField, 1, 11);
		
		Label authorizedLabel = new Label("Are you legally authorized to work in the country?");
		grid.add(authorizedLabel, 0, 12);
		RadioButton authorizedYes = new RadioButton("Yes");
		RadioButton authorizedNo = new RadioButton("No");
		ToggleGroup authorized = new ToggleGroup();
		authorizedYes.setToggleGroup(authorized);
		authorizedNo.setToggleGroup(authorized);
		HBox authorizedField = new HBox(20);
		authorizedField.getChildren().addAll(authorizedYes, authorizedNo);
		grid.add(authorizedField, 1, 12);
		
		Label relativesLabel = new Label("Do you have relatives working for our company?");
		grid.add(relativesLabel, 0, 13);
		RadioButton relativesYes = new RadioButton("Yes");
		RadioButton relativesNo = new RadioButton("No");
		ToggleGroup relatives = new ToggleGroup();
		relativesYes.setToggleGroup(relatives);
		relativesNo.setToggleGroup(relatives);
		HBox relativesField = new HBox(20);
		relativesField.getChildren().addAll(relativesYes,relativesNo);
		grid.add(relativesField, 1, 13);
		
		Label explanationLabel = new Label("If yes, please explain further:");
		grid.add(explanationLabel, 0, 14);
		TextField explanationTextField = new TextField();
		grid.add(explanationTextField, 1, 14);
		
		Label agreementLabel = new Label("By submitting this application, you agree to adhere to company policies and provide accurate information throughout the employment process.");
		grid.add(agreementLabel, 0, 15);
		Label signatureLabel = new Label("Applicant's Signature");
		grid.add(signatureLabel, 1, 15);
		

		Button applyButton = new Button("Apply");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.getChildren().add(applyButton);
		grid.add(hBox, 1, 16);

		applyButton.setOnAction(actionEvent -> {
			String fullName = fullNameTextField.getText().trim();
			String currentAddress = currentAddressTextField.getText().trim();
			String contactNumber = contactNumberTextField.getText().trim();
			String emailAddress = emailTextField.getText().trim();
			String education = educationTextField.getText().trim();
			String genderString = null;
			LocalDate dateAvailable = dateAvailableField.getValue();
			String desiredPosition = desiredPositionTextField.getText().trim();
			String desiredSalaryText = desiredSalaryTextField.getText().trim();
			double desiredSalary;
			boolean authorizedToWork = authorizedYes.isSelected(); //to be fixed
			boolean hasRelatives = relativesYes.isSelected(); //to be fixed
			String relativesExplanation = explanationTextField.getText().trim();
			if (!StringPool.BLANK.equals(fullName) && !StringPool.BLANK.equals(currentAddress) && !StringPool.BLANK.equals(contactNumber) && !StringPool.BLANK.equals(emailAddress) && !StringPool.BLANK.equals(education) && !StringPool.BLANK.equals(genderString) && dateAvailable != null && !StringPool.BLANK.equals(desiredPosition) && !StringPool.BLANK.equals(desiredSalaryText) && (authorizedYes.isSelected() || authorizedNo.isSelected()) && (relativesYes.isSelected() || relativesNo.isSelected())) {
				try {
						
					try {
						desiredSalary = Double.parseDouble(desiredSalaryText);
					}catch(NumberFormatException e) {
						this.alert("Error","Desired Salary must be a number.", AlertType.ERROR);
						return;
					}
						
					if (male.isSelected()) {
						genderString = "Male";
					}
					else if (female.isSelected()) {
						genderString = "Female";
					}
					else if (other.isSelected()) {
						genderString = "Other";
					}
					
					if (!contactNumber.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
						this.alert("Error", "Please provide a valid phone number.", AlertType.ERROR);
						return;
					}
					
					if (hasRelatives && StringPool.BLANK.equals(relativesExplanation)) {
						this.alert("Error", "Please explain about your relatives.", AlertType.ERROR);
						return;
					}
					
					if (!dateAvailable.isAfter(LocalDate.now())) {
						this.alert("Error", "Please select a date after today.", AlertType.ERROR);
						return;
					}
					
					EmploymentForm employment = createEmploymentFormObject(fullName, currentAddress, contactNumber, emailAddress, education, genderString, dateAvailable, desiredPosition, desiredSalary, authorizedToWork, hasRelatives, relativesExplanation);
					int employmentFormId = employmentFormDao.saveEmploymentForm(employment);
					if (employmentFormId > 0) {
						this.alert("Save", "Successful!", AlertType.INFORMATION);
					} else {
						this.alert("Error", "Failed!", AlertType.ERROR);
					}
				} catch (SQLException ex) {
					System.out.println("Exception occured");
					System.out.println(ex.getMessage());
					System.out.println(ex.getErrorCode());
					System.out.println(ex.getSQLState());
				//	logger.log(Level.SEVERE, exception.getMessage());
					
					
				}
			} else {
				this.alert("Error", "Please complete fields!", AlertType.ERROR);
			}

		});
		Scene scene = new Scene(grid, 1080, 720);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void alert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}

	public EmploymentForm createEmploymentFormObject(String fullName, String currentAddress, String contactNumber, String emailAddress, String education, String gender, LocalDate availabilityDate, String desiredPosition, Double desiredSalary, boolean authorizedToWork, boolean hasRelatives, String relativeExplanation) {
		EmploymentForm employment = new EmploymentForm(fullName, currentAddress, contactNumber, emailAddress, education, gender, availabilityDate, desiredPosition, desiredSalary, authorizedToWork, hasRelatives, relativeExplanation);

		return employment;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
