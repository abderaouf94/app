package com.marvel.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.app.model.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
	List<SuperHero> findByNameContaining(String name);
}
