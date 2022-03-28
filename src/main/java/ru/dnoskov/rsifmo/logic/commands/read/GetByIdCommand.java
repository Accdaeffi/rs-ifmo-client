package ru.dnoskov.rsifmo.logic.commands.read;

import java.rmi.RemoteException;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.read.PersonReadServiceProxy;

public class GetByIdCommand extends AbsCommand {

	private final int id;
	
	public GetByIdCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.id = Integer.parseInt(arguments[0]);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person person = readProxy.getPersonById(id);
			
			if (person != null) {
				sb.append(person);
			} else {
				sb.append("Не найдено!");
			}
			
		} 
		catch (PersonWithSuchIdNotFoundException e) {
			sb.append(e.getMessage());
		}
		catch (WorkWithSQLException e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}

}
