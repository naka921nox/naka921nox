package chapter14.before.com.objectmentor.utilities.getops;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import chapter14.before.com.objectmentor.utilities.ArgsException;
import chapter14.before.com.objectmentor.utilities.ArgumentMarshaler;
import chapter14.before.com.objectmentor.utilities.BooleanArgumentMarshaler;
import chapter14.before.com.objectmentor.utilities.DoubleArgumentMarshaler;
import chapter14.before.com.objectmentor.utilities.IntegerArgumentMarshaler;
import chapter14.before.com.objectmentor.utilities.StringArgumentMarshaler;

public class Args {
	private String schema;
	private boolean valid = true;
	private Set<Character> unexpectedArguments = new TreeSet<>();
	private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();
	private Set<Character> argsFound = new HashSet<>();
	private Iterator<String> currentArgument;
	private char errorArgument = '\0';
	private String errorParamater = "TILT";
	private ArgsException.ErrorCode errorCode = ArgsException.ErrorCode.OK;
	private int numberOfArguments = 0;
	private List<String> argsList;

	public Args(String schema, String[] args) throws ArgsException {
		this.schema = schema;
		argsList = Arrays.asList(args);
		valid = parse();
	}

	public boolean isValid() {
		return valid;
	}

	private boolean parse() throws ArgsException {
		if (schema.length() == 0 && argsList.size() == 0) {
			return true;
		}
		parseSchema();
		try {
			parseArguments();
		} catch (ArgsException e) {
		}
		return valid;
	}

	private boolean parseSchema() throws ArgsException {
		for (String element : schema.split(",")) {
			if (element.length() > 0) {
				String trimmedElement = element.trim();
				parseSchemaElement(trimmedElement);
			}
		}
		return true;
	}

	private void parseSchemaElement(String element) throws ArgsException {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		if (elementTail.length() == 0) {
			marshalers.put(elementId, new BooleanArgumentMarshaler());
		} else if (elementTail.equals("*")) {
			marshalers.put(elementId, new StringArgumentMarshaler());
		} else if (elementTail.equals("#")) {
			marshalers.put(elementId, new IntegerArgumentMarshaler());
		} else if (elementTail.equals("##")) {
			marshalers.put(elementId, new DoubleArgumentMarshaler());
		} else {
			throw new ArgsException(String.format("引数: %c の書式が不正です:%s.",
					elementId, elementTail));
		}
	}

	private void validateSchemaElementId(char elementId) throws ArgsException {
		if (!Character.isLetter(elementId)) {
			throw new ArgsException(
					"不正な文字列" + elementId + "が、次の書式に含まれています:" + schema);
		}
	}

	private boolean parseArguments() throws ArgsException {
		for (currentArgument = argsList.iterator(); currentArgument
				.hasNext();) {
			String arg = currentArgument.next();
			parseArgument(arg);
		}
		return true;
	}

	private void parseArgument(String arg) throws ArgsException {
		if (arg.startsWith("-")) {
			parseElements(arg);
		}
	}

	private void parseElements(String arg) throws ArgsException {
		for (int i = 1; i < arg.length(); i++) {
			parseElement(arg.charAt(i));
		}
	}

	private void parseElement(char argChar) throws ArgsException {
		if (setArgument(argChar)) {
			argsFound.add(argChar);
		} else {
			unexpectedArguments.add(argChar);
			errorCode = ArgsException.ErrorCode.UNEXPECTED_ARGUMENT;
			valid = false;
		}
	}

	private boolean setArgument(char argChar) throws ArgsException {
		ArgumentMarshaler m = marshalers.get(argChar);
		if (m == null) {
			return false;
		}
		try {
			m.set(currentArgument);
			return true;
		} catch (ArgsException e) {
			valid = false;
			errorArgument = argChar;
			throw e;
		}
	}

	public int cardinality() {
		return numberOfArguments;
	}

	public String usage() {
		if (schema.length() > 0) {
			return "-[" + schema + "]";
		} else {
			return "";
		}
	}

	public String errorMessage() {
		if (unexpectedArguments.size() > 0) {
			return unexpectedArgumentMessage();
		} else {
			return "";
		}
	}

	private String unexpectedArgumentMessage() {
		StringBuffer message = new StringBuffer("引数 - ");
		for (char c : unexpectedArguments) {
			message.append(c);
		}
		message.append("　は対象外です。");
		return message.toString();
	}

	public boolean getBoolean(char arg) {
		ArgumentMarshaler am = marshalers.get(arg);
		boolean b = false;
		try {
			b = am != null && (Boolean) am.get();
		} catch (ClassCastException e) {
			b = false;
		}
		return b;
	}

	public String getString(char arg) {
		ArgumentMarshaler am = marshalers.get(arg);
		return am == null ? "" : (String) am.get();
	}

	public boolean has(char arg) {
		return argsFound.contains(arg);
	}
}
