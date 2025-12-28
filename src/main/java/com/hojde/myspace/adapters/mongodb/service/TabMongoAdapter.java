package com.hojde.myspace.adapters.mongodb.service;

import com.hojde.myspace.adapters.mongodb.model.TabEntityMapper;
import com.hojde.myspace.adapters.mongodb.repository.TabMongoRepository;
import com.hojde.myspace.domain.model.Tab;
import com.hojde.myspace.domain.repository.TabRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TabMongoAdapter implements TabRepository {

  private static final TabEntityMapper MAPPER = TabEntityMapper.INSTANCE;

  private TabMongoRepository tabMongoRepository;

  @Override
  public Tab save(Tab tab) {
    return MAPPER.tabEntityToTab(tabMongoRepository.save(MAPPER.tabToTabEntity(tab)));
  }

  @Override
  public List<Tab> getAll() {
    return tabMongoRepository.findAll().stream().map(MAPPER::tabEntityToTab).toList();
  }
}
