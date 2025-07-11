package com.infinite.jsf.insurance.model;

public class SubscribedMember {
	private String recipientId;
    private Subscription subscription;  // many-to-one
    private String fullName;
    private int age;
    private Gender gender;  // changed to enum
    private String relationWithProposer;
    private String aadharNo;
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getRelationWithProposer() {
		return relationWithProposer;
	}
	public void setRelationWithProposer(String relationWithProposer) {
		this.relationWithProposer = relationWithProposer;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public SubscribedMember(String recipientId, Subscription subscription, String fullName, int age, Gender gender,
			String relationWithProposer, String aadharNo) {
		super();
		this.recipientId = recipientId;
		this.subscription = subscription;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.relationWithProposer = relationWithProposer;
		this.aadharNo = aadharNo;
	}
	public SubscribedMember() {
		super();
	}
	@Override
	public String toString() {
		return "PlanRecipientMember [recipientId=" + recipientId + ", subscription=" + subscription + ", fullName="
				+ fullName + ", age=" + age + ", gender=" + gender + ", relationWithProposer=" + relationWithProposer
				+ ", aadharNo=" + aadharNo + "]";
	}
    
}