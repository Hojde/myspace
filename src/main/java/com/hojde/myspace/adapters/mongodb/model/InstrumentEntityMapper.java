package com.hojde.myspace.adapters.mongodb.model;


import com.hojde.myspace.domain.model.Instrument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstrumentEntityMapper {

  InstrumentEntityMapper INSTANCE = Mappers.getMapper(InstrumentEntityMapper.class);

  InstrumentEntity instrumentToInstrumentEntity(Instrument instrument);
  Instrument instrumentEntityToInstrument(InstrumentEntity instrumentEntity);
}
