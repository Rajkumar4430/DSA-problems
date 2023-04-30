public class InfiniteArray {
    public static void main(String[] args) {
        int[] nums = {2,3,5,7,8,10,15,17,22,30,47,51,55,68,90};
        int target = 55;
        int ans = ans(nums,target);
        System.out.println(ans);
    }
    static int ans(int[] nums, int target) {
        int start =0;
        int end = 1;

        while(target > nums[end]) {
            int newStart = end +1;
            end =end + (end-start+1) *2;  //doubling the size every time

            start = newStart;
        }
        return(binarySearch(nums, target, start,end));
    }
    static int binarySearch(int[] nums, int target, int start , int end) {
        while(start <= end) {
            int mid = (start + end) /2;
            if(target < nums[mid]) {
                end = mid -1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
