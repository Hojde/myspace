package com.hojde.myspace.domain.service;

import com.hojde.myspace.domain.model.Tab;

import java.util.List;

public interface TabService {
  List<Tab> getTabs();
  Tab addTab(Tab tab);
}
