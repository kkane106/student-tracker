package com.tracker.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.tracker.app.entities.Image;

public interface ImageRepositoy extends CrudRepository<Image, Integer>{

}
