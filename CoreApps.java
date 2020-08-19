package com.spring.boot.landesk.auto.dao;

import java.util.Date;

public class CoreApps {

	private long referenceNumber;
	private String category;
	private String userLoginId;
	private String created;
	private  String assignee;
	private String assignedGroup;
	private String status;
	private String currentAssignedGroup;
	private String isBreached;
	
	public CoreApps() {
		
	}
	
	public CoreApps(long referenceNumber, String category, String userLoginId, String created, String assignee,
			String assignedGroup, String status, String currentAssignedGroup, String isBreached) {
		super();
		this.referenceNumber = referenceNumber;
		this.category = category;
		this.userLoginId = userLoginId;
		this.created = created;
		this.assignee = assignee;
		this.assignedGroup = assignedGroup;
		this.status = status;
		this.currentAssignedGroup = currentAssignedGroup;
		this.isBreached = isBreached;
	}
	
	public long getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssignedGroup() {
		return assignedGroup;
	}
	public void setAssignedGroup(String assignedGroup) {
		this.assignedGroup = assignedGroup;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentAssignedGroup() {
		return currentAssignedGroup;
	}
	public void setCurrentAssignedGroup(String currentAssignedGroup) {
		this.currentAssignedGroup = currentAssignedGroup;
	}
	public String getIsBreached() {
		return isBreached;
	}
	public void setIsBreached(String isBreached) {
		this.isBreached = isBreached;
	}

	@Override
	public String toString() {
		return String.format(
				"CoreApps [referenceNumber=%s, category=%s, userLoginId=%s, created=%s, assignee=%s, assignedGroup=%s, status=%s, currentAssignedGroup=%s, isBreached=%s]",
				referenceNumber, category, userLoginId, created, assignee, assignedGroup, status, currentAssignedGroup,
				isBreached);
	}
	
	
}
