public class RotatedBS {
    public static void main(String[] args) {
        int[] nums = {4,6,9,0,1,3};
        int target = 0;
        System.out.println(ans(nums,target));
    }
    //method for finding the largest number in rotated binary search
    static int ans(int[] arr, int target) {
        //first finding the pivot in the array
        int pivot = pivot(arr);

        //if you don't find the pivot , it means the array is not rotated
        if(pivot == -1) {
            //just do the normal binary search
            return(binarySearch(arr,target,0,arr.length-1));
        }

        if(arr[pivot] == target) {
            return pivot;
        }
        if(target >= arr[0]) {
            //As it is rotated array ,search in bwtn 0,pivot-1 ,, nos after pivot are smaller than start.
            return(binarySearch(arr,target,0,pivot-1));
        } else {
            return(binarySearch(arr,target,pivot+1,arr.length-1));
        }
    }
    //finding the pivot (largest element in the array)
    //This will not work in duplicate values.
    static int pivot(int[] arr) {
        int start =0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = start + (end - start) /2;
            if(arr[mid] > arr[mid+1] ) {
                return mid;
            }
            if(arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if(arr[mid] <= arr[start]) {
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr , int target, int start , int end) {
        while(start <= end) {
            int mid = start + (end -start) /2;
            if(target == arr[mid]) {
                return mid;
            }
            if(target < arr[mid]) {
                end = mid -1;
            } else {
                start = mid +1;
            }
        }
        return -1;
    }

    //If the array contains the duplicate elements
    static int pivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //if the elments at middle , start , end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //NOTE : what if the duplicate is pivot
                //So , first check whether duplicate is pivot are not , then skip the duplicate

                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                    start++;
            }
            if (arr[end] < arr[end - 1]) {
                return end - 1;
            }
                end--;
           if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
               start = mid +1;
           } else {
               end = mid -1;
           }
        }
        return -1;
    }
}
