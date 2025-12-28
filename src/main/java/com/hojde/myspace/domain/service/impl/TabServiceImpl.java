package com.hojde.myspace.domain.service.impl;

import com.hojde.myspace.domain.model.Tab;
import com.hojde.myspace.domain.repository.TabRepository;
import com.hojde.myspace.domain.service.TabService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TabServiceImpl implements TabService {

    private TabRepository tabRepository;
    @Override
    public List<Tab> getTabs() {
        return tabRepository.getAll();
    }

    @Override
    public Tab addTab(Tab tab) {
        return tabRepository.save(tab);
    }
}
