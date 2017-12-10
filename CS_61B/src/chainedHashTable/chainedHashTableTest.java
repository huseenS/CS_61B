package chainedHashTable;

public class chainedHashTableTest {

	public static void main(String[] args) {
		chainedHashMap<String, String> map = new chainedHashMap<>(2); 
		
		map.put("Dog", "This is a Dog");
		map.put("God", "This is a God");
		map.put("Cat", "This is a Cat");
		map.put("Bunny", "This is a Bunny");
		map.put("Pikachu", "This is a Pikachu");
		map.remove("Bunny");
		
		
		System.out.println("Should be Dog: " + map.get("Dog"));
		System.out.println("Should be Pikachu: " + map.get("Pikachu"));
		System.out.println("Does map contain bunny? " + map.containsKey("Bunny"));
		System.out.println("Printed Map: " + map.toString());
	}

}
