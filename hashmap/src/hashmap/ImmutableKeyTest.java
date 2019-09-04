package hashmap;

import java.util.HashMap;

import hashmap.key_example.Student;

public class ImmutableKeyTest {

	public static void main(String[] args) {
		HashMap<Student, String> map = new HashMap<>();
		
		Student student = new Student(1);
		student.setName("lilei");
		map.put(student, "你好");
		System.out.println(map.get(student));
		// 改变name属性不影响hashCode计算
		student.setName("hanmeimei");
		System.out.println(map.get(student));
	}

}
