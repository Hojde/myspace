package com.hojde.myspace.domain.service;

import com.hojde.myspace.domain.model.Language;

import java.util.List;

public interface LanguageService {
  List<Language> getLanguages();
  Language addLanguage(Language language);
}
