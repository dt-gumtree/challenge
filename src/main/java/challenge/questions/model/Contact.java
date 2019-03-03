package challenge.questions.model;

import org.joda.time.DateTime;

public class Contact {

	private String name;
	private Gender gender;
	private DateTime dateOfBirth;
	
	public Contact(String name, Gender gender, DateTime dateOfBirth) {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
