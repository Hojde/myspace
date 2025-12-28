package com.hojde.myspace.adapters.api.model;


import java.util.List;

public record TabFileDTO(
  FileTypeDTO fileType,
  String fileUrl,
  List<String> instruments
) {
}
