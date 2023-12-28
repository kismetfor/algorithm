public class Page4 {
    public static boolean unique(int[] a) {
        for (int i = 0; i < a.length-2; i++) {
            for (int j = i+1; j < a.length-1; j++) {
                if (a[i] == a[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,90,10};
        int[] arr2 = {1,2,3,4,5,6,7,8,90,10,2,3,4,5};
        if (unique(arr1)) {
            System.out.println("全都不相同");
        }
        else {
            System.out.println("有相同");
        }if (unique(arr2)) {
            System.out.println("全都不相同");
        }
        else {
            System.out.println("有相同");
        }
    }
}
