package chapter14.before.com.objectmentor.utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter14.before.com.objectmentor.utilities.ArgsException.ErrorCode;

public class StringArgumentMarshaler implements ArgumentMarshaler {
	private String stringValue = "";

	@Override
	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			stringValue = currentArgument.next();
		} catch (NoSuchElementException e) {
				throw new ArgsException(ErrorCode.MISSING_STRING);
		}
	}

	@Override
	public Object get() {
		return stringValue;
	}

}
