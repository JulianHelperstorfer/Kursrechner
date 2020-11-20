package sample;

import java.time.LocalDate;
import java.util.ArrayList;

public class Umrechnung {

    String ausgangswaehrung;
    String endwaehrung;
    double ausgangswert;
    double endwert;
    double kurs;
    LocalDate uDate;

    Umrechnung(double ausgWert, String ausgWaehrung, String endwaehrung, LocalDate uDate){
        this.ausgangswert = ausgWert;
        this.ausgangswaehrung = ausgWaehrung;
        this.endwaehrung = endwaehrung;
        this.uDate=uDate;
        Umrechnung.getKurs(this);
        this.endwert = ausgWert*this.kurs;
    }

    public void calcEndwert(){
        this.endwert=this.ausgangswert*this.kurs;
    }

    public static void getKurs(Umrechnung uK){
        ArrayList<Umrechnungskurs> liste = new ArrayList<>();

        for(int i=0; i<Umrechnungskurs.kursListe.size(); i++){                              //Kurs für gleiche Ausgangs- und Endwährung in der Kursliste suchen, danach in die Liste für die geeigneten Kurse geben
            if(Umrechnungskurs.kursListe.get(i).ausgangswaehrung==uK.ausgangswaehrung&&Umrechnungskurs.kursListe.get(i).endwaehrung==uK.endwaehrung){
                liste.add(Umrechnungskurs.kursListe.get(i));
            }
        }


        boolean firstDateSet = false;
        LocalDate nearestDate = LocalDate.MIN;


        for(int j=0; j<liste.size(); j++){                  //Liste mit geeigneten Kursen durchsuchen und den Kurs mit dem nähesten Datum suchen

            if(firstDateSet==false){
                if(liste.get(j).date.isBefore(uK.uDate)||liste.get(j).date.isEqual(uK.uDate)){
                    nearestDate = liste.get(j).date;
                    firstDateSet=true;
                }
            }

            else{
                if(liste.get(j).date.isAfter(nearestDate)){
                    if(liste.get(j).date.isBefore(uK.uDate)||liste.get(j).date.isEqual(nearestDate)){
                        nearestDate = liste.get(j).date;
                    }
                }
            }

        }


        for(int u=0; u<liste.size(); u++){                                                 //Liste mit geeigneten Kursen nach dem nähesten Datum durchsuchen und den zugehörigen Kurs übergeben
            if(liste.get(u).date.equals(nearestDate)){
                uK.kurs=liste.get(u).kurs;
            }
        }
    }

}