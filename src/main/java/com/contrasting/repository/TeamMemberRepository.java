package com.contrasting.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contrasting.model.Attitude;
import com.contrasting.model.TeamMember;

@RepositoryRestResource(collectionResourceRel = "teamMember", path = "teamMember")
public interface TeamMemberRepository extends PagingAndSortingRepository<TeamMember, Long>  {}