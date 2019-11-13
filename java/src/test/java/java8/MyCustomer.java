package java8;

import java.util.List;
import java.util.function.Consumer;

import suggest.serializeable.Student;

public class MyCustomer implements Consumer<List<Student>> {

	@Override
	public void accept(List<Student> list) {
		// TODO Auto-generated method stub
		list.remove(0);
	}

}
