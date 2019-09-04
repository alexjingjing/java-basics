package hashmap;

import java.util.HashMap;

import hashmap.key_example.MutableKey;

public class MutableKeyTest {
	
	public static void main(String[] args) {
		HashMap<MutableKey, String> map = new HashMap<>();
		
		MutableKey key = new MutableKey(10, 20);
		map.put(key, "30");
		System.out.println(map.get(key));
		key.setI(2);
		System.out.println(map.get(key));
	}
}
