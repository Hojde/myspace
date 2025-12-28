package com.hojde.myspace.adapters.api.model;

import java.util.List;

public record TabDTO(
  String id,
  String title,
  String artist,
  String project,
  List<InstrumentDTO> instruments,
  List<TabFileDTO> files,
  List<ListeningUrlDTO> listeningUrls
) {
}
