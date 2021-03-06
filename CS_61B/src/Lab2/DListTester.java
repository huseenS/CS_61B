package Lab2;

public class DListTester {

	public static void main(String[] args) {
		
		//generate empty list
		DList<String> testList= new DList<String>();
		
		
		testList.removeNode(5); //check if removal works 
		
		String test = "test: ";
	
		int i = 0;
		while (i <=  11) {
			testList.addNode(i, (test+ i));
			i++;
		}
		
		System.out.println(testList);

		System.out.println(testList.getItem(5)); //get fifth item
		System.out.println(testList.getFirst()); //get first item
		System.out.println(testList.getLast()); //get last item
		
		testList.removeNode(5); //remove fifth item
		System.out.println();
		System.out.println(testList); //check if remove successful
		
		testList.addNode(5, "Item at index 5"); //add item back
		System.out.println(testList); //check if add successful 

		testList.removeNode(5000); // check if removal at wrong index 
		

	
		
		
	}

}
