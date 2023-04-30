public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {89,70,46,33,30,28,26,19,17,10,9,5,3,1,0,-3,-6,-15};
        int target = 70;
        int ans = orderAgnosticBS(arr,target);
        System.out.println(ans);
    }
    static int orderAgnosticBS (int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        //condition to check whether array is in ascending or descending
        boolean isAsc;
        isAsc = arr[start] < arr[end];

        //condition
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return mid;
            }
            if(isAsc) {
                if(target < arr[mid]) {
                    end = mid -1;
                } else  {
                    start = mid +1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
