import java.util.Scanner;
import java.util.Arrays;

// ������ ��������� ������������� ��� ���������� ���, ��� � �������� ��������������� ��� ������ ���������� ��������������� �����.
public class MathMachine {
    public static void main(String[] args) {
       // int length;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("��� ������� ����� ��������� �������? ");
            int length = scan.nextInt();
            if(length<2) {
                throw new Exception("��� ������ ��������� ����� ���� �� 2 �����");
            }
            double[] arrmath = new double[length];
            System.out.println("������� �����: ");
            for (int i = 0; i < length; i++)
                arrmath[i] = scan.nextDouble();
            System.out.println("��� = " + nod(arrmath));
            System.out.println("��� = " + nok(arrmath));
            System.out.println("������� �������������� = " + midle(arrmath));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    static double min(double[] arrmin) { // ���� ����������� �������� � �������
        Arrays.sort(arrmin);
        return arrmin[0];
    }

    static double nod(double[] arrnod) { // ���� ���
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

    static double nok(double[] arrnok) { // ���� ���
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

    static double midle(double[] arrmid) {
        double mid = 0;
        for (double v : arrmid) {
            mid += v;
        }
        return mid / arrmid.length;
    }
}
