package luca.campion.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="utenti")

public class Utenti {
    @Id
    @GeneratedValue
    private long id;

    private String nome;
    private String cognome;

    @Column(name="data di nascita", nullable = false)
    private LocalDate dataDiNascita;

    @Column(name="numero di tessera", nullable = false)
    private int numeroTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestiti> prestitiList;


    public Utenti() {} // costruttore vuoto

    // costruttore
    public Utenti(String cognome, LocalDate dataDiNascita, int numeroTessera, String nome) {
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTessera = numeroTessera;
        this.nome = nome;
    }

    // getter e setter
    public String getCognome() {
        return cognome;
    }

    public List<Prestiti> getPrestitiList() {
        return prestitiList;
    }

    public void setPrestitiList(List<Prestiti> prestitiList) {
        this.prestitiList = prestitiList;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }



    // toString
    @Override
    public String toString() {
        return "Utenti{" +
                "cognome='" + cognome + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroTessera=" + numeroTessera +
                ", prestiti=" + prestitiList +
                '}';
    }
}
