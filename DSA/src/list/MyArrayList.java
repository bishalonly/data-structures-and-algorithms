package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/*List is a abstract data type
 * It doesn't dictate how the data is organized
 * Dictates the operations you perform
 * Concrete DS is a Concrete class
 * Abstract data type are usually an interface*/

public class MyArrayList {
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		List<Employee> v = new Vector<>();
		/*
		 * vectors are synchronizable which makes them thread safe.
		 * these all comes from List interface.
		 * 
		 * ArrayList, LinkedList, Vector comes from the List interface
		 * List, Set and Queue comes from the collection interface
		 * 
		 * Map is different because unlike these it contains both Key and Value pair
		 */
		
		
		empList.add(new Employee("bishal",1));
		empList.add(new Employee("aman",2));
		empList.add(new Employee("ajay",3));
		empList.add(new Employee("gita",4));
		
		empList.forEach(System.out::println);
	}
	

}
