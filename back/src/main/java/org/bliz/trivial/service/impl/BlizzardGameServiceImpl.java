package org.bliz.trivial.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bliz.trivial.repository.BlizzardGameRepository;
import org.bliz.trivial.repository.entity.BlizzardGameEntity;
import org.bliz.trivial.service.BlizzardGameService;
import org.bliz.trivial.service.dto.BlizzardGameDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlizzardGameServiceImpl implements BlizzardGameService {

	@Autowired
	private BlizzardGameRepository blizRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public List<BlizzardGameDTO> getAll() {
		Iterable<BlizzardGameEntity> games = blizRepository.findAll();
		List<BlizzardGameDTO> gamesDTO = new ArrayList<>();
		games.forEach(item -> {
			gamesDTO.add(mapper.map(item, BlizzardGameDTO.class));
		});
		return gamesDTO;
	}

}
