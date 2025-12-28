package com.hojde.myspace.domain.repository;

import com.hojde.myspace.domain.model.Tab;

import java.util.List;

public interface TabRepository {
  Tab save(Tab tab);
  List<Tab> getAll();
}
