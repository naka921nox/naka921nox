package chapter14.before.com.objectmentor.utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter14.before.com.objectmentor.utilities.ArgsException.ErrorCode;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
	private double doubleValue = 0;

	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			doubleValue = Double.parseDouble(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(ErrorCode.MISSING_DOUBLE);
		} catch (NumberFormatException e) {
			throw new ArgsException(ErrorCode.INVALID_DOUBLE, parameter);
		}
	}

	@Override
	public Object get() {
		return doubleValue;
	}
}
