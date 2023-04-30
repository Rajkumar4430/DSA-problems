// Find smallest letter, Greater than the target
public class CeilingInStringArray {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j', 'l'};
        char target = 'l';
        char ans = ceilingInString(arr, target);
        System.out.println(ans);
    }
        static char ceilingInString(char[] arr, char target) {
            int start = 0;
            int end = arr.length -1;

            while(start <= end) {
                int mid = start + (end - start)/2;

                if(target < arr[mid]) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
            return arr[start % arr.length];
        }
}
