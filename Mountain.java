public class Mountain {
    public static void main(String[] args) {
        int[] arr ={1,2,3,5,6,4,3,2};
        System.out.println(mountainPeak(arr));
    }
    static int mountainPeak(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while(start < end) {
            int mid = start +(end - start) /2;
            if(arr[mid] > arr[mid+1]) {
                // you are in the decreasing part of the array
                // this may be the answer , but look at left
                end = mid;
            } else {
                // you are in the ascending part of the array  arr[mid] < arr[mid+1]
                start = mid +1;
            }
        }
        return end;
    }
}
