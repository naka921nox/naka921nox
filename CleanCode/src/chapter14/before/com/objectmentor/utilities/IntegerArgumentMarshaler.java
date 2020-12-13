package chapter14.before.com.objectmentor.utilities;

import java.util.Iterator;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
	private int intValue = 0;

	@Override
	public void set(Iterator<String> currentArgument) throws ArgsException {
		String parameter = null;
		try {
			parameter = currentArgument.next();
			intValue = Integer.parseInt(parameter);
		} catch (NumberFormatException e) {
			throw new ArgsException();
		}
	}

	@Override
	public Object get() {
		return intValue;
	}

}
