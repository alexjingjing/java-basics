package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HashMap在put、resize、remove的时候都无法保证线程安全。
 * 在put的时候，可能线程A、B都新建了头结点，但线程B可能会覆盖A的头结点
 * 
 * @author Siming.Liu
 *
 */
public class HashMapTest {
	
	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	public static final Map<String, String> hashMap = new HashMap<String, String>();

	public static void main(String[] args) throws InterruptedException {
		// 非线程安全
		// put的时候
		final Map<String, String> firstHashMap = new HashMap<String, String>();
		// 线程安全
//		final Map<String, String> firstHashMap = Collections.synchronizedMap(new HashMap<String, String>());
//		final ConcurrentHashMap<String, String> firstHashMap = new ConcurrentHashMap<String, String>();

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					firstHashMap.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int j = 1000; j < 2000; j++) {
					firstHashMap.put(String.valueOf(j), String.valueOf(j));
				}
			}
		};

		t1.start();
		t2.start();

		while (Thread.activeCount() > 1) { // 保证前面的线程都执行完
			Thread.yield();
		}
		
		System.out.println(hash(123));

		for (int k = 0; k < 2000; k++) {
			if (!String.valueOf(k).equals(firstHashMap.get(String.valueOf(k)))) {
				System.err.println(String.valueOf(k) + ":" + firstHashMap.get(String.valueOf(k)));
			}
		}

		for (Entry<String, String> entry : firstHashMap.entrySet()) {
			System.out.println("key>>>>:" + entry.getKey() + " value>>>>:" + entry.getValue());
		}
	}
}
