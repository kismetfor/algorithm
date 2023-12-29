public class Page11 {
    // ALGORITHM F(n)
// 递归计算阶乘 n!
// 输入: 一个非负整数 n
// 输出: n! 的值

    // 如果 n 等于 0，返回 1
// 否则，返回 F(n-1) * n
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    // 示例用法
    public static void main(String[] args) {
        int n = 5;  // 例如，计算 5!
        int result = factorial(n);
        System.out.println(n + "! 的值为: " + result);
    }

}
