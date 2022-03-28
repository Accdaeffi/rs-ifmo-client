package ru.dnoskov.rsifmo.service.create;

import java.util.HashMap;
import java.util.Map;

import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.EmptyArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.IncorrectArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.PersonWithSuchIdNotFoundException;
import ru.dnoskov.rsifmo.model.exceptions.WorkWithSQLException;
import ru.dnoskov.rsifmo.service.RequestSender;
import ru.dnoskov.rsifmo.service.model.RestResponse;

public class CreateService {

	public Person createPerson(String name, String surname, String patronymic, int age) throws Exception {
		Person returnedPerson = null;

		String methodName = "/createPerson";

		Map<String, Object> bodyParts = new HashMap<String, Object>();

		bodyParts.put("name", name);
		bodyParts.put("surname", surname);
		bodyParts.put("patronymic", patronymic);
		bodyParts.put("age", age);

		RequestSender sender = new RequestSender(methodName, new HashMap<>(), bodyParts);

		RestResponse response = sender.doPost();

		if ((response.getCode() % 100) != 2) {
			String message = (String) response.getResponseBody().get("message");
			String exceptionType = (String) response.getResponseBody().get("exception");

			switch (exceptionType) {
			case "EmptyArgumentException":
				throw new EmptyArgumentException(message);
			case "IncorrectArgumentException":
				throw new IncorrectArgumentException(message);
			case "WorkWithSQLException":
				throw new WorkWithSQLException(message);
			case "PersonWithSuchIdNotFoundException":
				throw new PersonWithSuchIdNotFoundException(message);
			default:
				throw new Exception("Unknown exception with message " + message);
			}
		} else {
			int returnedId = (int) response.getResponseBody().get("id");
			String returnedName = (String) response.getResponseBody().get("name");
			String returnedSurname = (String) response.getResponseBody().get("surname");
			String returnedPatronymic = (String) response.getResponseBody().get("patronymic");
			int returnedAge = (int) response.getResponseBody().get("age");

			returnedPerson = new Person(returnedId, returnedName, returnedSurname, returnedPatronymic, returnedAge);
		}

		return returnedPerson;
	}

}
