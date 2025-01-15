package com.football;

import com.football.entites.Club;
import com.football.entites.Game;
import com.football.services.CompetitionService;
import com.football.services.GameService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.football.entites.Competition;
import com.football.services.ClubService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.opencsv.CSVReaderBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.ParseException;

@SpringBootApplication
public class FootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApplication.class, args);
    }

    //	@Bean
//	CommandLineRunner commandLineRunner(CompetitionService competitionService) {
//		return args -> {
//			try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\competitions.csv"), StandardCharsets.ISO_8859_1)) {
//				CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//				CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//				String[] columns;
//				int i = 0;
//				while ((columns = csvReader.readNext()) != null) {
//					// Vérifiez que la ligne contient le nombre de colonnes attendu (11 dans ce cas)
//					if (columns.length == 11) {
//						try {
//							Competition competition = new Competition(
//									columns[0],
//									columns[1],
//									columns[2],
//									columns[3],
//									columns[4],
//									columns[5],
//									columns[6],
//									columns[7],
//									columns[8],
//									columns[9],
//									Boolean.parseBoolean(columns[10])
//							);
//							competitionService.saveCompetition(competition);
//							i++;
//							System.out.println("i : " + i);
//							System.out.println("Saved Competition: " + columns[0]);
//						} catch (NumberFormatException e) {
//							System.out.println("Erreur lors de la conversion d'un nombre : " + Arrays.toString(columns));
//							e.printStackTrace();
//						} catch (Exception e) {
//							System.out.println("Erreur inattendue lors de la sauvegarde : " + Arrays.toString(columns));
//							e.printStackTrace();
//						}
//					} else {
//						System.out.println("Ligne invalide avec un nombre de colonnes incorrect : " + Arrays.toString(columns));
//					}
//				}
//				System.out.println("Fin");
//			} catch (IOException e) {
//				System.out.println("Erreur lors de la lecture du fichier CSV");
//				e.printStackTrace();
//			}
//		};
//	}
//    @Bean
//    CommandLineRunner commandLineRunner(ClubService clubService, CompetitionService competitionService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\clubs.csv"), StandardCharsets.ISO_8859_1)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                int i = 0;
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 17) {
//                        try {
//                            Competition competition = competitionService.getCompetition(columns[3]);
//                            if (competition != null) {
//
//                                try {
//                                    Long id = columns[0] != null && !columns[0].isEmpty() ? Long.parseLong(columns[0]) : null;
//                                    String clubCode = columns[1] != null && !columns[1].isEmpty() ? columns[1] : null;
//                                    String name = columns[2] != null && !columns[2].isEmpty() ? columns[2] : null;
//                                    Double totalMarketValue = columns[4] != null && !columns[4].isEmpty() ? parseDouble(columns[4]) : null;
//                                    Integer squadSize = columns[5] != null && !columns[5].isEmpty() ? Integer.parseInt(columns[5]) : null;
//                                    Double averageAge = columns[6] != null && !columns[6].isEmpty() ? Double.parseDouble(columns[6]) : null;
//                                    Integer foreignersNumber = columns[7] != null && !columns[7].isEmpty() ? Integer.parseInt(columns[7]) : null;
//                                    Double foreignersPercentage = columns[8] != null && !columns[8].isEmpty() ? Double.parseDouble(columns[8]) : null;
//                                    Integer nationalTeamPlayers = columns[9] != null && !columns[9].isEmpty() ? Integer.parseInt(columns[9]) : null;
//                                    String stadiumName = columns[10] != null && !columns[10].isEmpty() ? columns[10] : null;
//                                    Integer stadiumSeats = columns[11] != null && !columns[11].isEmpty() ? Integer.parseInt(columns[11]) : null;
//                                    String netTransferRecord = columns[12] != null && !columns[12].isEmpty() ? columns[12] : null;
//                                    String coachName = columns[13] != null && !columns[13].isEmpty() ? columns[13] : null;
//                                    Integer lastSeason = columns[14] != null && !columns[14].isEmpty() ? Integer.parseInt(columns[14]) : null;
//                                    String filename = columns[15] != null && !columns[15].isEmpty() ? columns[15] : null;
//                                    String url = columns[16] != null && !columns[16].isEmpty() ? columns[16] : null;
//
//                                    if (competition != null) {
//                                        Club club = Club.builder()
//                                                .clubId(id)
//                                                .clubCode(clubCode)
//                                                .name(name)
//                                                .domesticCompetition(competition)
//                                                .totalMarketValue(totalMarketValue)
//                                                .squadSize(squadSize)
//                                                .averageAge(averageAge)
//                                                .foreignersNumber(foreignersNumber)
//                                                .foreignersPercentage(foreignersPercentage)
//                                                .nationalTeamPlayers(nationalTeamPlayers)
//                                                .stadiumName(stadiumName)
//                                                .stadiumSeats(stadiumSeats)
//                                                .netTransferRecord(netTransferRecord)
//                                                .coachName(coachName)
//                                                .lastSeason(lastSeason)
//                                                .filename(filename)
//                                                .url(url)
//                                                .build();
//                                        System.out.println("=> id : " + club.getClubId() + " ,code " + club.getClubCode() + " , name " + club.getName());
//                                        Club clubS = clubService.saveClub(club);
//
//                                        i++;
//                                        System.out.println("i: " + i);
//                                        System.out.println("Saved Club: " + columns[0]);
//                                    } else {
//                                        System.out.println("Competition is missing for club creation");
//                                    }
//
//                                } catch (NumberFormatException e) {
//                                    System.out.println("Number conversion error: " + Arrays.toString(columns));
//                                    e.printStackTrace();
//                                }
//                            } else {
//                                System.out.println("Competition does not exist");
//                            }
//
//                        } catch (NumberFormatException e) {
//                            System.out.println("Number conversion error: " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        } catch (Exception e) {
//                            System.out.println("Unexpected error during save: " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                System.out.println("End");
//            } catch (IOException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }
//
//    private Double parseDouble(String value) {
//        if (value == null || value.isEmpty()) {
//            return null;
//        }
//        try {
//            return Double.parseDouble(value.replaceAll("[^0-9.]", ""));
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(ClubService clubService,CompetitionService competitionService, PlayerService playerService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\players.csv"), StandardCharsets.ISO_8859_1)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                int i = 0;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 23) {
//                        try {
//                            // Parse the columns into appropriate types
//                            Long playerId = !columns[0].isEmpty() ? Long.parseLong(columns[0]) : null;
//                            String firstName = columns[1];
//                            String lastName = columns[2];
//                            String name = columns[3];
//                            int lastSeason = !columns[4].isEmpty() ? Integer.parseInt(columns[4]) : 0;
//                            Long currentClubId = !columns[5].isEmpty() ? Long.parseLong(columns[5]) : null;
//                            String playerCode = columns[6];
//                            String countryOfBirth = columns[7];
//                            String cityOfBirth = columns[8];
//                            String countryOfCitizenship = columns[9];
//                            Date dateOfBirth = !columns[10].isEmpty() ? dateFormat.parse(columns[10]) : null;
//                            String subPosition = columns[11];
//                            String position = columns[12];
//                            String foot = columns[13];
//                            Double heightInCm = !columns[14].isEmpty() ? Double.parseDouble(columns[14]) : null;
//                            Date contractExpirationDate = !columns[15].isEmpty() ? dateFormat.parse(columns[15]) : null;
//                            String agentName = columns[16];
//                            String imageUrl = columns[17];
//                            String url = columns[18];
//                            String currentClubDomesticCompetitionId = !columns[19].isEmpty() ? columns[19] : null;
//                            String currentClubName = columns[20];
//                            Double marketValueInEur = !columns[21].isEmpty() ? Double.parseDouble(columns[21]) : null;
//                            Double highestMarketValueInEur = !columns[22].isEmpty() ? Double.parseDouble(columns[22]) : null;
//
//                            Club club = clubService.getClub(currentClubId);
//                            Competition competition = competitionService.getCompetition(String.valueOf(currentClubDomesticCompetitionId));
//
//                            // Build the Player object
//                            if(competition!=null && club!=null)
//                            {
//                                Player player = Player.builder()
//                                        .playerId(playerId)
//                                        .firstName(firstName)
//                                        .lastName(lastName)
//                                        .name(name)
//                                        .currentClub(club)
//                                        .competition(competition)
//                                        .lastSeason(lastSeason)
//                                        .playerCode(playerCode)
//                                        .countryOfBirth(countryOfBirth)
//                                        .cityOfBirth(cityOfBirth)
//                                        .countryOfCitizenship(countryOfCitizenship)
//                                        .dateOfBirth(dateOfBirth)
//                                        .subPosition(subPosition)
//                                        .position(position)
//                                        .foot(foot)
//                                        .heightInCm(heightInCm)
//                                        .contractExpirationDate(contractExpirationDate)
//                                        .agentName(agentName)
//                                        .imageUrl(imageUrl)
//                                        .url(url)
//                                        .currentClubName(currentClubName)
//                                        .marketValueInEur(marketValueInEur)
//                                        .highestMarketValueInEur(highestMarketValueInEur)
//                                        .build();
//
//                                // Save the player to the database
//                                playerService.savePlayer(player);
//
//                                i++;
//                                System.out.println("i : " + i);
//                                System.out.println("Saved Player: " + player);
//
//                            }else {
//                                System.out.println("club or competition not exist ");
//                            }
//
//                        } catch (NumberFormatException | ParseException e) {
//                            System.out.println("Erreur lors de la conversion d'un nombre ou d'une date : " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        } catch (Exception e) {
//                            System.out.println("Erreur inattendue lors de la sauvegarde : " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("Ligne invalide avec un nombre de colonnes incorrect : " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Fin");
//            } catch (IOException e) {
//                System.out.println("Erreur lors de la lecture du fichier CSV");
//                e.printStackTrace();
//            }
//        };
//    }


//    @Bean
//    CommandLineRunner loadGameData(GameService gameService, ClubService clubService, CompetitionService competitionService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\games.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 23) {
//                        try {
//                            Long gameId = Long.parseLong(columns[0]);
//                            String competitionId = columns[1];
//                            int season = Integer.parseInt(columns[2]);
//                            String round = columns[3];
//                            Date date = dateFormat.parse(columns[4]);
//                            Long homeClubId = Long.parseLong(columns[5]);
//                            Long awayClubId = Long.parseLong(columns[6]);
//                            int homeClubGoals = Integer.parseInt(columns[7]);
//                            int awayClubGoals = Integer.parseInt(columns[8]);
//                            Double homeClubPosition = !columns[9].isEmpty() ? Double.parseDouble(columns[9]) : null;
//                            Double awayClubPosition = !columns[10].isEmpty() ? Double.parseDouble(columns[10]) : null;
//                            String homeClubManagerName = columns[11];
//                            String awayClubManagerName = columns[12];
//                            String stadium = columns[13];
//                            Double attendance = !columns[14].isEmpty() ? Double.parseDouble(columns[14]) : null;
//                            String referee = columns[15];
//                            String url = columns[16];
//                            String homeClubFormation = columns[17];
//                            String awayClubFormation = columns[18];
//                            String homeClubName = columns[19];
//                            String awayClubName = columns[20];
//                            String aggregate = columns[21];
//                            String competitionType = columns[22];
//                            Competition competition=null;
//                            Club awayClub=null;
//                            Club homeClub=null;
//
//                            if(competitionId!=null && homeClubId!=null && awayClubId!=null)
//                            {
//                                competition = competitionService.getCompetition(competitionId);
//                                homeClub = clubService.getClub(homeClubId);
//                                awayClub = clubService.getClub(awayClubId);
//                            }
//                            if (competition != null && homeClub != null && awayClub != null) {
//                                Game game = Game.builder()
//                                        .gameId(gameId)
//                                        .competition(competition)
//                                        .season(season)
//                                        .round(round)
//                                        .date(date)
//                                        .homeClub(homeClub)
//                                        .awayClub(awayClub)
//                                        .homeClubGoals(homeClubGoals)
//                                        .awayClubGoals(awayClubGoals)
//                                        .homeClubPosition(homeClubPosition)
//                                        .awayClubPosition(awayClubPosition)
//                                        .homeClubManagerName(homeClubManagerName)
//                                        .awayClubManagerName(awayClubManagerName)
//                                        .stadium(stadium)
//                                        .attendance(attendance)
//                                        .referee(referee)
//                                        .url(url)
//                                        .homeClubFormation(homeClubFormation)
//                                        .awayClubFormation(awayClubFormation)
//                                        .homeClubName(homeClubName)
//                                        .awayClubName(awayClubName)
//                                        .aggregate(aggregate)
//                                        .competitionType(competitionType)
//                                        .build();
//                                gameService.saveGame(game);
//
//                                System.out.println("Saved Game: " + game);
//                            } else {
//                                System.out.println("Club or competition not found for game ID: " + gameId);
//                            }
//
//                        } catch (NumberFormatException | ParseException e) {
//                            System.out.println("Error parsing number or date: " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        } catch (Exception e) {
//                            System.out.println("Unexpected error: " + Arrays.toString(columns));
//                            e.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Game data load complete.");
//            } catch (IOException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }



}

