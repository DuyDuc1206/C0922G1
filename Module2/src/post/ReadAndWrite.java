package post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<Post> readFile(String path) throws IOException {
        List<Post> postList = new ArrayList<>();
        FileReader fileReader = new FileReader(new File(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] info;
        while ((line = bufferedReader.readLine()) != null) {
            info = line.split(",");
            postList.add(new Post(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4])));
        }
        bufferedReader.close();
        return postList;
    }

    public static void writeFile(String path, List<Post> postList) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for (Post post : postList) {
                line = String.format("%s,%s,%s,%s,%s", post.getId(), post.getTitle(), post.getSubtitle(), post.getContent(), post.getViews());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
