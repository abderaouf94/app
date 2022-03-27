package com.marvel.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.app.model.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
	SuperHero findByName(String name);
	List<SuperHero> findByNameContaining(String name);
}
