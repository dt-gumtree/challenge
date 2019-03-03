package challenge.questions;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.joda.time.Days;
import org.joda.time.Interval;

import challenge.questions.model.Contact;
import challenge.questions.model.Gender;

public class Questions {

	/**
	 * How many males are in the address book?
	 * @param contacts
	 */
	public long question1(List<Contact> contacts) {
		return contacts.stream()
		.filter(c -> c.getGender().equals(Gender.MALE))
		.count();
	}
	
	/**
	 * Who is the oldest person in the address book?
	 * @param contacts
	 */
	public Optional<Contact> question2(List<Contact> contacts) {
		return contacts.stream()
				.min(Comparator.comparing(Contact::getDateOfBirth));
	}
	
	/**
	 * How many days older is Bill than Paul?
	 * @param contacts
	 */
	public Integer question3(List<Contact> contacts) {
		Optional<Contact> bill = contacts.stream()
				.filter(c -> c.getName().contains("Bill"))
				.findFirst();
		
		Optional<Contact> paul = contacts.stream()
				.filter(c -> c.getName().contains("Paul"))
				.findFirst();
		
		if (bill.isPresent() && paul.isPresent()) {
			Interval interval = new Interval(bill.get().getDateOfBirth(), paul.get().getDateOfBirth());
			return Days.daysBetween(interval.getStart(), interval.getEnd()).getDays();
		} else {
			throw new IllegalStateException("bill and/or paul not found");
		}
	}
}
