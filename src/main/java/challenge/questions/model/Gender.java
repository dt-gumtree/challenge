package challenge.questions.model;

public enum Gender {

	MALE("Male"),
	FEMALE("Female"),
	OTHER("");
	
	private String text;
	
	Gender(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
    public static Gender fromString(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.getText().equalsIgnoreCase(text)) {
                return gender;
            }
        }
        return Gender.OTHER;
    }
	
}
