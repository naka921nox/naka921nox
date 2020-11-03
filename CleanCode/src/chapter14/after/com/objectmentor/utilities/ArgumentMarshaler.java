package chapter14.after.com.objectmentor.utilities;

import java.util.Iterator;

public interface ArgumentMarshaler {
	void set(Iterator<String> currentArgument) throws ArgsException;
}
