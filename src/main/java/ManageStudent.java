//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//import java.util.Iterator;
//import java.util.List;
//
//public class ManageStudent{
//    private static SessionFactory factory;
//
//
//    public static void main(String[] args) {
//
//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//
//        ManageStudent MS = new ManageStudent();
//
//        /* Add few employee records in database */
////        MS.addStudent("uwe","English");
////        MS.addStudent("jones", "English");
//
////        MS.addStudent("anna","math");
////        MS.addStudent("tim","CS");
//
//        /* List down all the employees */
//        MS.listStudent();
//
//        /* Update employee's records */
////        MS.updateStudent(1,"music");
////
////        /* Delete an employee from the database */
////        MS.deleteStudent(2);
////
////        /* List down new list of the employees */
////        MS.listStudent();
//    }
//
//    /* Method to CREATE a student in the database */
//    public void addStudent(String name, String major){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        Integer studentId = null;
//
//        try {
//            tx = session.beginTransaction();
//            Student student = new Student(name, major);
//            session.persist(student);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    /* Method to  READ all the students */
//    public void listStudent( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            /** Create HQL Queries **/
//            Query query = session.createQuery("FROM Student where id between :id1 and :id2 order by id desc",Student.class);
//            query.setParameter("id1",3);
//            query.setParameter("id2",5);
//
//            /** Native SQL queries**/
////            SQLQuery query = session.createSQLQuery("select id, name, major from Student");
//            List students = query.list();
//
//            for (Iterator iterator = students.iterator(); iterator.hasNext();){
//                Student student = (Student) iterator.next();
//                System.out.print("ID: " + student.getId());
//                System.out.print(" Name: " + student.getName());
//                System.out.println("  Major: " + student.getMajor());
////                System.out.print(student);
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    /* Method to UPDATE salary for an employee */
//    public void updateStudent(Integer StudentID, String major ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Student student = session.get(Student.class, StudentID);
//            student.setMajor(major);
//            session.merge(student);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//
//    /* Method to DELETE an employee from the records */
//    public void deleteStudent(Integer StudentID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Student student = session.get(Student.class, StudentID);
//            session.remove(student);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//}