package com.hojde.myspace.adapters.api.model;

import com.hojde.myspace.domain.model.Instrument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstrumentDTOMapper {

  InstrumentDTOMapper INSTANCE = Mappers.getMapper(InstrumentDTOMapper.class);

  InstrumentDTO instrumentToInstrumentDTO(Instrument instrument);
  Instrument instrumentDTOToInstrument(InstrumentDTO instrumentDTO);
}
