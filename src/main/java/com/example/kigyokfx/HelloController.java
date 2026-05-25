package com.example.kigyokfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    public ListView<String> folista;
    public TextField bevitel;
    public ListView<String> kislista;
    @FXML
    private Label welcomeText;
    private FileChooser fc=new FileChooser();

    private ArrayList<Kigyo> kigyokLista = new ArrayList<>();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onMegnyitasClick(ActionEvent e){
        fc.setInitialDirectory(new File("./"));
        File fbe = fc.showOpenDialog(folista.getScene().getWindow());
        readdata(fbe);
    }

    public void readdata(File fbe){
        kigyokLista.clear();
        folista.getItems.clear();
        try {
            Scanner beolvas = new Scanner(fbe);
            beolvas.nextLine();
            while (beolvas.hasNextLine()) {
                kigyokLista.add(new Kigyo(beolvas.nextLine().strip().split(";")));
            }
            for (Kigyo i: kigyokLista) {
                folista.getItems().add(i.getFajta()+" ("+i.getHossz()+"cm), "+ i.getElofordulas());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public void onKilepesClick(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onNevjegyClick(ActionEvent actionEvent) {
        Alert i = new Alert(Alert.AlertType.INFORMATION);
        i.setHeaderText(null);
        i.setTitle("Névjegy");
        i.setContentText("Kígyók v1.0.0\n(C) Kandó");
        i.showAndWait();
    }

    public void onSzuresClick(ActionEvent actionEvent) {
        kislista.getItems().clear();
        String nev = bevitel.getText();
        for (Kigyo i: kigyokLista) {
            if (i.getFajta().toLowerCase().contains(nev.toLowerCase())){
                kislista.getItems().add(i.getFajta());
            }
        }
    }
}
