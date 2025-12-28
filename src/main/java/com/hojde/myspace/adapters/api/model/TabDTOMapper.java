package com.hojde.myspace.adapters.api.model;

import com.hojde.myspace.domain.model.Tab;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TabDTOMapper {

  TabDTOMapper INSTANCE = Mappers.getMapper(TabDTOMapper.class);

  @Mapping(source = "project.name", target = "project")
  TabDTO tabToTabDTO(Tab tab);

  @Mapping(source = "project", target = "project.name")
  Tab tabDTOToTab(TabDTO tabDTO);
}
