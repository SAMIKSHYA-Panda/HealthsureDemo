//package com.infinite.jsf.insurance.daoImpl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.Query;
//
//import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
//import com.infinite.jsf.insurance.model.SubscribedMember;
//import com.infinite.jsf.util.SessionHelper;
//
//public class SubscribedMemberDaoImpl implements SubscribedMemberDao {
//
//    @Override
//    public String addSubscribedMember(SubscribedMember member) {
//        Transaction tx = null;
//        try {
//            Session session = SessionHelper.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.save(member);
//            tx.commit();
//            session.close();
//            return "SubscribedMember added successfully.";
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//            return "Error adding member: " + e.getMessage();
//        }
//    }
//
//    @Override
//    public String updatesubscribedMember(SubscribedMember member) {
//        Transaction tx = null;
//        try {
//            Session session = SessionHelper.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.update(member);
//            tx.commit();
//            session.close();
//            return "SubscribedMember updated successfully.";
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//            return "Error updating member: " + e.getMessage();
//        }
//    }
//
//    @Override
//    public void deletesubscribedMember(SubscribedMember member) {
//        Transaction tx = null;
//        try {
//            Session session = SessionHelper.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//            session.delete(member);
//            tx.commit();
//            session.close();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public SubscribedMember getsubscribedMemberById(String recipientId) {
//        try {
//            Session session = SessionHelper.getSessionFactory().openSession();
//            SubscribedMember member = (SubscribedMember) session.get(SubscribedMember.class, recipientId);
//            session.close();
//            return member;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<SubscribedMember> getAllSubscribedMembers() {
//        try {
//            Session session = SessionHelper.getSessionFactory().openSession();
//            Query query = session.createQuery("from SubscribedMember");
//            List result = query.list();
//            session.close();
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

package com.infinite.jsf.insurance.daoImpl;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
 
import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.util.SessionHelper;
 
public class SubscribedMemberDaoImpl implements SubscribedMemberDao {
 
    @Override
    public String addSubscribedMember(SubscribedMember member) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(member);
            tx.commit();
            session.close();
            return "SubscribedMember added successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error adding member: " + e.getMessage();
        }
    }
 
    @Override
    public String updateSubscribedMember(SubscribedMember member) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(member);
            tx.commit();
            session.close();
            return "SubscribedMember updated successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error updating member: " + e.getMessage();
        }
    }
 
    @Override
    public void deleteSubscribedMember(String recipientId) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            SubscribedMember member = (SubscribedMember) session.get(SubscribedMember.class, recipientId);
            if (member != null) {
                tx = session.beginTransaction();
                session.delete(member);
                tx.commit();
            }
            session.close();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
 
    @Override
    public SubscribedMember getSubscribedMemberById(String recipientId) {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            SubscribedMember member = (SubscribedMember) session.get(SubscribedMember.class, recipientId);
            session.close();
            return member;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    @Override
    public List<SubscribedMember> getAllSubscribedMembers() {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Query query = session.createQuery("from SubscribedMember");
            List<SubscribedMember> result = query.list();
            session.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
