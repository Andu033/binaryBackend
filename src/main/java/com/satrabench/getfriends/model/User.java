package com.satrabench.getfriends.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String name;

	private String password;

	@OneToMany(  mappedBy = "user",
			cascade = CascadeType.PERSIST,
			orphanRemoval = true)
	private List<Incident> incidents = new ArrayList<>();

	private boolean doctor;

	private boolean admin=false;

	private boolean banned=false;


	@Lob
	@Column( length = 100000 )
	private String photo;

	@Override
	public String toString() {
		return "User{" +
				"Id=" + Id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", incidents=" + incidents +
				", doctor=" + doctor +
				", admin=" + admin +
				", banned=" + banned +
				'}';
	}
}
