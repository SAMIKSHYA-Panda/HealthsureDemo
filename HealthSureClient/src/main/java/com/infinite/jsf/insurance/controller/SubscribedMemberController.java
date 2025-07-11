//package com.infinite.jsf.insurance.controller;
//
//import java.io.Serializable;
//import java.util.List;
//
//import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
//import com.infinite.jsf.insurance.daoImpl.SubscribedMemberDaoImpl;
//import com.infinite.jsf.insurance.model.SubscribedMember;
//
//public class SubscribedMemberController implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private SubscribedMember member = new SubscribedMember();
//    private List<SubscribedMember> memberList;
//
//    private SubscribedMemberDao memberDao = new SubscribedMemberDaoImpl();
//
//    // === GETTERS & SETTERS ===
//
//    public SubscribedMember getMember() {
//        return member;
//    }
//
//    public void setMember(SubscribedMember member) {
//        this.member = member;
//    }
//
//    public List<SubscribedMember> getMemberList() {
//        if (memberList == null) {
//            memberList = memberDao.getAllSubscribedMembers();
//        }
//        return memberList;
//    }
//
//    public void setMemberList(List<SubscribedMember> memberList) {
//        this.memberList = memberList;
//    }
//
//    public SubscribedMemberDao getMemberDao() {
//        return memberDao;
//    }
//
//    public void setMemberDao(SubscribedMemberDao memberDao) {
//        this.memberDao = memberDao;
//    }
//
//    // === ACTION METHODS ===
//
//    public String saveMember() {
//        memberDao.addSubscribedMember(member);
//        member = new SubscribedMember();
//        memberList = null;
//        return "subscribed-member-list"; // Update based on your navigation flow
//    }
//
//    public String updateMember() {
//        memberDao.updatesubscribedMember(member);
//        member = new SubscribedMember();
//        memberList = null;
//        return "subscribed-member-list";
//    }
//
//    public String editMember(SubscribedMember selectedMember) {
//        this.member = selectedMember;
//        return "subscribed-member-form";
//    }
//
//    public String deleteMember(SubscribedMember selectedMember) {
//        memberDao.deletesubscribedMember(selectedMember);
//        memberList = null;
//        return "subscribed-member-list";
//    }
//
//    public String newMember() {
//        this.member = new SubscribedMember();
//        return "subscribed-member-form";
//    }
//
//    public SubscribedMember findById(String recipientId) {
//        return memberDao.getsubscribedMemberById(recipientId);
//    }
//}


package com.infinite.jsf.insurance.controller;
 
import java.io.Serializable;

import java.util.List;
 
import com.infinite.jsf.insurance.dao.SubscribedMemberDao;

import com.infinite.jsf.insurance.daoImpl.SubscribedMemberDaoImpl;

import com.infinite.jsf.insurance.model.SubscribedMember;
 
public class SubscribedMemberController implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private SubscribedMember member = new SubscribedMember();

    private List<SubscribedMember> memberList;
 
    private SubscribedMemberDao memberDao = new SubscribedMemberDaoImpl();
 
    // === GETTERS & SETTERS ===
 
    public SubscribedMember getMember() {

        return member;

    }
 
    public void setMember(SubscribedMember member) {

        this.member = member;

    }
 
    public List<SubscribedMember> getMemberList() {

        if (memberList == null) {

            memberList = memberDao.getAllSubscribedMembers();

        }

        return memberList;

    }
 
    public void setMemberList(List<SubscribedMember> memberList) {

        this.memberList = memberList;

    }
 
    public SubscribedMemberDao getMemberDao() {

        return memberDao;

    }
 
    public void setMemberDao(SubscribedMemberDao memberDao) {

        this.memberDao = memberDao;

    }
 
    // === ACTION METHODS ===
 
    public String saveMember() {

        memberDao.addSubscribedMember(member);

        member = new SubscribedMember();

        memberList = null;

        return "subscribed-member-list"; // 🔁 Update if needed in navigation

    }
 
    public String updateMember() {

        memberDao.updateSubscribedMember(member);  // ✅ FIXED method name

        member = new SubscribedMember();

        memberList = null;

        return "subscribed-member-list";

    }
 
    public String editMember(SubscribedMember selectedMember) {

        this.member = selectedMember;

        return "subscribed-member-form";

    }
 
    public String deleteMember(SubscribedMember selectedMember) {

        memberDao.deleteSubscribedMember(selectedMember.getRecipientId()); // ✅ FIXED: passing recipientId

        memberList = null;

        return "subscribed-member-list";

    }
 
    public String newMember() {

        this.member = new SubscribedMember();

        return "subscribed-member-form";

    }
 
    public SubscribedMember findById(String recipientId) {

        return memberDao.getSubscribedMemberById(recipientId); // ✅ FIXED method name

    }

}

 