package ru.dnoskov.rsifmo.logic.commands.errors;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;

public class IncorrectNumberOfArgumentsCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неправильное количество аргументов!";
	}

}
