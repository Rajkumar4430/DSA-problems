public class RotatedCount {
    public static void main(String[] args) {
        int[] nums = {4,5,7,9,0,2,3};
        System.out.println(ans(nums));
    }

    static int ans(int[] arr) {
        //The number of times the array is rotated is pivot index + 1
        int ans = pivot(arr);
        return ans + 1;
    }

    static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //case 1
            if (arr[mid] > arr[mid + 1]) {
                return mid;
            } // case 2
            if (arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } //case 3
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else { //case 4
                start = mid + 1;
            }
        }
        return -1;
    }
    //Rotation with duplicates in the array
    static int pivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(arr[mid] < arr[mid-1]) {
                return mid -1;
            }

            //what if start , end and middle are duplicates
            //Just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //first check whether the duplicate is pivot or not
                //Then skip the duplicate , if it is not pivot
                if(arr[start] > arr[start + 1]) {
                    return start;
                } start++;

                if(arr[end] < arr[end - 1]) {
                    return end -1;
                } end--;

            }
            if(arr[start] < arr[end] || arr[start] == arr[end] && arr[mid] > arr[end]) {
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
