package page8;
public class CountBinaryDigits {

    public static int countBinaryDigits(int n) {
        // 确保输入是正整数
        if (n <= 0) {
            throw new IllegalArgumentException("输入必须是正整数");
        }

        int count = 1;

        // 当 n 大于 1 时，循环计算二进制位数
        while (n > 1) {
            count++;
            n = n / 2;
        }

        // 返回二进制位数
        return count;
    }

    public static void main(String[] args) {
        // 示例用法
        int decimalNumber = 25;
        int binaryDigitsCount = countBinaryDigits(decimalNumber);

        System.out.println("数字 " + decimalNumber + " 的二进制位数为: " + binaryDigitsCount);
    }
}
