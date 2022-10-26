package ss16_io_text.exercises.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\ss16_io_text\\exercises\\read_file\\Country.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<Nation> nationList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                Nation nation = new Nation(Integer.parseInt(info[0]), info[1], info[2]);
                nationList.add(nation);
            }
            for (Nation str : nationList) {
                System.out.println(String.format("%s,%s,%s\n",str.getId() , str.getShortedName() , str.getName()));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File is not exist");
        }
    }
}
