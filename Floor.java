public class Floor {
    // Floor is the greatest number which is less than or equal to the target element
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,9,10,14,18,19};
        int target = 15;
        int ans = floor(arr, target);
        System.out.println(ans);
    }
    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;

        while(start <= end) {
            int mid = start + (end - start) /2;

            if(target < arr[mid]) {
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
