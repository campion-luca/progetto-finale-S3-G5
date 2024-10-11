package luca.campion.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="libri")

public class Libri extends Elementi {
    private String autore;
    private String genere;


    public Libri() {} // costruttore vuoto


    // costruttore
    public Libri(int annoPubblicazione, int numeroPagine, String titolo, String autore, String genere) {
        super(annoPubblicazione, numeroPagine, titolo);
        this.autore = autore;
        this.genere = genere;
    }

    // getter e setter
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    //toString
    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", id=" + id +
                ", numeroPagine=" + numeroPagine +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
