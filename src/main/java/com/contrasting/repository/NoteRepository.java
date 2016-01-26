package com.contrasting.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.contrasting.model.Note;

@RepositoryRestResource(collectionResourceRel = "note", path = "note")
public interface NoteRepository extends PagingAndSortingRepository<Note, Long>  {}