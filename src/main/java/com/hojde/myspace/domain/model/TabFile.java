package com.hojde.myspace.domain.model;

import java.util.List;

public record TabFile(
  FileType fileType,
  String fileUrl,
  List<String> instruments
) {
}
