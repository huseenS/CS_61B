import java.util.Arrays;
import java.util.Random;

public class MergeSort<T extends Comparable> implements ISort<T> {
	/*need base case: if start & end = each other then list.size = 1, else list size 2
		ed - st <= 1
		mid = (st+ed)/2;
		mergeSort(list,st,mid) //call recursively
		mergeSort(list,mid+1,ed); //call recursively
		*/
	@Override
	public void sort(T[] in) {
		mergeSort(in, 0, in.length -1);
		
	}
	
	private void mergeSort (T[] in, int st, int end) {
		//base case
		if (st >= end) {
			return;
		}
		int mid = (st+end)/2;
		mergeSort(in,st,mid);
		mergeSort(in,mid+1,end);
		mergeEachHalf(in,st,end);
	}
	@SuppressWarnings("unchecked")
	public void mergeEachHalf(T[] in, int leftStart, int rightEnd) {
		T[] temp = (T[]) new Comparable[in.length];
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd +1;
		int size = rightEnd - leftStart +1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
				
		//walk through two halves and copy over smaller element
		while(left <= leftEnd && right <= rightEnd ) {
			//in bounds
			if(in[left].compareTo(in[right]) <= 0 ) {
				//copy left index if smaller
				temp[index] = in[left];
								left++;
			} else {
				//copy right
				temp[index] = in[right];
			}
			index++;
		}
		
		//instead of for loop to copy over remainder of elements
		//copy remaining elements from leftSide
		System.arraycopy(in, left, temp, index, leftEnd-left +1);
		//copy remaining elements from rightSide
		System.arraycopy(in, right, temp, index, rightEnd-right+1);
		//copy all from temp back to original array
		System.arraycopy(temp, leftStart, in, leftStart, size);
	}

	@Override
	public String sortName() {
		return "Merge Sort";
	}
	
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
		
		Integer[] smallArray = {9,8,7,6,5,4,3,2,1,0};
		MergeSort<Integer> sort = new MergeSort<>();
		s = System.currentTimeMillis();
		sort.sort(testArray);
		sort.sort(smallArray);
		System.out.println(Arrays.toString(smallArray)+"\n");
		System.out.print(Arrays.toString(testArray));
		e = System.currentTimeMillis();
        System.out.println("Sorted "+l+" items in "+(e-s)+"ms using "+sort.sortName());
	}

}
