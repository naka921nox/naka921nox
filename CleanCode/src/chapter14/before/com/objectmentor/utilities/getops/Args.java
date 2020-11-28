package chapter14.before.com.objectmentor.utilities.getops;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Args {
	private String schema;
	private String[] args;
	private boolean valid;
	private Set<Character> unexpectedArguments = new TreeSet<>();
	private Map<Character, ArgumentMarshaler> booleanArgs = new HashMap<>();
	private Map<Character, String> stringArgs = new HashMap<>();
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
			parseBooleanSchemaElement(elementId);
		} else if (isStringSchemaElement(elementTail)) {
			parseStringSchemaElement(elementId);
		}
	}

	private void validateSchemaElementId(char elementId) throws ParseException {
		if (!Character.isLetter(elementId)) {
			throw new ParseException("不正な文字列" + elementId + "が、次の書式に含まれています:" + schema, 0);
		}
	}

	private void parseStringSchemaElement(char elementId) {
		stringArgs.put(elementId, "");
	}

	private boolean isStringSchemaElement(String elementTail) {
		return elementTail.equals("*");
	}

	private boolean isBooleanSchemaElement(String elementTail) {
		return elementTail.length() == 0;
	}

	private void parseBooleanSchemaElement(char elementId) {
		booleanArgs.put(elementId, new BooleanArgumentMarshaler());
	}

	private void parseBooleanSchemaElement(String element) {
		char c = element.charAt(0);
		if (Character.isLetter(c)) {
			booleanArgs.put(c, new BooleanArgumentMarshaler());
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
		if (isBoolean(argChar)) {
			numberOfArguments++;
			setBooleanArg(argChar, true);
		} else {
			unexpectedArguments.add(argChar);
		}
	}

	private boolean setArgument(char argChar) {
		boolean set = true;
		if (isBoolean(argChar)) {
			setBooleanArg(argChar, true);
		} else if (isString(argChar)) {
			setStringArg(argChar, "");
		} else {
			set = false;
		}
		return set;
	}

	private void setStringArg(char argChar, String s) {
		currentArgument++;
		try {
			stringArgs.put(argChar, args[currentArgument]);
		} catch (ArrayIndexOutOfBoundsException e) {
			valid = false;
			errorArgument = argChar;
			errorCode = ErrorCode.MISSING_STRING;
		}
	}

	private boolean isString(char argChar) {
		return stringArgs.containsKey(argChar);
	}

	private void setBooleanArg(char argChar, boolean value) {
		booleanArgs.get(argChar).setBoolean(value);
	}

	private boolean isBoolean(char argChar) {
		return booleanArgs.containsKey(argChar);
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
		return failIfNull(booleanArgs.get(arg).getBoolean());
	}

	private boolean failIfNull(Boolean b) {
		return b == null ? false : b;
	}

	public String getString(char arg) {
		return failIfNull(stringArgs.get(arg));
	}

	private String failIfNull(String s) {
		return s == null ? "" : s;
	}

	public boolean has(char arg) {
		return argsFound.contains(arg);
	}

	private class ArgumentMarshaler {

		private boolean booleanValue = false;

		public void setBoolean(boolean value) {
			booleanValue = value;
		}

		public boolean getBoolean() {
			return booleanValue;
		}
	}

	private class BooleanArgumentMarshaler extends ArgumentMarshaler {
	}

	private class StringArgumentMarshaler extends ArgumentMarshaler {
	}

	private class IntegarArgumentMarshaler extends ArgumentMarshaler {
	}
}
