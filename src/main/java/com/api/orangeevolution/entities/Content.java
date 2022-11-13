package com.api.orangeevolution.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contents")
public class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String category;
	private String subject;
	private String title;
	private String type;
	private String owner;
	private String duration;
	private String status;
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "id_roadmap")
	private Roadmap roadmap;
	
	public Content() {}

	public Content(Integer id, String category, String subject, String title, String type, String owner, String duration,
			String status, String link, Roadmap roadmap) {
		super();
		this.id = id;
		this.category = category;
		this.subject = subject;
		this.title = title;
		this.type = type;
		this.owner = owner;
		this.duration = duration;
		this.status = status;
		this.link = link;
		this.roadmap = roadmap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Roadmap getRoadmap() {
		return roadmap;
	}

	public void setRoadmap(Roadmap roadmap) {
		this.roadmap = roadmap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(id, other.id);
	}
}
