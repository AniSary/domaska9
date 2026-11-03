import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] m = new int[4][4];
        Random r = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = r.nextInt(50) + 1;
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }

        long evenRows = 0, oddRows = 0, evenCols = 1, oddCols = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) evenRows += m[i][j]; else oddRows += m[i][j];
                if (j % 2 == 0) evenCols *= m[i][j]; else oddCols *= m[i][j];
            }
        }
        System.out.println("Сума у парних рядках: " + evenRows);
        System.out.println("Сума у непарних рядках: " + oddRows);
        System.out.println("Добуток у парних стовпцях: " + evenCols);
        System.out.println("Добуток у непарних стовпцях: " + oddCols);

        int s = m[0][0] + m[0][1] + m[0][2] + m[0][3];
        int d1 = 0, d2 = 0;
        boolean magic = true;
        for (int i = 0; i < 4; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < 4; j++) {
                row += m[i][j];
                col += m[j][i];
            }
            if (row != s || col != s) magic = false;
            d1 += m[i][i];
            d2 += m[i][3 - i];
        }
        if (d1 != s || d2 != s) magic = false;

        System.out.println(magic ? "Магічний квадрат" : "Не є магічним квадратом");
    }
}