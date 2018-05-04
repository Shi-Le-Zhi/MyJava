package yan;
//二分查找
public class Find {
    public static int searchInsert(int[] nums, int target) {
    	int low= 0;
        int high = nums.length -1 ;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > target) {
            	high = mid - 1;
            }
            else if(nums[mid] < target) {
            	low = mid + 1;
            }
            else return mid;
        }
        if(nums[high] >target) return high -1;
        else return high +1;
    }
    public static void main(String[] args) {
    	System.out.println(Find.searchInsert(new int[]{1,3,5,7,9,10,11,12,13,15,18,20}, 21));
    }
}
