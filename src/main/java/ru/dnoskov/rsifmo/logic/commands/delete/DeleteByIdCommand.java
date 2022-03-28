package ru.dnoskov.rsifmo.logic.commands.delete;

import java.rmi.RemoteException;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;
import ru.dnoskov.rsifmo.logic.exceptions.IncorrectNumberOfArgumentsException;
import ru.dnoskov.rsifmo.model.exceptions.*;
import ru.dnoskov.rsifmo.service.delete.PersonDeleteServiceProxy;

public class DeleteByIdCommand extends AbsCommand {

	private final int id;
	
	public DeleteByIdCommand(String args) throws IncorrectNumberOfArgumentsException {
		String[] arguments = args.split(" ");
		
		if (arguments.length != 1) {
			throw new IncorrectNumberOfArgumentsException();
		}
		
		this.id = Integer.parseInt(arguments[0]);
	}

	@Override
	public String executeCommand() {
		StringBuilder sb = new StringBuilder();
		
		PersonDeleteServiceProxy deleteProxy = new PersonDeleteServiceProxy();
		try {
			boolean result = deleteProxy.deletePerson(id);
			if (result) {
				sb.append("Удалено успешно!");
			} else {
				sb.append("Ошибка удаления!");
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
			sb.append("Unknown exception! ");
			sb.append(e.getMessage());
		}
		
		return sb.toString();
	}

}
