package com.hojde.myspace.adapters.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instruments")
public record InstrumentEntity(
  String name
) {}
