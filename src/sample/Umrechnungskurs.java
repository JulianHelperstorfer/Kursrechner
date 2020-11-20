package sample;

import java.time.LocalDate;
import java.util.ArrayList;

public class Umrechnungskurs {
    static ArrayList<Umrechnungskurs> kursListe = new ArrayList<>();
    String ausgangswaehrung;
    String endwaehrung;
    double kurs;
    LocalDate date;
    static boolean arrayBefüllt = false;

    Umrechnungskurs(String ausgangswaehrung, String endwaehrung, double kurs, LocalDate date){
        this.kurs=kurs;
        this.endwaehrung=endwaehrung;
        this.ausgangswaehrung=ausgangswaehrung;
        this.date=date;
    }

    public static void fillArray(){
        kursListe.add(new Umrechnungskurs("EUR", "USD", 1.19, LocalDate.of(2020, 11, 20)));
        kursListe.add(new Umrechnungskurs("EUR", "USD", 1.5, LocalDate.of(2019, 11, 20)));
        kursListe.add(new Umrechnungskurs("EUR", "YEN", 123.22, LocalDate.of(2020, 11, 20)));
        kursListe.add(new Umrechnungskurs("USD", "EUR", 0.84, LocalDate.of(2020, 11, 20)));
        kursListe.add(new Umrechnungskurs("USD", "YEN", 103.78, LocalDate.of(2020, 11, 20)));
        kursListe.add(new Umrechnungskurs("YEN", "EUR", 0.0081, LocalDate.of(2020, 11, 20)));
        kursListe.add(new Umrechnungskurs("YEN", "USD", 0.0096, LocalDate.of(2020, 11, 20)));

        System.out.println("Liste befüllt!");
    }

}
