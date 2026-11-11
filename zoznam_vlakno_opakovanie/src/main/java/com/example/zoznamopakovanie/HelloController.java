package com.example.zoznamopakovanie;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML private TextField name;
    @FXML
    ComboBox<String> priority, state;
    @FXML private ListView<Uloha> list;
    @FXML private TextArea process;

    private Thread t1, t2;

    ObservableList<Uloha> zoznam = FXCollections.observableArrayList();

    @FXML private void startThread(){
        Thread t1 = new Thread(()->{
           while (true){
               try {
                   Thread.sleep(100);
                   Platform.runLater(()->{
                       process.appendText("bezim ostosest!!");
                       zoznam.removeIf(u->"finished".equals(u.getState()));
                   });
               }
               catch (InterruptedException e) {return;}
           }
        });
        t1.setDaemon(true);
        t1.start();

    }

    public void initialize(){
        list.setItems(zoznam);
        priority.getItems().addAll("low","medium","high");
        state.getItems().addAll("not started","working","finished");
    }

    @FXML public void add(){
        Uloha u = new Uloha(name.getText(),priority.getValue(),state.getValue());
        zoznam.add(u);
    }
    @FXML public void edit(){
        Uloha u = list.getSelectionModel().getSelectedItem();
        u.setName(name.getText());
        u.setPriority(priority.getValue());
        u.setState(state.getValue());
        list.refresh();
    }
    @FXML public void remove(){
        Uloha u = list.getSelectionModel().getSelectedItem();
        zoznam.remove(u);
    }

}
