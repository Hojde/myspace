package com.hojde.myspace.adapters.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tabs")
public record TabEntity(
  @Id
  String id,
  String title,
  String artist,
  String project,
  List<InstrumentEntity> instruments,
  List<TabFileEntity> files,
  List<ListeningUrlEntity> listeningUrls
) {
}
