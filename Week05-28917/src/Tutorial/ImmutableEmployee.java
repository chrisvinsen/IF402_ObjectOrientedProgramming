package Tutorial;

public class ImmutableEmployee {
	
	private final int id;
	private final String name;
	
	public ImmutableEmployee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "ImmutableEmployee{"+
				"id=" + id + 
				", name='" + name + "'}";
	}

}
