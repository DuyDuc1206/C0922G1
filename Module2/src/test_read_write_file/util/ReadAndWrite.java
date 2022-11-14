package test_read_write_file.util;

import test_read_write_file.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<Student> readFile(String pathFile){
        List<Student> studemtsList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line=bufferedReader.readLine())!=null){
                info=line.split(",");
                studemtsList.add(new Student(Integer.parseInt(info[0]),info[1],Integer.parseInt(info[2]),Double.parseDouble(info[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return studemtsList;
    }
    public static void writeFile(String pathFile,List<Student> studentList){
        try {
            FileWriter fileWriter = new FileWriter(new File(pathFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for (Student student:studentList){
                line = String.format("%s,%s,%s,%s",student.getId(),student.getName(),student.getAge(),student.getScore());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
