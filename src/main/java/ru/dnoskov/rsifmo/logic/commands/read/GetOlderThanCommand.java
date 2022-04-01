package ru.dnoskov.rsifmo.logic.commands.read;

import java.util.List;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.read.ReadService;

public class GetOlderThanCommand extends AbsCommand {

	private final int age;
	
	public GetOlderThanCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.age = Integer.parseInt(arguments[0]);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		ReadService readProxy = new ReadService();
		try {
			List<Person> persons = readProxy.getPersonsOlderThan(age);
			
			if (persons != null && !persons.isEmpty()) {
				for (Person p : persons) {
					sb.append(p.toString());
					sb.append("\n");
				}
			} else {
				sb.append("Не найдено!");
			}
			
		} 
		catch (IncorrectArgumentException e) {
			sb.append(e.getMessage());
		}
		catch (WorkWithSQLException e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getMessage());
		}
		catch (Exception e) {
			sb.append("Внутренняя ошибка! ");
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}

}
