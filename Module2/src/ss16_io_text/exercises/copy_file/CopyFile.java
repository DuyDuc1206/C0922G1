package ss16_io_text.exercises.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\ss16_io_text\\exercises\\copy_file\\SourceFile.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            File file1 = new File("src\\ss16_io_text\\exercises\\copy_file\\Target.csv");
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            List<String> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                Collections.addAll(list, line.split(""));
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            int count = list.size();
            System.out.println(count);

            for (String str : list) {
                System.out.println(str);
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e){
            System.out.println("file is not exist");
        }
    }
}
