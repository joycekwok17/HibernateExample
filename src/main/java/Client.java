import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Client {



    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration().configure();
            conf.addAnnotatedClass(Player.class);
            conf.addAnnotatedClass(Team.class);
//            SessionFactory factory = conf.configure().buildSessionFactory();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
            SessionFactory factory = conf.buildSessionFactory(builder.build());
//            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                    .configure("hibernate.cfg.xml").build();
//
//            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();

//            SessionFactory factory = metaData.getSessionFactoryBuilder().build();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Team t1 = new Team("Deu");
            Team t2 = new Team("US");
            Team t3 = new Team("UK");
//            List<Team> teams= new ArrayList<Team>();

            Player p1 = new Player("Anna");
//            Player p2 = new Player("tony");
//            Player p3 = new Player("Joey");
            p1.getTeamlist().add(t1);
            p1.getTeamlist().add(t2);
            p1.getTeamlist().add(t3);
            session.persist(t1);
            session.persist(t2);
            session.persist(t3);
            session.persist(p1);
//            session.persist(p2);
//            session.persist(p3);

            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
