package ru.dnoskov.rsifmo.logic.commands.errors;

import ru.dnoskov.rsifmo.logic.commands.AbsCommand;

public class UnknownCommand extends AbsCommand {

	@Override
	public String executeCommand() {
		return "Неизвестная команда!";
	}

}
