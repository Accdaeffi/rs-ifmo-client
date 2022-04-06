package ru.dnoskov.rsifmo.logic.commands.create;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.EmptyArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.IncorrectArgumentException;
import ru.dnoskov.rsifmo.model.exceptions.ThrottlingException;
import ru.dnoskov.rsifmo.model.exceptions.WorkWithSQLException;
import ru.dnoskov.rsifmo.service.create.CreateService;

public class CreateByFullNameAndAgeCommand extends AbsCommand {

	private final Person personToAdd;
	
	public CreateByFullNameAndAgeCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 4) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		String name = arguments[0].trim();
		String surname = arguments[1].trim();
		String patronymic = arguments[2].trim();
		int age = Integer.parseInt(arguments[3]);
		
		personToAdd = new Person(name, surname, patronymic, age);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		CreateService createProxy = new CreateService();
		try {
			Person result = createProxy.createPerson(personToAdd);
			
			sb.append(String.format("Успешно добавлено! Id нового объект - %d.", result.getId())); 
		}
		catch (IncorrectArgumentException | EmptyArgumentException e) {
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
			sb.append("Unknown exception! ");
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}

}
