import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int [] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        FileWriter fr = new FileWriter("D:\\JAVA PROJECTS\\files\\src\\main\\data.txt");
        fr.write(Arrays.toString(mas) + " | ");
        fr.flush(); // промежуточная запись в файл
        for (var el: mas) {
            // fr.write(el);// запишет в АСКИ
            fr.write(el + " "); // запишет нормально, ибо подумает, что строка
        }
        fr.close(); // без close не запишется, будет в RAMe
    }
}