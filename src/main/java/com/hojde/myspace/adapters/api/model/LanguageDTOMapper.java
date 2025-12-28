package com.hojde.myspace.adapters.api.model;

import com.hojde.myspace.domain.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageDTOMapper {
  LanguageDTOMapper INSTANCE = Mappers.getMapper( LanguageDTOMapper.class );
  LanguageDTO languageToLanguageDto(Language language);
  Language languageDtoToLanguage(LanguageDTO LanguageDto);
}
