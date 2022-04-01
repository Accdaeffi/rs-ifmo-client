package ru.dnoskov.rsifmo.service.update;

import java.util.HashMap;
import java.util.Map;

import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.service.RequestSender;
import ru.dnoskov.rsifmo.service.ResponseParser;
import ru.dnoskov.rsifmo.service.model.RestResponse;

public class UpdateService {

	public boolean updatePerson(Person person) throws Exception {
		String methodName = "/updatePerson";

		Map<String, Object> bodyParts = new HashMap<String, Object>();

		bodyParts.put("id", person.getId());
		bodyParts.put("name", person.getName());
		bodyParts.put("surname", person.getSurname());
		bodyParts.put("patronymic", person.getPatronymic());
		bodyParts.put("age", person.getAge());

		RequestSender sender = new RequestSender(methodName, new HashMap<>(), bodyParts);

		RestResponse response = sender.doPut();

		if (!String.valueOf(response.getCode()).startsWith("2")) {
			ResponseParser.getException(response.getBody());
			return false;
		} else {
			return true;
		}
	}

}
