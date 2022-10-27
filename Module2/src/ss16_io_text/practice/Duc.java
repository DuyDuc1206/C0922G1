package ss16_io_text.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Duc {
    public static void main(String[] args) {
        File sourceFile = new File("src\\ss16_io_text\\practice\\duc.csv");
        List<String[]> lines = new ArrayList<>();
        String line;

        try {
            FileReader sourceFileReader = new FileReader(sourceFile);
            BufferedReader sourceFileReaderBuffer = new BufferedReader(sourceFileReader);

            while ((line = sourceFileReaderBuffer.readLine()) != null) {
                lines.add(line.split(","));
            }

            for (String[] strLine : lines) {
                System.out.printf("%s ,%s,%s\n", strLine[0], strLine[1], strLine[2]);
            }

            sourceFileReaderBuffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
