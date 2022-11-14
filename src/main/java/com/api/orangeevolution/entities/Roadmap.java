package com.api.orangeevolution.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_roadmaps")
public class Roadmap implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private Integer duration;
	private String creator;

	@JsonIgnore
	@ManyToMany
	private List<User> users = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "roadmap")
	private List<Content> contents = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "roadmap")
	private Set<ContentStatus> status = new HashSet<>();

	public Roadmap() {
	}

	public Roadmap(Integer id, String title, String description, Integer duration, String creator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.creator = creator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Content> getContents() {
		return contents;
	}

	public Set<ContentStatus> getStatus() {
		return status;
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
		Roadmap other = (Roadmap) obj;
		return Objects.equals(id, other.id);
	}
}
