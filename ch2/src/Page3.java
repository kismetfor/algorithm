public class Page3 {
    //Example 1: Maximum element
    public static double maxElement(double[] A) {
        // 确保数组不为空
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }

        // 初始化最大值为数组的第一个元素
        double maxVal = A[0];

        // 从数组的第二个元素开始遍历
        for (int i = 1; i < A.length; i++) {
            // 如果当前元素大于当前最大值
            if (A[i] > maxVal) {
                // 将当前元素设为最大值
                maxVal = A[i];
            }
        }

        // 返回最大值
        return maxVal;
    }

    public static void main(String[] args) {
        // 示例用法
        double[] array = {3.14, 2.71, 6.25, 1.0, 5.0};
        double result = maxElement(array);
        System.out.println("数组中的最大值为: " + result);
    }
}
