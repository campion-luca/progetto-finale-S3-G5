package luca.campion.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="prestiti")

public class Prestiti {
    @Id
    @GeneratedValue
    public long id;

    @ManyToOne
    @JoinColumn(name="utente_id")
    public Utenti utente;

    @OneToOne
    @JoinColumn(name="elemento prestato")
    public Elementi elementi;

    @Column(name="data inizio prestito", nullable = false)
    public LocalDate dataInizioPrestito;

    @Column(name="restituzione prevista", nullable = false)
    public LocalDate restituzionePrevista;

    @Column(name="restituzione effettiva") // non metto il nullable in quanto può essere NULL se ancora lo ha l'utente
    public LocalDate restituzioneEffettiva;


    public Prestiti() {} // costruttore vuoto


    // costruttore
    public Prestiti(Elementi elementi, LocalDate restituzioneEffettiva, Utenti utente) {
        this.dataInizioPrestito = LocalDate.now();
        this.elementi = elementi; //1
        this.restituzioneEffettiva = restituzioneEffettiva; //2
        this.restituzionePrevista = LocalDate.now().plusDays(30);
        this.utente = utente; //3
    }

    // getter e setter
    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Elementi getElementi() {
        return elementi;
    }

    public void setElementi(Elementi elementi) {
        this.elementi = elementi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public Utenti getUtenti() {
        return utente;
    }

    public void setUtenti(Utenti utente) {
        this.utente = utente;
    }


    // toString
    @Override
    public String toString() {
        return "Prestiti{" +
                "dataInizioPrestito=" + dataInizioPrestito +
                ", id=" + id +
                ", utenti=" + utente +
                ", elementoPrestato='" + elementi + '\'' +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                '}';
    }

}
