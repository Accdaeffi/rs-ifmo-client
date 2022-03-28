package ru.dnoskov.rsifmo.logic.commands.read;

import java.rmi.RemoteException;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.read.PersonReadServiceProxy;

public class GetByPatronymicCommand extends AbsCommand {

	private final String patronymic;
	
	public GetByPatronymicCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.patronymic = arguments[0];
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonReadServiceProxy readProxy = new PersonReadServiceProxy();
		try {
			Person[] persons = readProxy.getPersonsByPatronymic(patronymic);
			
			if (persons != null) {
				for (Person p : persons) {
					sb.append(p.toString());
					sb.append("\n");
				}
			} else {
				sb.append("Не найдено!");
			}
			
		} 
		catch (EmptyArgumentException e) {
			sb.append(e.getMessage());
		}
		catch (WorkWithSQLException e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getMessage());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			sb.append("Ошибка соединения!");
		}
		
		return sb.toString();
	}

}
