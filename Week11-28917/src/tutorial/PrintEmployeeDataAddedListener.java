package tutorial;

public class PrintEmployeeDataAddedListener implements EmployeeAddedListener {

	@Override
	public void onEmployeeAdded(Employee employee) {
		// Print nama karyawan yang baru ditambahkan
		System.out.println("Ditambahkan karyawan baru dengan posisi '"+ employee.getPosition() +"' bernama '" + employee.getName() + "'");

	}

}
