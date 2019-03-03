package challenge.questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.opencsv.CSVReader;

import challenge.questions.model.Contact;
import challenge.questions.model.Gender;

public class Loader {
	
    private DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yy");

	public List<Contact> readFile(String filename) throws FileNotFoundException, IOException, ParseException {
		List<Contact> records = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader(filename));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        records.add(loadLine(values));
		    }
		}
		
		return records;
	}
	
	private Contact loadLine(String[] line) throws ParseException {
		if (line.length == 3) {
			String name = line[0].trim();
			Gender gender = Gender.fromString(line[1].trim());
		    DateTime dateOfBirth = DateTime.parse(line[2].trim(), dtf);
			return new Contact(name, gender, dateOfBirth);
		} else {
			throw new IllegalStateException(String.format("line incorrect size : %s", (Object[])line));
		}
		
	}

}
