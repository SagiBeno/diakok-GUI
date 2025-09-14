package com.example.diakok;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

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
            // System.out.println(fileLine);
            diakok.add(new Diak(fileLine));
        }
        scanner.close();
    }

    @FXML
    protected void onMindenkiButtonClick() {
        List<String> diakokLinesList = new ArrayList<>();
        for (Diak diak: diakok) {
            diakokLinesList.add(diak.toString());
        }
        ObservableList<String> diakokOList = FXCollections.observableList(diakokLinesList);
        listview_Filtered.setItems(diakokOList);
    }

    @FXML
    protected void onSandorButtonClick() {
        List<String> diakokLinesList = new ArrayList<>();
        for (Diak diak: diakok) {
            if (Objects.equals(diak.knev, "Sándor")) {
                diakokLinesList.add(diak.toString());
            }
        }
        ObservableList<String> diakokOList = FXCollections.observableList(diakokLinesList);
        listview_Filtered.setItems(diakokOList);
    }

    @FXML
    protected void onKecskemetiButtonClick() {
        List<String> diakokLinesList = new ArrayList<>();
        for (Diak diak: diakok) {
            if (Objects.equals(diak.lakhely, "Kecskemét")) {
                diakokLinesList.add(diak.toString());
            }
        }
        ObservableList<String> diakokOList = FXCollections.observableList(diakokLinesList);
        listview_Filtered.setItems(diakokOList);
    }

    @FXML
    protected void on1996ButtonClick() {
        List<String> diakokLinesList = new ArrayList<>();
        for (Diak diak: diakok) {
            if (diak.datum.getYear() == 1996) {
                diakokLinesList.add(diak.toString());
            }
        }
        ObservableList<String> diakokOList = FXCollections.observableList(diakokLinesList);
        listview_Filtered.setItems(diakokOList);
    }

    @FXML
    protected void on10AButtonClick() {
        List<String> diakokLinesList = new ArrayList<>();
        for (Diak diak: diakok) {
            if (Objects.equals(diak.osztaly, "10/A")) {
                diakokLinesList.add(diak.toString());
            }
        }
        ObservableList<String> diakokOList = FXCollections.observableList(diakokLinesList);
        listview_Filtered.setItems(diakokOList);
    }

    @FXML
    protected void onSaveDataButtonClick() {
        Path path = Paths.get("adatok.txt");

        try (BufferedWriter w = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

            for (String d : listview_Filtered.getItems()) {
                w.write(d);
                w.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}