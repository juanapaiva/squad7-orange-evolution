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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 4, max = 100, message = "O nome deve conter entre 4 e 100 caracteres")
	@NotBlank(message = "O nome é obrigarório.")
	private String name;
	@Email
	@Size(min = 8, max = 70, message = "O nome deve conter entre 8 e 70 caracteres")
	@NotBlank(message = "O email é obrigarório.")
	private String email;
	@NotBlank(message = "A senha é obrigarória.")
	private String password;
	private String is_admin;
	
	@ManyToMany
	@JoinTable(name = "tb_interests_users",
			joinColumns = { @JoinColumn(name = "users_id") },
			inverseJoinColumns = { @JoinColumn(name = "interest_id") })
	private List<Interest> interests = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "tb_roadmaps_users",
			joinColumns = { @JoinColumn(name = "users_id") },
			inverseJoinColumns = { @JoinColumn(name = "roadmap_id") })
	private List<Roadmap> roadmaps = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private Set<ContentStatus> status = new HashSet<>();
	
	public User() {}

	public User(Integer id, String name, String email, String password, String is_admin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.is_admin = is_admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public List<Roadmap> getRoadmaps() {
		return roadmaps;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
