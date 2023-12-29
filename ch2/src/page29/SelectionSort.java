package page29;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 找到未排序部分的最小元素的索引
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // 将最小元素与未排序部分的第一个元素交换位置
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {89, 45, 68, 90, 29, 34, 17};

        System.out.println("Original Array:");
        printArray(array);

        // 进行选择排序
        selectionSort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }
}
