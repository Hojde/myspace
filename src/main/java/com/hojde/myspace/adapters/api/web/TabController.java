package com.hojde.myspace.adapters.api.web;

import com.hojde.myspace.adapters.api.model.TabDTO;
import com.hojde.myspace.adapters.api.model.TabDTOMapper;
import com.hojde.myspace.domain.model.FileType;
import com.hojde.myspace.domain.service.TabService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tabs")
@AllArgsConstructor
@Slf4j
public class TabController {

    private static final TabDTOMapper MAPPER = TabDTOMapper.INSTANCE;

    private TabService tabService;

    /**
     * POST /tabs: Create a new tab.
     *
     * @param tab the tab to create
     * @return the ResponseEntity with status 201 (Created) and the new tab in the body
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("")
    @Operation(summary = "Create new tab")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Tab création is successful") })
    public ResponseEntity<TabDTO> newTab(@RequestBody TabDTO tab) throws URISyntaxException {
        log.debug("Adding tab: {}", tab.title());
        return ResponseEntity.created(new URI("/api/tabs/" + tab.id()))
                .body(MAPPER.tabToTabDTO(
                  tabService.addTab(
                    MAPPER.tabDTOToTab(tab))));
    }

    /**
     * GET  /tabs: Get all tabs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tabs in body
     */
    @GetMapping("")
    @Operation(summary = "List of tabs")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tab consultation is successful") })
    public ResponseEntity<List<TabDTO>> getAllTabs() {
        log.debug("Getting tabs");
        List<TabDTO> tabs = tabService.getTabs().stream().map(MAPPER::tabToTabDTO).toList();
        return ResponseEntity.ok().body(tabs);
    }

    /**
     * GET  /tabs/file-types: Get all tabs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tab file types in body
     */
    @GetMapping("/file-types")
    @Operation(summary = "List of tab file types")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tab file types consultation is successful") })
    public ResponseEntity<List<FileType>> getAllTabFileTypes() {
        log.debug("Getting tab file types");
        return ResponseEntity.ok().body(Arrays.stream(FileType.values()).toList());
    }
}
