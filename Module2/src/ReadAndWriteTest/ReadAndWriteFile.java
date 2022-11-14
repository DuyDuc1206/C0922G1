//package ReadAndWriteTest;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadAndWriteFile {
//    public static List<String> readFile(String pathFile){
//        List<String > studentList = new ArrayList<>();
//        try {
//            FileReader fileReader = new FileReader(new File(pathFile));
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] info;
//            while ((line=bufferedReader.readLine())!=null){
//                info=line.split(",");
//                studentList.add(new Student());
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return studentList;
//    }
//    public static void write(String pathFile,List<String> studentList){
//        try {
//            FileWriter fileWriter = new FileWriter(new File(pathFile));
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String line;
//            for (String key:studentList){
//                line = String.format();
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
