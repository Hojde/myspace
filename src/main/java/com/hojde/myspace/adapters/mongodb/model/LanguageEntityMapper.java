package com.hojde.myspace.adapters.mongodb.model;

import com.hojde.myspace.domain.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageEntityMapper {

  LanguageEntityMapper INSTANCE = Mappers.getMapper(LanguageEntityMapper.class);

  LanguageEntity languageToLanguageEntity(Language language);
  Language languageEntityToLanguage(LanguageEntity LanguageEntity);
}
