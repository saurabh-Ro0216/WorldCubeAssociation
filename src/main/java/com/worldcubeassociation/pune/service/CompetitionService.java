package com.worldcubeassociation.pune.service;

import com.worldcubeassociation.pune.model.Competition;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class to fetch and filter competitions from WCA API
 */
@Service
public class CompetitionService {

    private static final String WCA_API_URL =
            "https://www.worldcubeassociation.org/api/v0/competitions?country_iso2=IN";

    private final RestTemplate restTemplate;

    public CompetitionService() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Fetch all competitions from WCA API and filter by Pune city
     * Checks if city contains "Pune" (case-insensitive)
     *
     * @return List of competitions in Pune
     */
    public List<Competition> getPuneCompetitions() {
        try {
            System.out.println("Fetching competitions from WCA API...");

            // Call external API
            Competition[] allCompetitions =
                    restTemplate.getForObject(WCA_API_URL, Competition[].class);

            if (allCompetitions != null) {
                System.out.println("Total competitions fetched: " + allCompetitions.length);

                // Filter competitions where city contains "Pune" (case-insensitive)
                List<Competition> puneCompetitions = Arrays.stream(allCompetitions)
                        .filter(comp -> comp.getCity() != null &&
                                comp.getCity().toLowerCase().contains("pune"))
                        .collect(Collectors.toList());

                System.out.println("Pune competitions found: " + puneCompetitions.size());
                return puneCompetitions;
            }

            System.out.println("No competitions found in API response");
            return List.of();

        } catch (Exception e) {
            System.err.println("Error fetching competitions: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch competitions from WCA API", e);
        }
    }

    /**
     * Fetch all competitions without filtering
     *
     * @return List of all competitions
     */
    public List<Competition> getAllCompetitions() {
        try {
            Competition[] allCompetitions =
                    restTemplate.getForObject(WCA_API_URL, Competition[].class);

            if (allCompetitions != null) {
                return Arrays.asList(allCompetitions);
            }
            return List.of();

        } catch (Exception e) {
            System.err.println("Error fetching competitions: " + e.getMessage());
            throw new RuntimeException("Failed to fetch competitions from WCA API", e);
        }
    }

    /**
     * Filter competitions by any city name
     *
     * @param city City name to filter by
     * @return List of competitions in the specified city
     */
    public List<Competition> getCompetitionsByCity(String city) {
        try {
            Competition[] allCompetitions =
                    restTemplate.getForObject(WCA_API_URL, Competition[].class);

            if (allCompetitions != null && city != null && !city.isEmpty()) {
                return Arrays.stream(allCompetitions)
                        .filter(comp -> comp.getCity() != null &&
                                comp.getCity().toLowerCase()
                                        .contains(city.toLowerCase()))
                        .collect(Collectors.toList());
            }

            return List.of();

        } catch (Exception e) {
            System.err.println("Error fetching competitions: " + e.getMessage());
            throw new RuntimeException("Failed to fetch competitions from WCA API", e);
        }
    }
}
