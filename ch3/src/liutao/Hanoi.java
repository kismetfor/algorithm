package liutao;

public class Hanoi {
    public static void main(String[] args) {
        han(3, 'A', 'B', 'C');
    }
    public static void han (int n, char source, char fuzhu, char goal) {
        if ( n ==1 ){
            System.out.println("把"+n+"从"+source+"移动到"+goal);
            return;
        } else {

            han(n-1, source, goal, fuzhu);
            //把最后下面那个移到目标处
            System.out.println("把"+n+"从"+source+"移动到"+goal);
            han(n-1, fuzhu, source, goal);
        }
    }
}
