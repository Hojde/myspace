package com.hojde.myspace.domain.model;

import java.util.List;

public record Tab(
  String title,
  String artist,
  TabProject project,
  List<Instrument> instruments,
  List<TabFile> files,
  List<ListeningUrl> listeningUrls
) {
}
