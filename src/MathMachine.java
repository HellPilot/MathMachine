import java.util.Scanner;
import java.util.Arrays;

// Данная программа предназначена для вычисления НОД, НОК и среднего арифметического для любого количества неотрицательных чисел.
public class MathMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Для скольки чисел выполнить рассчет? ");
        int length = scan.nextInt();
        double[] arrmath = new double[length];
        System.out.println("Введите числа: ");
        for (int i = 0; i < length; i++)
            arrmath[i] = scan.nextDouble();
        System.out.println("НОД = " + nod(arrmath));
        System.out.println("НОК = " + nok(arrmath));
        System.out.println("Среднее арифметическое = " + midle(arrmath));
    }

    static double min(double[] arrmin) { // Ищем минимальное значение в массиве
        Arrays.sort(arrmin);
        return arrmin[0];
    }

    static double nod(double[] arrnod) { // Вычисляем НОД
        double resnod = min(arrnod);     //
        for (; resnod > 1; resnod--) {
            int k = 0;
            for (double n1 : arrnod
            ) {
                if (n1 % resnod == 0)
                    k++;
            }
            if (k == arrnod.length)
                break;
        }
        return resnod;
    }

    static double nok(double[] arrnok) { // Вычисляем НОК
        double resnok = min(arrnok);
        for (; ; resnok += min(arrnok)) {
            int k = 0;
            for (double i : arrnok
            ) {
                if (resnok % i == 0)
                    k++;
            }
            if (k == arrnok.length)
                break;
        }
        return resnok;
    }

    static double midle(double[] arrmid) { // Вычисляем среднее арифметическое
        double mid = 0;
        for (double v : arrmid) {
            mid += v;
        }
        return mid / arrmid.length;
    }
}
