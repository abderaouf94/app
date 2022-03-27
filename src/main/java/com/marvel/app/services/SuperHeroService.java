package com.marvel.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.marvel.app.dto.SuperHeroDto;
import com.marvel.app.model.SuperHero;
import com.marvel.app.repositories.SuperHeroRepository;
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
		List<SuperHero> entities = superHeroRepository.findBySuperHeroNameIgnoreCaseContaining(name);
		return AppUtils.map(mapper, entities, SuperHeroDto.class);
	}

	public SuperHeroDto createSuperHero(SuperHeroDto modificationDto) {
		SuperHero entity = new SuperHero();
		entity.setSuperHeroName(modificationDto.getSuperHeroName());
		SuperHero result = superHeroRepository.save(entity);
		return mapper.map(result, SuperHeroDto.class);
	}

	public SuperHeroDto modifySuperHero(Long id, SuperHeroDto modificationDto) {
		SuperHero entity = superHeroRepository.findById(id).orElse(null);
		if (entity != null) {
			entity.setSuperHeroName(modificationDto.getSuperHeroName());
			SuperHero result = superHeroRepository.save(entity);
			return mapper.map(result, SuperHeroDto.class);
		}
		return null;
	}

	public void deleteSuperHero(Long id) {
		superHeroRepository.deleteById(id);
	}

}
