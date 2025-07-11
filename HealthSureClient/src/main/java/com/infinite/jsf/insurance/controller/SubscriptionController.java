//package com.infinite.jsf.insurance.controller;
// 
//import java.util.List;
// 
//import com.infinite.jsf.insurance.dao.InsurancePlanDao;
//import com.infinite.jsf.insurance.dao.SubscriptionDao;
//import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
//import com.infinite.jsf.insurance.daoImpl.SubscriptionDaoImpl;
//import com.infinite.jsf.insurance.model.InsurancePlan;
//import com.infinite.jsf.insurance.model.Recipient;
//import com.infinite.jsf.insurance.model.Subscription;
// 
//public class SubscriptionController {
// 
//    private static final long serialVersionUID = 1L;
// 
//    private Subscription subscription = new Subscription();
//    private Recipient recipient = new Recipient(); // 🔧 Add this line
// 
//    private List<Subscription> subscriptionList;
//    private SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();
//    private InsurancePlanDao insurancePlanDao = new InsurancePlanDaoImpl();
//    private List<InsurancePlan> planList;
//    private InsurancePlan selectedPlan;
// 
//    // --- Getters and Setters ---
// 
//    public Subscription getSubscription() {
//        return subscription;
//    }
// 
//    public void setSubscription(Subscription subscription) {
//        this.subscription = subscription;
//    }
// 
//    public Recipient getRecipient() {
//        return recipient;
//    }
// 
//    public void setRecipient(Recipient recipient) {
//        this.recipient = recipient;
//    }
// 
//    public List<Subscription> getSubscriptionList() {
//        if (subscriptionList == null) {
//            subscriptionList = subscriptionDao.getAllSubscriptions();
//        }
//        return subscriptionList;
//    }
// 
//    public void setSubscriptionList(List<Subscription> subscriptionList) {
//        this.subscriptionList = subscriptionList;
//    }
// 
//    public InsurancePlan getSelectedPlan() {
//        return selectedPlan;
//    }
// 
//    public void setSelectedPlan(InsurancePlan selectedPlan) {
//        this.selectedPlan = selectedPlan;
//    }
// 
//    public List<InsurancePlan> getPlanList() {
//        if (planList == null) {
//            planList = insurancePlanDao.showAllPlans();
//        }
//        return planList;
//    }
// 
//    public void setPlanList(List<InsurancePlan> planList) {
//        this.planList = planList;
//    }
// 
//    public SubscriptionDao getSubscriptionDao() {
//        return subscriptionDao;
//    }
// 
//    public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
//        this.subscriptionDao = subscriptionDao;
//    }
// 
//    public InsurancePlanDao getInsurancePlanDao() {
//        return insurancePlanDao;
//    }
// 
//    public void setInsurancePlanDao(InsurancePlanDao insurancePlanDao) {
//        this.insurancePlanDao = insurancePlanDao;
//    }
// 
//    // --- Navigation Methods ---
// 
//    public String navigateToPlans() {
//        return "viewPlans";
//    }
// 
//    public String navigateToSubscribe(InsurancePlan plan) {
//        this.selectedPlan = plan;
//        return "subscribe";
//    }
// 
//    // --- Business Methods ---
// 
//    public String saveSubscription() {
//        // ✅ Fix: Bind recipient into the subscription
//        subscription.setRecipient(recipient);
// 
//        // Optional: Bind selected plan's option here if you have that logic too
// 
//        subscriptionDao.addSubscription(subscription);
//        subscription = new Subscription();  // Reset form
//        return "subscription-list?faces-redirect=true";
//    }
// 
//    public String editSubscription(Subscription sub) {
//        this.subscription = sub;
//        this.recipient = sub.getRecipient();  // Also pre-fill recipient when editing
//        return "subscription-form";
//    }
// 
//    public String deleteSubscription(Subscription sub) {
//        subscriptionDao.deleteSubscription(sub);
//        return "subscription-list?faces-redirect=true";
//    }
// 
//    public String newSubscription() {
//        this.subscription = new Subscription();
//        this.recipient = new Recipient();
//        return "subscription-form";
//    }
//}


package com.infinite.jsf.insurance.controller;
 
import java.io.Serializable;
import java.util.List;
 
import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.dao.SubscriptionDao;
import com.infinite.jsf.insurance.daoImpl.InsurancePlanDaoImpl;
import com.infinite.jsf.insurance.daoImpl.SubscriptionDaoImpl;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.Recipient;
import com.infinite.jsf.insurance.model.Subscription;
 
public class SubscriptionController implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private Subscription subscription = new Subscription();
    private Recipient recipient = new Recipient();
 
    private List<Subscription> subscriptionList;
    private SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();
    private InsurancePlanDao insurancePlanDao = new InsurancePlanDaoImpl();
    private List<InsurancePlan> planList;
    private InsurancePlan selectedPlan;
    private InsuranceCoverageOption insuranceCoverageOption;

    public InsuranceCoverageOption getInsuranceCoverageOption() {
        return insuranceCoverageOption;
    }

    public void setInsuranceCoverageOption(InsuranceCoverageOption insuranceCoverageOption) {
        this.insuranceCoverageOption = insuranceCoverageOption;
    }
    // === Getters and Setters ===
 
    public Subscription getSubscription() {
        return subscription;
    }
 
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
 
    public Recipient getRecipient() {
        return recipient;
    }
 
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
 
    public List<Subscription> getSubscriptionList() {
        if (subscriptionList == null) {
            subscriptionList = subscriptionDao.getAllSubscriptions();
        }
        return subscriptionList;
    }
 
    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }
 
    public InsurancePlan getSelectedPlan() {
        return selectedPlan;
    }
 
    public void setSelectedPlan(InsurancePlan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }
 
    public List<InsurancePlan> getPlanList() {
        if (planList == null) {
            planList = insurancePlanDao.showAllPlans();
        }
        return planList;
    }
 
    public void setPlanList(List<InsurancePlan> planList) {
        this.planList = planList;
    }
 
    public SubscriptionDao getSubscriptionDao() {
        return subscriptionDao;
    }
 
    public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }
 
    public InsurancePlanDao getInsurancePlanDao() {
        return insurancePlanDao;
    }
 
    public void setInsurancePlanDao(InsurancePlanDao insurancePlanDao) {
        this.insurancePlanDao = insurancePlanDao;
    }
 
    // === Navigation Methods ===
 
    public String navigateToPlans() {
        return "viewPlans";
    }
 
    public String navigateToSubscribe(InsurancePlan plan) {
        this.selectedPlan = plan;
        return "subscribe";
    }
 
    // === Business Methods ===
 
    public String saveSubscription() {
        subscription.setRecipient(recipient);  // Bind recipient to subscription
        subscriptionDao.addSubscription(subscription);
        subscription = new Subscription();     // Reset after save
        recipient = new Recipient();           // Reset recipient
        subscriptionList = null;               // Refresh list
        return "subscription-list?faces-redirect=true";
    }
 
    public String editSubscription(Subscription sub) {
        this.subscription = sub;
        this.recipient = sub.getRecipient();  // Pre-fill recipient when editing
        return "subscription-form";
    }
 
    public String deleteSubscription(Subscription sub) {
        subscriptionDao.deleteSubscription(sub.getSubscriptionId());  // FIXED: pass only ID
        subscriptionList = null;  // Refresh list on next load
        return "subscription-list?faces-redirect=true";
    }
 
    public String newSubscription() {
        this.subscription = new Subscription();
        this.recipient = new Recipient();
        return "subscription-form";
    }
}