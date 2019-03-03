package challenge.questions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import challenge.questions.model.Contact;


public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, ParseException
    {
        Loader loader = new Loader();
        Questions questions = new Questions();
        
        List<Contact> contacts = loader.readFile("/Users/dunx/eclipse-workspace/questions/src/main/resources/AddressBook");
        System.out.println(contacts);
        
        long numMales = questions.question1(contacts);
        Optional<Contact> oldest = questions.question2(contacts);
        Integer billPaulDaysDifference = questions.question3(contacts);
        
        System.out.println("Q1 Answer: " + String.valueOf(numMales));
        System.out.println("Q2 Answer: " + oldest.get().getName());
        System.out.println("Q3 Answer: " + String.valueOf(billPaulDaysDifference) + " days");

    }
}
