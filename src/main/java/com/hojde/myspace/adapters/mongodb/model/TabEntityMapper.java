package com.hojde.myspace.adapters.mongodb.model;

import com.hojde.myspace.domain.model.Tab;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TabEntityMapper {

  TabEntityMapper INSTANCE = Mappers.getMapper(TabEntityMapper.class);

  @Mapping(source = "project.name", target = "project")
  TabEntity tabToTabEntity(Tab tab);

  @Mapping(source = "project", target = "project.name")
  Tab tabEntityToTab(TabEntity tabEntity);
}
