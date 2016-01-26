package com.contrasting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contrasting.model.Metric;

@RepositoryRestResource(collectionResourceRel = "metric", path = "metric")
public interface MetricRepository extends PagingAndSortingRepository<Metric, Long>  {}