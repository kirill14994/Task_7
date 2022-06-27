import java.util.List;
import java.util.Scanner;

// 14 = 365596 решений (100 градусов цп), больше не нужно

public class Programm {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Размер доски NxN. \nКоличество фигур N. \nВведите N: ");
        int size = scan.nextInt();

        List<QueenBoard> solutions = new NQueensProblem(size).getAllSolutions();
        int count = 0;
        for (QueenBoard board : solutions) {
            System.out.println(board.toString());
            count++;
        }
        System.out.printf("Количество решений: %d",count);
        scan.close();
    }

}
