package yan;

public class Sort {
	public static void Bubble(int[] array) {
		int length = array.length;
		int temp = 0;
		for(int i=0;i<length;i++)
			for(int j=0;j<length-i;j++) {
				if(array[j]>array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j]=temp;
				}
			}
		for(int i=0;i<length;i++)
			System.out.println(array[i]);
	}
	
	
	public static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int middle = getMiddle(array,low,high);
			quickSort(array,low,middle-1);
			quickSort(array,middle+1,high);
		}
		
	}
	public static int getMiddle(int[] array, int low, int high) {
		int pivot = array[low];
		while(low < high) {
			while(array[high]>pivot) high--;
			array[low] = array[high];
			while(array[low]<pivot) low++;
			array[high] = array[low];
		}
		array[low] = pivot;
		return low;
	}
	
	
}
