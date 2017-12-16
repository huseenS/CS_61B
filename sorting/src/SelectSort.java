import java.util.Arrays;
import java.util.Random;
public class SelectSort<T extends Comparable> implements ISort<T> {

	
	/**
     * Sorts an array of items in place
     * @param in An array to sort
     */
	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] in) {
		int n = in.length;
		for (int i = 0; i < n-1; i++) {
			int lowest = i;
			//find min to swap
			for (int j = i+1; j < n; j++) {
				//if current is less, then save min
				if (in[lowest].compareTo(in[j]) > 0 ) {
					//min found
					lowest = j;
				}
			}
			if(lowest!= i ) {
			T temp = in[i];
			in[i] = in[lowest];
			in[lowest] = temp;
			}
		
		}
		
	}
	
	/**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
	@Override
	public String sortName() {
		return "SelectSort";
	}
	
	/*
	 * Test sort
	 */
	public static void main(String[] args) {
		long s,e;
		Random r = new Random();
		Integer[] testArray = null;
		
		int l;
		for(l=100; l<1000000; l*=10) {
            // Prepare the array
            testArray = new Integer[l];
            for(int j=0; j<l; j++) {
                testArray[j] = r.nextInt();
            }
		}
		
		Integer[] smallArray = {9,8,7,6,5,4,3,2,1};
		SelectSort<Integer> sort = new SelectSort<>();
		s = System.currentTimeMillis();
		sort.sort(testArray);
		sort.sort(smallArray);
		System.out.println(Arrays.toString(smallArray)+"\n");
		System.out.print(Arrays.toString(testArray));
		e = System.currentTimeMillis();
        System.out.println("Sorted "+l+" items in "+(e-s)+"ms using "+sort.sortName());
	}
}

