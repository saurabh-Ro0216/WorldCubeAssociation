package com.worldcubeassociation.pune.controller;
import com.worldcubeassociation.pune.model.Competition;
import com.worldcubeassociation.pune.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Competition endpoints
 */
@RestController
@RequestMapping("/api/competitions")
@CrossOrigin(origins = "*") // Allow CORS for frontend access
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    /**
     * GET endpoint to fetch Pune competitions only
     *
     * URL: http://localhost:8080/api/competitions/pune
     *
     * @return List of competitions in Pune
     */
    @GetMapping("/pune")
    public ResponseEntity<List<Competition>> getPuneCompetitions() {
        try {
            List<Competition> competitions = competitionService.getPuneCompetitions();

            if (competitions.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(competitions);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * GET endpoint to fetch all competitions
     *
     * URL: http://localhost:8080/api/competitions
     *
     * @return List of all competitions
     */
    @GetMapping
    public ResponseEntity<List<Competition>> getAllCompetitions() {
        try {
            List<Competition> competitions = competitionService.getAllCompetitions();
            return ResponseEntity.ok(competitions);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * GET endpoint to filter competitions by city
     *
     * URL: http://localhost:8080/api/competitions/city?name=Mumbai
     *
     * @param name City name to filter by
     * @return List of competitions in the specified city
     */
    @GetMapping("/city")
    public ResponseEntity<List<Competition>> getCompetitionsByCity(
            @RequestParam String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            List<Competition> competitions =
                    competitionService.getCompetitionsByCity(name);

            if (competitions.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(competitions);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Health check endpoint
     *
     * URL: http://localhost:8080/api/competitions/health
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Pune Competitions API is running! ✅");
    }
}
