package chapter14.after.com.objectmentor.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter14.after.com.objectmentor.utilities.ArgsException.ErrorCode;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

	private ArrayList<String> stringArrayValue = new ArrayList<>();

	public void set(Iterator<String> currentArgument) throws ArgsException {
		try {
			while (currentArgument.hasNext()) {
				stringArrayValue.add(currentArgument.next());
			}
		} catch (NoSuchElementException e) {
			throw new ArgsException(ErrorCode.INVALID_ARGUMENT_FORMAT, stringArrayValue.toString());
		}
	}

	public static String[] getValue(ArgumentMarshaler am) {
		if (am != null && am instanceof StringArrayArgumentMarshaler) {
			return ((StringArrayArgumentMarshaler)am).stringArrayValue.toArray(new String[0]);
		} else {
			return new String[0];
		}
	}

}
