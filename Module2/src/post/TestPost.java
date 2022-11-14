package post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPost {
    public static final String PATH = "src\\post\\data.csv";

    public static void main(String[] args) {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post(1, "bao moi", "bao", "Ngay 11/4", 5);
        Post post2 = new Post(2, "bao cu", "bao", "Ngay 10/4", 10);
        postList.add(post1);
        postList.add(post2);

        ReadAndWrite.writeFile(PATH, postList);
        try {
            for (Post post : ReadAndWrite.readFile(PATH)) {
                System.out.println(post.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
