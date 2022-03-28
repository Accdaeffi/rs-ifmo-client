package ru.dnoskov.rsifmo.logic.commands.update;

import java.rmi.RemoteException;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.update.PersonUpdateServiceProxy;

public class UpdateByAllFieldsCommand extends AbsCommand {

	private final Person personToUpdate;
	
	public UpdateByAllFieldsCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 5) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		int id = Integer.parseInt(arguments[0]);
		String name = arguments[1].trim();
		String surname = arguments[2].trim();
		String patronymic = arguments[3].trim();
		int age = Integer.parseInt(arguments[4]);
		
		personToUpdate = new Person(id, name, surname, patronymic, age);
	}
	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonUpdateServiceProxy updateProxy = new PersonUpdateServiceProxy();
		try {
			boolean result = updateProxy.updatePerson(personToUpdate);
			if (result) {
				sb.append("Обновлено успешно!");
			} else {
				sb.append("Ошибка обновления!");
			}
			
		} 
		catch (IncorrectArgumentException | EmptyArgumentException e) {
			sb.append(e.getMessage());
		}
		catch (WorkWithSQLException e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}

}
