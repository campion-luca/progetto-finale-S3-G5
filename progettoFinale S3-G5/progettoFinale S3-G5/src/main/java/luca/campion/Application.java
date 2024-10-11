package luca.campion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import luca.campion.dao.ElementiDAO;
import luca.campion.entities.*;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettofinale");

    public static void main(String[] args) {

        // ----------------------------------------------------------------------------
        // AGGIUNTA ELEMENTO ALLA RACCOLTA
        EntityManager em = emf.createEntityManager();
        ElementiDAO ed = new ElementiDAO(em);

//        Libri topolini = new Libri(2000,89,"Topolino n.27 - a caccia del tesoro","Walt Disney","Fumetto");
//        Riviste sole24 = new Riviste(2024,102,"sole24 - l'italia non si salverà",Periodicita.SETTIMANALE);
//        Libri dylan = new Libri(1999, 120,"Dylan dog - il libro che verrà eliminato all'alba","Luca","Fumetto");
//
//        ed.save(topolini);
//        ed.save(sole24);
//        ed.save(dylan);


        // ----------------------------------------------------------------------------
        // RIMOZIONE ELEMENTO TRAMITE CODICE ISBN

//ed.findAndDelete(102);

        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE CODICE ISBN
//        System.out.println(ed.findByISBN(52));



        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE ANNO DI PUBBLICAZIONE
//        ed.findByYear(2000).forEach(System.out::println);


        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE AUTORE
//        ed.findByAuthor("Walt Disney").forEach(System.out::println);



        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE TITOLO O PARTE DI ESSO
//        ed.findBySomething("salv").forEach(System.out::println);


        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE NUMERO DI TESSERA, MOSTRA ELEMENTI IN PRESTITO
//         Utenti luca = new Utenti("Campion", LocalDate.of(1997, 8, 11),4510,"Luca");
//         Utenti cristina = new Utenti("Nenov", LocalDate.of(2002,06,30),4187,"Cristina");
//
//
//         ed.saveUtente(luca);
//         ed.saveUtente(cristina);



        // ----------------------------------------------------------------------------
        // RICERCA TRAMITE DATABASE DEI PRESTITI ATTIVI DI UTENTE X
        Utenti utenti = ed.findByUser(1);
        Elementi elementi = ed.findByISBN(52);


        Prestiti pr1 = new Prestiti(elementi,LocalDate.of(2024,11,20), utenti);


//        ed.savePrestito(pr1);

        ed.findAllActiveFrom(4510).forEach(System.out::println);

        em.close();
        emf.close();

    }
}
