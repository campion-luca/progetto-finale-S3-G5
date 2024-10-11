package luca.campion.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="elementi")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Elementi {

    @Id
    @GeneratedValue
    @Column(name="codice ISBN", nullable = false)
    protected long id;

    @Column(name="anno di pubblicazione", nullable = false)
    protected int annoPubblicazione;

    @Column(name="numero di pagine", nullable = false)
    protected int numeroPagine;

    @Column(name="titolo elemento", nullable = false)
    protected String titolo;

    public Elementi(){} // costruttore vuoto


    // costruttore
    public Elementi(int annoPubblicazione, int numeroPagine, String titolo) {
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.titolo = titolo;
    }


    // getter e setter
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //toString
    @Override
    public String toString() {
        return "Elementi{" +
                "annoPubblicazione=" + annoPubblicazione +
                ", codiceISBN=" + id +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
