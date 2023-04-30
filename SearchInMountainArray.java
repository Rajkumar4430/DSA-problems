public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,8,10,8,4,2};
        int target = 10;
        System.out.println(search(nums,target));
    }
    static int search(int[] arr,int target) {
        int peak = mountainPeak(arr);
        int firstTry = orderAgnosticBS(arr,target,0,peak);
        if(firstTry != -1){
            return firstTry;
        }
        return orderAgnosticBS(arr,target,peak+1,arr.length-1);
    }

    static int mountainPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in descending part ,
                // possible that mid can be the answer
                // better to check on the left
                end = mid;
            } else {            // arr[mid] < arr[mid+1] ,you are in ascending order ,, check on the right part
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(int[] arr, int target, int start ,int end) {
        boolean isAsc = arr[start] < arr[end];
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return mid;
            }

            if(isAsc) {  //if it is in ascending order
                if(target < arr[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
