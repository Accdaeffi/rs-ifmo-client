package ru.dnoskov.rsifmo;

import java.util.Scanner;

import ru.dnoskov.rsifmo.logic.CommandParser;
import ru.dnoskov.rsifmo.logic.commands.AbsCommand;

public class RsIfmoClient {

	public static void main(String[] args) {
		
		CommandParser parser = CommandParser.getParser();
		
		while (true) {
		
			Scanner in = new Scanner(System.in);   
	    	String input = in.nextLine();
	    	
	    	if (input.equals("/exit")) {
	    		break;
	    	}
	    	
	    	AbsCommand command = parser.parseMessage(input);
	    	
	    	System.out.println(command.executeCommand());
	    
		}
	}

}
