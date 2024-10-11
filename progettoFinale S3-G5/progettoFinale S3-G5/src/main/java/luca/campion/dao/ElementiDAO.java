package luca.campion.dao;

import jakarta.persistence.*;
import luca.campion.entities.Elementi;
import luca.campion.entities.Prestiti;
import luca.campion.entities.Utenti;

import javax.swing.text.Element;
import java.util.List;

public class ElementiDAO {
    public final EntityManager entityManager;

    public ElementiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    // salvare un elemento
    public void save(Elementi elementi) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementi);
        transaction.commit();

        System.out.println("L'elemento " + elementi.getTitolo() + " è stato inserito nella raccolta!");
    }


    // salvare un utente
    public void saveUtente(Utenti utenti) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utenti);
        transaction.commit();

        System.out.println("L'utente " + utenti.getNome() + " " + utenti.getCognome() + " è stato inserito nella raccolta!");
    }


    // salvare un prestito
    public void savePrestito(Prestiti prestiti) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestiti);
        transaction.commit();

        System.out.println("Il prestito a nome di " + prestiti.getUtenti() + "è stato attivato con successo!");
    }


    // --------------------------------------------- FINE DAO PER I VARI SAVE ---------------------------------------------


    // find per utente
    public Utenti findByUser(long id) {
        Utenti found = entityManager.find(Utenti.class, id);
        if(found == null) throw new EntityNotFoundException();
        return found;
    }

    // rimuovere un elemento tramite ISBN
    public void findAndDelete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Elementi e WHERE e.id = :id");
        query.setParameter("id", id);

        int cancellato = query.executeUpdate();
        transaction.commit();

        System.out.println("L'elemento è stato cancellato");
    }


    // ricerca tramite ISBN
    public Elementi findByISBN(long id) {
        Elementi found = entityManager.find(Elementi.class, id);
        if(found == null) throw new EntityNotFoundException();
        return found;
    }


    // ricerca per anno di pubblicazione
    public List<Elementi> findByYear(int annoDato) {
        TypedQuery<Elementi> query = entityManager.createQuery("SELECT e FROM Elementi e WHERE e.annoPubblicazione = :annoDato", Elementi.class);
        query.setParameter("annoDato", annoDato);
        return query.getResultList();
    }


    // ricerca per autore
    public List<Elementi> findByAuthor(String author) {
        TypedQuery<Elementi> query = entityManager.createQuery("SELECT l FROM Libri l WHERE l.autore = :author", Elementi.class);
        query.setParameter("author", author);
        return query.getResultList();
    }


    // ricerca per titolo o parte di esso
    public List<Elementi> findBySomething(String partial) {
        TypedQuery<Elementi> query = entityManager.createQuery("SELECT e FROM Elementi e WHERE LOWER(e.titolo) LIKE LOWER(:partial)", Elementi.class);
        query.setParameter("partial", "%" + partial + "%");
        return query.getResultList();
    }


    // ricerca tramite numero tessera utente e fornisci elementi in prestito
    public List<Prestiti> findAllActiveFrom(Integer numTessera) {
        TypedQuery<Prestiti> query = entityManager.createQuery("SELECT p FROM Prestiti p WHERE p.utenti.numeroTessera = :numeroTessera", Prestiti.class);
        query.setParameter("numTessera", numTessera);
        return query.getResultList();
    }
    // problema 1, ritorna gli utenti riferiti a quel num tessera []



}
