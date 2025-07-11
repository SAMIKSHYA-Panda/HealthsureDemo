//package com.infinite.jsf.insurance.daoImpl;
// 
//import java.util.List;
// 
//import org.hibernate.Session;
//
//import org.hibernate.Transaction;
//
//import org.hibernate.Query;
// 
//import com.infinite.jsf.insurance.dao.SubscriptionDao;
//
//import com.infinite.jsf.insurance.model.Subscription;
//
//import com.infinite.jsf.util.SessionHelper;
//
//import com.infinite.jsf.util.SubscriptionIdGenerator;
// 
//public class SubscriptionDaoImpl implements SubscriptionDao {
// 
//    @Override
//
//    public String addSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔧 Generate and set unique Subscription ID
//
//            String subscriptionId = SubscriptionIdGenerator.getNextSubscriptionId(session);
//
//            subscription.setSubscriptionId(subscriptionId);
// 
//            // 🔍 Debug log
//
//            System.out.println("=== Adding Subscription ===");
//
//            System.out.println("ID: " + subscriptionId);
//
//            System.out.println("Recipient: " + (subscription.getRecipient() != null ? subscription.getRecipient().gethId() : "null"));
//
//            System.out.println("Status: " + subscription.getStatus());
// 
//            tx = session.beginTransaction();
//
//            session.save(subscription);
//
//            tx.commit();
//
//            session.close();
// 
//            return "Subscription added successfully with ID: " + subscriptionId;
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//            return "Error adding subscription: " + e.getMessage();
//
//        }
//
//    }
// 
//    @Override
//
//    public String updateSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔍 Debug log
//
//            System.out.println("=== Updating Subscription ===");
//
//            System.out.println("ID: " + subscription.getSubscriptionId());
//
//            System.out.println("Status: " + subscription.getStatus());
// 
//            tx = session.beginTransaction();
//
//            session.update(subscription);
//
//            tx.commit();
//
//            session.close();
//
//            return "Subscription updated successfully.";
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//            return "Error updating subscription: " + e.getMessage();
//
//        }
//
//    }
// 
//    @Override
//
//    public void deleteSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            tx = session.beginTransaction();
//
//            session.delete(subscription);
//
//            tx.commit();
//
//            session.close();
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//        }
//
//    }
// 
//    @Override
//
//    public Subscription getSubscriptionById(String subscriptionId) {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
//
//            session.close();
//
//            return subscription;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
// 
//    @Override
//
//    public List<Subscription> getSubscriptionsByRecipientId(String recipientId) {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔧 FIXED: Correct field path using recipient.hId
//
//            Query query = session.createQuery("from Subscription where recipient.hId = :recipientId");
//
//            query.setParameter("recipientId", recipientId);
// 
//            List result = query.list();
//
//            session.close();
//
//            return result;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
// 
//    @Override
//
//    public List<Subscription> getAllSubscriptions() {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            Query query = session.createQuery("from Subscription");
//
//            List result = query.list();
//
//            session.close();
//
//            return result;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
//
//}



package com.infinite.jsf.insurance.daoImpl;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
 
import com.infinite.jsf.insurance.dao.SubscriptionDao;
import com.infinite.jsf.insurance.model.Subscription;
import com.infinite.jsf.util.SessionHelper;
import com.infinite.jsf.util.SubscriptionIdGenerator;
 
public class SubscriptionDaoImpl implements SubscriptionDao {
 
    @Override
    public String addSubscription(Subscription subscription) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
 
            String subscriptionId = SubscriptionIdGenerator.getNextSubscriptionId(session);
            subscription.setSubscriptionId(subscriptionId);
 
            System.out.println("=== Adding Subscription ===");
            System.out.println("ID: " + subscriptionId);
            System.out.println("Recipient: " + (subscription.getRecipient() != null ? subscription.getRecipient().gethId() : "null"));
            System.out.println("Status: " + subscription.getStatus());
 
            tx = session.beginTransaction();
            session.save(subscription);
            tx.commit();
            session.close();
 
            return "Subscription added successfully with ID: " + subscriptionId;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error adding subscription: " + e.getMessage();
        }
    }
 
    @Override
    public String updateSubscription(Subscription subscription) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
 
            System.out.println("=== Updating Subscription ===");
            System.out.println("ID: " + subscription.getSubscriptionId());
            System.out.println("Status: " + subscription.getStatus());
 
            tx = session.beginTransaction();
            session.update(subscription);
            tx.commit();
            session.close();
 
            return "Subscription updated successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error updating subscription: " + e.getMessage();
        }
    }
 
    @Override
    public void deleteSubscription(String subscriptionId) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
            if (subscription != null) {
                tx = session.beginTransaction();
                session.delete(subscription);
                tx.commit();
            }
            session.close();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
 
    @Override
    public Subscription getSubscriptionById(String subscriptionId) {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
            session.close();
            return subscription;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    @Override
    public List<Subscription> getSubscriptionsByRecipientId(String recipientId) {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Query query = session.createQuery("from Subscription where recipient.hId = :recipientId");
            query.setParameter("recipientId", recipientId);
            List<Subscription> result = query.list();
            session.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    @Override
    public List<Subscription> getAllSubscriptions() {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Query query = session.createQuery("from Subscription");
            List<Subscription> result = query.list();
            session.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}