package com.hojde.myspace.adapters.mongodb.model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "languages")
public record LanguageEntity(
  @Id String isoCode,
  String name,
  @CreatedBy String createdBy,
  @CreatedDate Instant createdDate,
  @LastModifiedBy String lastModifiedBy,
  @LastModifiedDate Instant lastModifiedDate
) {}
