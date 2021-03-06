package ru.dnoskov.rsifmo.service.create;

import java.util.HashMap;
import java.util.Map;

import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.service.RequestSender;
import ru.dnoskov.rsifmo.service.ResponseParser;
import ru.dnoskov.rsifmo.service.model.RestResponse;

public class CreateService {

	public Person createPerson(Person person) throws Exception {
		Person returnedPerson = null;

		String methodName = "/createPerson";

		Map<String, Object> bodyParts = new HashMap<String, Object>();

		bodyParts.put("name", person.getName());
		bodyParts.put("surname", person.getSurname());
		bodyParts.put("patronymic", person.getPatronymic());
		bodyParts.put("age", person.getAge());

		RequestSender sender = new RequestSender(methodName, new HashMap<>(), bodyParts);

		RestResponse response = sender.doPost();

		if (!String.valueOf(response.getCode()).startsWith("2")) {
			ResponseParser.getException(response.getBody());
		} else {
			returnedPerson = ResponseParser.getPerson(response.getBody());
		}

		return returnedPerson;
	}

}
