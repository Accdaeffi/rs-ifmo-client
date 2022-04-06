package ru.dnoskov.rsifmo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.EmptyArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.IncorrectArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.PersonWithSuchIdNotFoundException;
import ru.dnoskov.rsifmo.model.exceptions.ThrottlingException;
import ru.dnoskov.rsifmo.model.exceptions.WorkWithSQLException;

public class ResponseParser {
	
	public static List<Person> getPersons(Document doc) {
		List<Person> persons = new ArrayList<>();
		
        List<Document> personsDocuments =
        		doc.getList("persons", Document.class);

        for (Document d : personsDocuments) {
        	persons.add(getPerson(d));
        }
		
		return persons;
	}

	public static Person getPerson(Document doc) {
		Person person = Person.builder()
				.id(doc.getInteger("id"))
				.name(doc.getString("name"))
				.surname(doc.getString("surname"))
				.patronymic(doc.getString("patronymic"))
				.age(doc.getInteger("age"))
				.build();
		
		return person;
	}
	
	public static void getException(Document doc) throws Exception {
		String message = doc.getString("message");
		String exceptionType = doc.getString("exception");

		switch (exceptionType) {
			case "EmptyArgumentException":
				throw new EmptyArgumentException(message);
			case "IncorrectArgumentException":
				throw new IncorrectArgumentException(message);
			case "WorkWithSQLException":
				throw new WorkWithSQLException(message);
			case "PersonWithSuchIdNotFoundException":
				throw new PersonWithSuchIdNotFoundException(message);
			case "ThrottlingException": 
				throw new ThrottlingException(message);
			default:
				throw new Exception("Unknown exception with message " + message);
		}
	}
	
	

}
