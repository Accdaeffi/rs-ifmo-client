package ru.dnoskov.rsifmo.logic.commands.read;

import java.util.List;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.read.ReadService;

public class GetByNameCommand extends AbsCommand {
	
	private final String name;

	public GetByNameCommand(String args) throws IncorrectNumberOfArgumentsException {
		if (args == null) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.name = arguments[0];
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		ReadService readProxy = new ReadService();
		try {
			List<Person> persons = readProxy.getPersonsByName(name);
			
			if (persons != null && !persons.isEmpty()) {
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
		catch (ThrottlingException e) {
			sb.append("Слишком много запросов, попробуйте позже!");
		}
		catch (Exception e) {
			sb.append("Внутренняя ошибка! ");
			sb.append(e.getMessage());
			e.printStackTrace();
		}
		
		return sb.toString();
	}


}
