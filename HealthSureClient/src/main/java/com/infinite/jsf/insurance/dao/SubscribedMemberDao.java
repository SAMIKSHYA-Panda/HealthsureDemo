//package com.infinite.jsf.insurance.dao;
//
//import java.util.List;
//
//import com.infinite.jsf.insurance.model.SubscribedMember;
//
//public interface SubscribedMemberDao {
//
//    String addSubscribedMember(SubscribedMember member);
//
//    String updatesubscribedMember(SubscribedMember member);
//
//    void deletesubscribedMember(SubscribedMember member);
//
//    SubscribedMember getsubscribedMemberById(String recipientId);
//
//    List<SubscribedMember> getAllSubscribedMembers();
//}
package com.infinite.jsf.insurance.dao;
 
import java.util.List;

import com.infinite.jsf.insurance.model.SubscribedMember;
 
public interface SubscribedMemberDao {
 
    String addSubscribedMember(SubscribedMember member);
 
    String updateSubscribedMember(SubscribedMember member);
 
    void deleteSubscribedMember(String recipientId);
 
    SubscribedMember getSubscribedMemberById(String recipientId);
 
    List<SubscribedMember> getAllSubscribedMembers();

}

 
