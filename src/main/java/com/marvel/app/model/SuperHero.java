package com.marvel.app.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUPER_HEROE")
public class SuperHero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "super_hero_name")
	private String superHeroName;

	public SuperHero() {
	}

	public SuperHero(String superHeroName) {
		this.superHeroName = superHeroName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSuperHeroName() {
		return superHeroName;
	}

	public void setSuperHeroName(String superHeroName) {
		this.superHeroName = superHeroName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, superHeroName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperHero other = (SuperHero) obj;
		return Objects.equals(id, other.id) && Objects.equals(superHeroName, other.superHeroName);
	}

	@Override
	public String toString() {
		return "SuperHero [id=" + id + ", superHeroName=" + superHeroName + "]";
	}
}
