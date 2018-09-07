package leetcode;

import java.util.List;

// https://leetcode.com/problems/employee-importance/description/
// Easy. 10m. This is O(N^2). A HashMap makes it O(n).
// 2018-08-20

class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
};

public class EmployeeImportance {

	/*
	// Employee info
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	 */
	public int getImportance(List<Employee> employees, int id) {
		int result = 0;
		// Find employee.
		Employee e = null;
		for ( Employee em : employees){
			if ( em.id == id ){
				e=em;
				break;
			}
		}
		if ( e == null ) return 0;

		result = e.importance;

		for ( int idd : e.subordinates){
			result = result + getImportance ( employees, idd );
		}

		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
