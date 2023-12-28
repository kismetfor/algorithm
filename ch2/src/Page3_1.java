public class Page3_1 {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,91,213,23,34,35,45,46,56,5,767,3,499};
        int ret = findMax(arr);
        System.out.println(ret);
    }
}
