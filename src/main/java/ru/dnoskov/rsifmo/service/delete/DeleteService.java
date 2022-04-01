package ru.dnoskov.rsifmo.service.delete;

import java.util.HashMap;

import ru.dnoskov.rsifmo.service.RequestSender;
import ru.dnoskov.rsifmo.service.ResponseParser;
import ru.dnoskov.rsifmo.service.model.RestResponse;

public class DeleteService {

	public boolean deletePerson(int id) throws Exception {
		String methodName = new String("/deletePerson/"+id);

		RequestSender sender = new RequestSender(methodName, new HashMap<>(), new HashMap<>());

		RestResponse response = sender.doDelete();

		if (!String.valueOf(response.getCode()).startsWith("2")) {
			ResponseParser.getException(response.getBody());
			return false;
		} else {
			return true;
		}
	}

}
