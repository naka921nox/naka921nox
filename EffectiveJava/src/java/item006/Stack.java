package java.item006;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.TimeZone;
/* 項目006：廃れたオブジェクト参照を取り除く */

// このクラスではpushした要素をpopしてもGCが走らずオブジェクトの"廃れた参照"が残り続けるため
// メモリーリークになる危険性がある。
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	// 要素を追加
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	// 要素を削除:悪い例
	// popされた後の size 以上に位置する要素は二度と再利用されない。
	// クライアント側で参照を破棄していても、elements 要素からそのオブジェクトへの参照が残っているので GC されない。
	@Deprecated
	public Object badPop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return elements[size--];
	}

	// 要素を削除:nullを設定する例
	public Object goodPop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Object result = elements[size--];
		// 廃れた参照を取り除く
		elements[size] = null;
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}