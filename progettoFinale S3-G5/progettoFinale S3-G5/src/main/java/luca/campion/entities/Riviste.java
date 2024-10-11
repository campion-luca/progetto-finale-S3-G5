package luca.campion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="riviste")

public class Riviste extends Elementi {
    private Periodicita periodicita;


    public Riviste() {} // costruttore vuoto


    //costruttore
    public Riviste(int annoPubblicazione, int numeroPagine, String titolo, Periodicita periodicita) {
        super(annoPubblicazione, numeroPagine, titolo);
        this.periodicita = periodicita;
    }

    //getter e setter
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }


    //toString
    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                ", id=" + id +
                '}';
    }
}
