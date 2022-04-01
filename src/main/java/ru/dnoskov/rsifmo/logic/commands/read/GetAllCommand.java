package ru.dnoskov.rsifmo.logic.commands.read;

import java.util.List;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.model.Person;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.read.ReadService;

public class GetAllCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		ReadService readProxy = new ReadService();
		try {
			List<Person> persons = readProxy.getAllPersons();
			
			if (persons != null) {
				for (Person p : persons) {
					sb.append(p.toString());
					sb.append("\n");
				}
			} else {
				sb.append("Не найдено!");
			}
			
		} 
		catch (WorkWithSQLException e) {
			sb.append("Ошибка при работе с SQL! ");
			sb.append(e.getMessage());
		} 
		catch (Exception e) {
			sb.append("Внутренняя ошибка! ");
			sb.append(e.getMessage());
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}

}
