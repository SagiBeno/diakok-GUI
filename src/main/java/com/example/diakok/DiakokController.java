package com.example.diakok;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DiakokController implements Initializable {
    @FXML public ListView<String> listview_Filtered;

    public static List<String> filelines;
    public static List<Diak> diakok;

    public static void loadFile(String filename) throws IOException {
        diakok = new ArrayList<>();
        filelines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8);
        while(scanner.hasNextLine()) {
            String fileLine = scanner.nextLine();
            filelines.add(fileLine);
            System.out.println(fileLine);
            diakok.add(new Diak(fileLine));
        }
        scanner.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}