package ru.dnoskov.rsifmo.service.read;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.service.RequestSender;
import ru.dnoskov.rsifmo.service.ResponseParser;
import ru.dnoskov.rsifmo.service.model.RestResponse;

public class ReadService {

	public Person getPersonById(int id) throws Exception {
		Person person = null;

		String methodName = new String("/person/"+id);

		RequestSender sender = new RequestSender(methodName, new HashMap<>(), new HashMap<>());
		RestResponse response = sender.doGet();

		if (!String.valueOf(response.getCode()).startsWith("2")) {
			ResponseParser.getException(response.getBody());
		} else {
			person = ResponseParser.getPerson(response.getBody());
		}

		return person;
	}
	
	public List<Person> getAllPersons() throws Exception {
		RequestSender sender = new RequestSender("/all", new HashMap<>(), new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsByName(String name) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("name", name);

		RequestSender sender = new RequestSender("/byName", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsBySurname(String surname) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("surname", surname);

		RequestSender sender = new RequestSender("/bySurname", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsByPatronymic(String patronymic) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("patronymic", patronymic);

		RequestSender sender = new RequestSender("/byPatronymic", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsByAge(int age) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("age", Integer.toString(age));

		RequestSender sender = new RequestSender("/byAge", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsByNameAndSurname(String name, String surname) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("name", name);
		params.put("surname", surname);

		RequestSender sender = new RequestSender("/byNameAndSurname", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsByFullName(String name, String surname, String patronymic) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("name", name);
		params.put("surname", surname);
		params.put("patronymic", patronymic);

		RequestSender sender = new RequestSender("/byFullName", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsYoungerThan(int age) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("age", Integer.toString(age));

		RequestSender sender = new RequestSender("/youngerThan", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	public List<Person> getPersonsOlderThan(int age) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("age", Integer.toString(age));

		RequestSender sender = new RequestSender("/olderThan", params, new HashMap<>());
		RestResponse response = sender.doGet();

		return processResponse(response);
	}
	
	
	private List<Person> processResponse(RestResponse response) throws Exception {
		if (!String.valueOf(response.getCode()).startsWith("2")) {
			ResponseParser.getException(response.getBody());
			return null;
		} else {
			return ResponseParser.getPersons(response.getBody());
		}
	}

}
