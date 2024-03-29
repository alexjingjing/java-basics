package hashmap.key_example;

public class Student {
	// It is specified while object creation.
	// Cannot be changed once object is created. No setter for this field.
	private int id;
	private String name;

	public Student(final int id) {
        this.id = id;
    }

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	// Hash code depends only on 'id' which cannot be
	// changed once object is created. So hash code will not change
	// on object's state change
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
