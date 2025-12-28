package com.hojde.myspace.adapters.mongodb.model;

import java.util.List;

public record TabFileEntity(
  String fileType,
  String fileUrl,
  List<String> instruments
) {
}
