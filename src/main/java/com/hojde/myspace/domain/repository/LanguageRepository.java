package com.hojde.myspace.domain.repository;

import com.hojde.myspace.domain.model.Language;

import java.util.List;

public interface LanguageRepository {
  Language save(Language language);
  List<Language> getAll();
}
