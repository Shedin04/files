import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        writeMasToTxt(mas, "D:\\JAVA PROJECTS\\files\\src\\main\\data.txt");
        writeMasToCsv(mas, "D:\\JAVA PROJECTS\\files\\src\\main\\data.csv");
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