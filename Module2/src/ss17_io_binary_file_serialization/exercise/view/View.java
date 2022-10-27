package ss17_io_binary_file_serialization.exercise.view;

import ss17_io_binary_file_serialization.exercise.controller.ProductController;

import java.io.IOException;

public class View {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController.display();
    }
}
