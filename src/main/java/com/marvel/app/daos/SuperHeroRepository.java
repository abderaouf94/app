package com.marvel.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.app.model.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
}
