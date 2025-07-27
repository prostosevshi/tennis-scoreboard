package service;

import model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

public class PlayerService {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Player findOrCreatePlayer(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query<Player> query = session.createQuery("from Player where name = :name", Player.class);
        query.setParameter("name", name);
        Player player = query.uniqueResult();

        if (player == null) {
            player = new Player();
            player.setName(name);
            session.persist(player);
        }

        tx.commit();
        session.close();
        return player;
    }
}
