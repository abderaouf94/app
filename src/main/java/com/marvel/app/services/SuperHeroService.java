package com.marvel.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.marvel.app.daos.SuperHeroRepository;
import com.marvel.app.dto.SuperHeroDto;
import com.marvel.app.model.SuperHero;
import com.marvel.app.utils.AppUtils;

@Service
public class SuperHeroService {

	@Autowired
	private Mapper mapper;

	@Autowired
	private SuperHeroRepository superHeroRepository;

	public List<SuperHeroDto> getAllSuperHeroes() {
		List<SuperHero> entities = superHeroRepository.findAll();
		return AppUtils.map(mapper, entities, SuperHeroDto.class);
	}

	public SuperHeroDto getSuperHeroeById(Long id) {
		SuperHero entity = superHeroRepository.findById(id).orElse(null);
		return mapper.map(entity, SuperHeroDto.class);
	}

	public List<SuperHeroDto> getSuperHeroeByGennericSearch(String name) {
		List<SuperHero> entities = superHeroRepository.findByNameContaining(name);
		return AppUtils.map(mapper, entities, SuperHeroDto.class);
	}

	public SuperHeroDto modifySuperHeroTest(Long id, SuperHeroDto modificationDto) {
		return null;
	}

	public void deleteSuperHeroTest(Long id) {
	}

}
