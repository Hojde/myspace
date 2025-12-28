package com.hojde.myspace.domain.service.impl;

import com.hojde.myspace.domain.model.Language;
import com.hojde.myspace.domain.repository.LanguageRepository;
import com.hojde.myspace.domain.service.LanguageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;
    @Override
    public List<Language> getLanguages() {
        return languageRepository.getAll();
    }

    @Override
    public Language addLanguage(Language language) {
        return languageRepository.save(language);
    }
}
