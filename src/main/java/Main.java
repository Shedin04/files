import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        /*write*/
        /*writeMasToTxt(mas, "D:\\JAVA PROJECTS\\files\\src\\main\\data.txt");
        writeMasToCsv(mas, "D:\\JAVA PROJECTS\\files\\src\\main\\data.csv");*/

        /*read*/
        double[] getmas = readToDouble("D:\\JAVA PROJECTS\\files\\src\\main\\data.csv");
        System.out.println(Arrays.toString(getmas));
    }

    private static double[] readToDouble(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name));
        String[] str = br.readLine()
                .replaceAll(",",".") // заменяем запятые на точки
                .split(";"); // разделяем элементы
        double[] mas = new double[str.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(str[i]);
        }
        return mas;
    }

    private static void writeMasToTxt(int[] mas, String name) throws IOException {
        FileWriter fr = new FileWriter(name);
        fr.write(Arrays.toString(mas) + " | "); // нормально запишет
        fr.flush(); // промежуточная запись в файл
        for (var el: mas) {
            // fr.write(el); // запишет в АСКИ
            fr.write(el + ";");
        }
        fr.close(); // без close не запишется, будет в RAMe
    }

    private static void writeMasToCsv(int[] mas, String name) throws IOException {
        FileWriter fr = new FileWriter(name);
        for (var el : mas) {
            fr.write(el + ";");
        }
        fr.close(); // без close не запишется, будет в RAMe
    }
}