package chapter14.before.com.objectmentor.utilities.getops;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import chapter14.after.com.objectmentor.utilities.ArgsException;
import chapter14.before.com.objectmentor.utilities.ArgumentMarshaler;

public class Args {
	private String schema;
	private String[] args;
	private boolean valid;
	private Set<Character> unexpectedArguments = new TreeSet<>();
	private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();
	private Set<Character> argsFound = new HashSet<>();
	private int currentArgument;
	private char errorArgument = '\0';
	private ErrorCode errorCode = ErrorCode.OK;
	private int numberOfArguments = 0;

	enum ErrorCode {
		OK, MISSING_STRING
	}

	public Args(String schema, String[] args) throws ParseException {
		this.schema = schema;
		this.args = args;
		valid = parse();
	}

	public boolean isValid() {
		return valid;
	}

	private boolean parse() throws ParseException {
		if (schema.length() == 0 && args.length == 0) {
			return true;
		}
		parseSchema();
		parseArguments();
		return valid;
	}

	private boolean parseSchema() throws ParseException {
		for (String element : schema.split(",")) {
			if (element.length() > 0) {
				String trimmedElement = element.trim();
				parseSchemaElement(trimmedElement);
			}
		}
		return true;
	}

	private void parseSchemaElement(String element) throws ParseException {
		char elementId = element.charAt(0);
		String elementTail = element.substring(1);
		validateSchemaElementId(elementId);
		if (isBooleanSchemaElement(elementTail)) {
			marshalers.put(elementId, new BooleanArgumentMarshaler());
		} else if (isStringSchemaElement(elementTail)) {
			marshalers.put(elementId, new StringArgumentMarshaler());
		}
	}

	private void validateSchemaElementId(char elementId) throws ParseException {
		if (!Character.isLetter(elementId)) {
			throw new ParseException(
					"不正な文字列" + elementId + "が、次の書式に含まれています:" + schema, 0);
		}
	}

	private boolean isStringSchemaElement(String elementTail) {
		return elementTail.equals("*");
	}

	private boolean isBooleanSchemaElement(String elementTail) {
		return elementTail.length() == 0;
	}

	private void parseBooleanSchemaElement(String element) {
		BooleanArgumentMarshaler m = new BooleanArgumentMarshaler();
		char c = element.charAt(0);
		if (Character.isLetter(c)) {
			marshalers.put(c, m);
		}
	}

	private boolean parseArguments() {
		for (currentArgument = 0; currentArgument < args.length; currentArgument++) {
			String arg = args[currentArgument];
			parseArgument(arg);
		}
		return true;
	}

	private void parseArgument(String arg) {
		if (arg.startsWith("-")) {
			parseElements(arg);
		}
	}

	private void parseElements(String arg) {
		for (int i = 1; i < arg.length(); i++) {
			parseElement(arg.charAt(i));
		}
	}

	private void parseElement(char argChar) {
		ArgumentMarshaler m = marshalers.get(argChar);
		if (m instanceof BooleanArgumentMarshaler) {
			numberOfArguments++;
			setBooleanArg(m);
		} else {
			unexpectedArguments.add(argChar);
		}
	}

	private boolean setArgument(char argChar) throws ArgsException {
		ArgumentMarshaler m = marshalers.get(argChar);
		try {
			if (m instanceof BooleanArgumentMarshaler) {
				setBooleanArg(m);
			} else if (isStringArg(m)) {
				setStringArg(argChar, "");
			} else {
				return false;
			}
		} catch (ArgsException e) {
			valid = false;
			errorArgument = argChar;
			throw e;
		}
		return true;
	}

	private void setStringArg(char argChar, String s) throws ArgsException {
		currentArgument++;
		try {
			marshalers.get(argChar).set(args[currentArgument]);
		} catch (ArrayIndexOutOfBoundsException e) {
			valid = false;
			errorArgument = argChar;
			errorCode = ErrorCode.MISSING_STRING;
			throw new ArgsException("");
		}
	}

	private boolean isStringArg(ArgumentMarshaler m) {
		return m instanceof StringArgumentMarshaler;
	}

	private void setBooleanArg(ArgumentMarshaler m) {
		m.set("true");
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

	private class BooleanArgumentMarshaler extends ArgumentMarshaler {
		private boolean booleanValue = false;
		@Override
		public void set(String s) {
			booleanValue = true;
		}

		@Override
		public Object get() {
			return booleanValue;
		}

	}

	private class StringArgumentMarshaler extends ArgumentMarshaler {
		private String stringValue = null;

		@Override
		public void set(String s) {
			stringValue = s;
		}

		@Override
		public Object get() {
			return stringValue;
		}
	}

	private class IntegarArgumentMarshaler extends ArgumentMarshaler {

		@Override
		public void set(String s) {
		}

		@Override
		public Object get() {
			return null;
		}
	}
}
