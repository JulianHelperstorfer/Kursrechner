package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextField txt_ausgangswert;
    @FXML private TextField txt_endwert;
    @FXML private ComboBox cbb_ausgangswaehrung;
    @FXML private ComboBox cbb_endwaehrung;
    @FXML private DatePicker dtp_datepicker;
    ObservableList<String> waehrungen = FXCollections.observableArrayList("EUR", "USD", "YEN");

    public void showMessage(){
        if(!Umrechnungskurs.arrayBefüllt){
            Umrechnungskurs.fillArray();
            Umrechnungskurs.arrayBefüllt=true;
        }
        Umrechnung u = new Umrechnung(Double.parseDouble(txt_ausgangswert.getText()), cbb_ausgangswaehrung.getSelectionModel().getSelectedItem().toString(), cbb_endwaehrung.getSelectionModel().getSelectedItem().toString(), dtp_datepicker.getValue());
        Umrechnung.getKurs(u);
        u.calcEndwert();
        DecimalFormat f = new DecimalFormat("#0.00");
        txt_endwert.setText((f.format(u.endwert)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cbb_ausgangswaehrung.setValue("EUR");
        cbb_ausgangswaehrung.setItems(waehrungen);
        cbb_endwaehrung.setValue("USD");
        cbb_endwaehrung.setItems(waehrungen);

        dtp_datepicker.setValue(LocalDate.now());
    }

    public String toString(double wert){
        return ""+wert;
    }

    public void clear(){                    //Methode zum Zurücksetzen des Kursrechners
        txt_endwert.setText("");
        txt_ausgangswert.setText("");
        dtp_datepicker.setValue(LocalDate.now());
    }

    public void end(){              //Methode zum Beenden des Programms
        System.exit(0);
    }
}
