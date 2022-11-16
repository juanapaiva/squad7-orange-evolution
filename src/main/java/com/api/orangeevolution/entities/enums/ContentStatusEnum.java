package com.api.orangeevolution.entities.enums;

public enum ContentStatusEnum {

	NOT_STARTED(1),
	COMPLETED(2);
	
	private int id;
	
	private ContentStatusEnum(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static ContentStatusEnum valueOf(int id) {
		for (ContentStatusEnum value : ContentStatusEnum.values()) {
			if (value.getId() == id) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ContentStatus code");
	}
}
