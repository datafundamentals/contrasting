package com.contrasting.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contrasting.model.Attitude;

@RepositoryRestResource(collectionResourceRel = "attitude", path = "attitude")
public interface AttitudeRepository extends PagingAndSortingRepository<Attitude, Long>  {}