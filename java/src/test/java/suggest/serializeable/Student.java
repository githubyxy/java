package suggest.serializeable;

import java.io.Serializable;

public class Student extends Person {
	/**
	 * 
	 */
	public String name2 = "问问";
	
	public Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
