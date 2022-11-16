package com.api.orangeevolution.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.api.orangeevolution.entities.enums.ContentStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_content_status")
public class ContentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "roadmap_id")
	private Roadmap roadmap;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "content_id")
	private Content content;
	
	private Integer status_id;
	
	public ContentStatus() {}

	public ContentStatus(Integer status_id) {
		super();
		this.status_id = status_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roadmap getRoadmap() {
		return roadmap;
	}

	public void setRoadmap(Roadmap roadmap) {
		this.roadmap = roadmap;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public ContentStatusEnum getStatus() {
		return ContentStatusEnum.valueOf(status_id);
	}

	public void setContentStatus(ContentStatusEnum status_id) {
		if (status_id != null) {
			this.status_id = status_id.getId();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentStatus other = (ContentStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
