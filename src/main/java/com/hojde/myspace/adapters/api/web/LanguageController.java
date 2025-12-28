package com.hojde.myspace.adapters.api.web;

import com.hojde.myspace.adapters.api.model.LanguageDTO;
import com.hojde.myspace.adapters.api.model.LanguageDTOMapper;
import com.hojde.myspace.domain.service.LanguageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class LanguageController {

    private static LanguageDTOMapper MAPPER = LanguageDTOMapper.INSTANCE;

    private LanguageService languageService;

    /**
     * POST /: Create a new language.
     *
     * @param language the language to create
     * @return the ResponseEntity with status 201 (Created) and the new language in the body
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/languages")
    @Operation(summary = "Create new language")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Language création is successful") })
    public ResponseEntity<LanguageDTO> newLanguage(@RequestBody LanguageDTO language) throws URISyntaxException {
        log.debug("Adding language: {}", language.name());
        return ResponseEntity.created(new URI("/api/languages/" + language.isoCode()))
                .body(MAPPER.languageToLanguageDto(
                  languageService.addLanguage(
                    MAPPER.languageDtoToLanguage(language))));
    }

    /**
     * GET  /: Get all languages.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of languages in body
     */
    @GetMapping("/languages")
    @Operation(summary = "List of languages")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Language consultation is successful") })
    public ResponseEntity<List<LanguageDTO>> getAllLanguages() {
        log.debug("Getting languages");
        List<LanguageDTO> languages = languageService.getLanguages().stream().map(MAPPER::languageToLanguageDto).toList();
        return ResponseEntity.ok().body(languages);
    }
}
