package com.hojde.myspace.adapters.mongodb.repository;

import com.hojde.myspace.adapters.mongodb.model.TabEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabMongoRepository extends MongoRepository<TabEntity, String> {}
