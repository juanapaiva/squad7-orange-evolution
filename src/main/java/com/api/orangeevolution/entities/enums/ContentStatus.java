package com.api.orangeevolution.entities.enums;

public enum ContentStatus {

	NOT_STARTED(1),
	IN_PROGRESS(2),
	COMPLETED(3);
	
	private int id;
	
	private ContentStatus(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static ContentStatus valueOf(int id) {
		for (ContentStatus value : ContentStatus.values()) {
			if (value.getId() == id) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ContentStatus code");
	}
}
