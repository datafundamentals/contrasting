package com.contrasting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contrasting.model.Skill;

@RepositoryRestResource(collectionResourceRel = "skill", path = "skill")
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long>  {}