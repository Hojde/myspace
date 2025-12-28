package com.hojde.myspace.adapters.mongodb.service;

import com.hojde.myspace.adapters.mongodb.model.LanguageEntityMapper;
import com.hojde.myspace.adapters.mongodb.repository.LanguageMongoRepository;
import com.hojde.myspace.domain.model.Language;
import com.hojde.myspace.domain.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LanguageMongoAdapter implements LanguageRepository {

  private static LanguageEntityMapper MAPPER = LanguageEntityMapper.INSTANCE;

  private LanguageMongoRepository languageMongoRepository;

  @Override
  public Language save(Language language) {
    return MAPPER.languageEntityToLanguage(languageMongoRepository.save(MAPPER.languageToLanguageEntity(language)));
  }

  @Override
  public List<Language> getAll() {
    return languageMongoRepository.findAll().stream().map(MAPPER::languageEntityToLanguage).toList();
  }
}
