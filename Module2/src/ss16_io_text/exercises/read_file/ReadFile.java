package ss16_io_text.exercises.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadFile {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\ss16_io_text\\exercises\\read_file\\Country.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<String[]> lists = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\"", "");
               lists.add(line.split(","));
            }
            for (String[] str : lists) {
                System.out.println( str[0] + str[1] + str[2] );
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("file is not exist");
        }
    }
}
