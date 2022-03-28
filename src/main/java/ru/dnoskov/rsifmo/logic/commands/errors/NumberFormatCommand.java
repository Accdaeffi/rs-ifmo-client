package ru.dnoskov.rsifmo.logic.commands.errors;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;

public class NumberFormatCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неправильный формат аргументов!";
	}

}
