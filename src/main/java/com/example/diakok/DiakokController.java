package com.example.diakok;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DiakokController implements Initializable {
    public static List<String> filelines;

    public static void loadFile(String filename) throws IOException {

        filelines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8);
        while(scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            filelines.add(fileLine);
        }
        scanner.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}