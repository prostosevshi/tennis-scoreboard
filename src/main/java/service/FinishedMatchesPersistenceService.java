package service;

import model.Match;
import model.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FinishedMatchesPersistenceService {

    public static void save(Match match, Player winner) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            match.setWinner(winner);
            session.persist(match);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
