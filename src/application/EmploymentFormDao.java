	package application;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class EmploymentFormDao {
		
		/*
		 * Draft the method for insert, then submits write to db
		 */
		public int saveEmploymentForm(EmploymentForm employment) throws SQLException {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				connection = Database.getDBConnection();
				connection.setAutoCommit(false);
				String query = "INSERT INTO application(full_name, address, phone, email, education, gender, availability_date, desired_position, desired_salary, authorized, relatives, explanation,  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				int counter = 1;
				statement.setString(counter++, employment.getFullName());
				statement.setString(counter++, employment.getCurrentAddress());
				statement.setString(counter++, employment.getContactNumber());
				statement.setString(counter++, employment.getEmailAddress());
				statement.setString(counter++, employment.getEducation());
				statement.setString(counter++, employment.getGender());
				statement.setObject(counter++, employment.getAvailabilityDate());
				statement.setString(counter++, employment.getDesiredPosition());
				statement.setDouble(counter++, employment.getDesiredSalary());
				statement.setBoolean(counter++, employment.isAuthorizedToWork());
				statement.setBoolean(counter++, employment.isHasRelatives());
				statement.setString(counter++, employment.getRelativeExplanation());
				statement.executeUpdate();
				connection.commit();
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			} catch (SQLException exception) {
			//	logger.log(Level.SEVERE, exception.getMessage());
				if (null != connection) {
					connection.rollback();
				}
			} finally {
				if (null != resultSet) {
					resultSet.close();
				}
	
				if (null != statement) {
					statement.close();
				}
	
				if (null != connection) {
					connection.close();
				}
			}
	
			return 0;
		}
	}
