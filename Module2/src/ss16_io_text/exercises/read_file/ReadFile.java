package ss16_io_text.exercises.read_file;

import java.io.*;
import java.util.Arrays;


public class ReadFile {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\ss16_io_text\\exercises\\read_file\\Country.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                System.out.println(Arrays.toString(array));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("file is not exist");
        }
    }
}
