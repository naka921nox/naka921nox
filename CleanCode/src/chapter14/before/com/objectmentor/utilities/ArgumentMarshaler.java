package chapter14.before.com.objectmentor.utilities;
import java.util.Iterator;

import chapter14.after.com.objectmentor.utilities.ArgsException;

public interface ArgumentMarshaler {

	void set(Iterator<String> currentArgument) throws ArgsException;
	Object get();

}
