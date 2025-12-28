package com.hojde.myspace.adapters.mongodb.repository;

import com.hojde.myspace.adapters.mongodb.model.LanguageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageMongoRepository extends MongoRepository<LanguageEntity, String> {}
