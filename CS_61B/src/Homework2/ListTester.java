package Homework2;

public class ListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test ="test";
		
		//generate empty list
		SList<String> test1 = new SList<String>(test);
		
		//add a few items
		test1.insertFront("front1");
		test1.insertBack("back1");
		test1.insertFront("TobeDeleted");
		
		//check if list added correctly
		System.out.println();
		System.out.println("List Currently \n" + test1);
		
		//check size of list
		test1.size();
		
		//delete 2nd node
		test1.deleteNodeAt(2);
		

		//check if list  deleted correctly
		System.out.println();
		System.out.println("List Currently:  " + test1);
		test1.size();
	}

}
