package com.hojde.myspace.domain.model;

public record ListeningUrl(
  ListeningPlatform listeningPlatform,
  String url
) {
}
