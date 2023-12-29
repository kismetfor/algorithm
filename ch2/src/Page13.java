public class Page13 {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
    public static void hanoi(int n, char source, char auxiliary, char goal) {
        if (n == 1) {
            System.out.println("把"+n+"从"+source+"移动到"+goal);
        }
        else {
            hanoi(n-1, source, goal, auxiliary);
            System.out.println("把"+n+"从"+source+"移动到"+goal);
            hanoi(n-1, auxiliary, source, goal);
        }
    }
}
