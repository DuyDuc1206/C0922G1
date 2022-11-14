package exercise.untils;

import exercise.modul.BacSi;
import exercise.modul.BenhNhan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadAndWrite {
    public static Map<BacSi,BenhNhan> readPatentFile(String pathFile){
        Map<BacSi,BenhNhan> benhNhanList = new TreeMap<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line=bufferedReader.readLine())!=null){
                info=line.split(",");
                benhNhanList.put(new BacSi(),new BenhNhan());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return benhNhanList;
    }
//    public static writePatentFile()
}
