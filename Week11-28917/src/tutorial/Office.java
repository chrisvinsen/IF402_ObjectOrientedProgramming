package tutorial;

import java.util.List;
import java.util.ArrayList;

public class Office {

	private List<Employee> employees = new ArrayList<>();
	private List<EmployeeAddedListener> listeners = new ArrayList<>();
	
	public void addEmployee(Employee employee) {
		// Tambah karyawan ke daftar karyawan
		this.employees.add(employee);
		// Beritahu daftar listener
		this.notifyEmployeeAddedListener(employee);
	}
	
	public void registerEmployeeAddedListener(EmployeeAddedListener listener) {
		// Tambah listener ke daftar listener
		this.listeners.add(listener);
	}
	
	public void unregisterEmployeeAddedListener(EmployeeAddedListener listener) {
		// Menghilangkan listener dari daftar listener
		this.listeners.remove(listener);
	}
	
	protected void notifyEmployeeAddedListener(Employee employee) {
		// beritahu setiap listener dalam daftar listener
		this.listeners.forEach(listener -> listener.onEmployeeAdded(employee));
	}
	
}
