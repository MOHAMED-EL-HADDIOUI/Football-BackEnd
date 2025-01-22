package com.football;

import com.football.entites.*;
import com.football.services.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;

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

//    	@Bean
//	CommandLineRunner commandLineRunner(CompetitionService competitionService) {
//		return args -> {
//			try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\competitions.csv"), StandardCharsets.ISO_8859_1)) {
//				CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//				CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//				String[] columns;
//				int i = 0;
//				while ((columns = csvReader.readNext()) != null) {
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
//                                        System.out.println("competition de club : "+club.getDomesticCompetition().getCompetitionId());
//                                        Club clubS = clubService.saveClub(club);
//
//                                        i++;
//                                        System.out.println("i: " + i);
//                                        System.out.println("Saved Club: " + clubS.getClubId());
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





//    @Bean
//    CommandLineRunner loadGameData(GameService gameService, ClubService clubService, CompetitionService competitionService, PlayerService playerService , AppearanceService appearanceService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\appearances_1.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                columns = csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 13) {
//                        // Mapping CSV data to Appearance object fields
//                        System.out.println("gameId : "+columns[1]);
//                        String appearanceId = columns[0];
//                        Long gameId = Long.valueOf(columns[1]);
//                        Long playerId = Long.valueOf(columns[2]);
//                        Long playerClubId = Long.valueOf(columns[3]);
//                        Long playerCurrentClubId = Long.valueOf(columns[4]);
//                        Date date = dateFormat.parse(columns[5]);
//                        String playerName = columns[6];
//                        String competitionId = columns[7];
//
//                        int yellowCards = Integer.parseInt(columns[8]);
//                        int redCards = Integer.parseInt(columns[9]);
//                        int goals = Integer.parseInt(columns[10]);
//                        int assists = Integer.parseInt(columns[11]);
//                        int minutesPlayed = Integer.parseInt(columns[12]);
//                        Player player = null;
//                        Club club = null;
//                        Club currentClub = null;
//                        Game game = null;
//                        Competition competition = null;
//                        if(gameId!=null && playerId!=null && playerCurrentClubId!=null && playerClubId!=null && competitionId!=null)
//                        {
//                            player = playerService.getPlayer(playerId);
//                            club = clubService.getClub(playerClubId);
//                            currentClub = clubService.getClub(playerCurrentClubId);
//                            game = gameService.getGame(gameId);
//                            competition = competitionService.getCompetition(competitionId);
//                            if(game!=null && currentClub!=null && competition!=null && player!=null && club!=null)
//                            {
//                                // Creating and saving the Appearance object
//                                Appearance appearance = Appearance.builder()
//                                        .appearanceId(appearanceId)
//                                        .player(player)
//                                        .club(club)
//                                        .currentclub(currentClub)
//                                        .date(date)
//                                        .playerName(playerName)
//                                        .yellowCards(yellowCards)
//                                        .redCards(redCards)
//                                        .goals(goals)
//                                        .assists(assists)
//                                        .minutesPlayed(minutesPlayed)
//                                        .game(game)
//                                        .competition(competition)
//                                        .build();
//
//                                // Save the Appearance object to the database
//                                appearanceService.saveAppearance(appearance);  // Assuming you have a repository to save the Appearance
//                                System.out.println("save"+appearanceId);
//
//                            }
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Game data load complete.");
//            } catch (IOException | ParseException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }



//    @Bean
//    CommandLineRunner loadGameData(GameService gameService, ClubService clubService, ClubGameService clubGameService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\club_games.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                // Skip the header
//                csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 11) {
//                        Long gameId = Long.parseLong(columns[0]);
//                        Long clubId = Long.parseLong(columns[1]);
//                        int ownGoals = Integer.parseInt(columns[2]);
//                        Double ownPosition = columns[3].isEmpty() ? null : Double.parseDouble(columns[3]);
//                        String ownManagerName = columns[4];
//                        Long opponentId = Long.parseLong(columns[5]);
//                        int opponentGoals = Integer.parseInt(columns[6]);
//                        Double opponentPosition = columns[7].isEmpty() ? null : Double.parseDouble(columns[7]);
//                        String opponentManagerName = columns[8];
//                        String hosting = columns[9];
//                        int isWin = Integer.parseInt(columns[10]);
//
//                        // Fetch related entities
//                        Game game = gameService.getGame(gameId);
//                        Club club = clubService.getClub(clubId);
//                        Club opponentClub = clubService.getClub(opponentId);
//
//                        if (game != null && club != null && opponentClub != null) {
//                            ClubGame clubGame = ClubGame.builder()
//                                    .game(game)
//                                    .club(club)
//                                    .ownGoals(ownGoals)
//                                    .ownPosition(ownPosition)
//                                    .ownManagerName(ownManagerName)
//                                    .opponentclub(opponentClub)
//                                    .opponentGoals(opponentGoals)
//                                    .opponentPosition(opponentPosition)
//                                    .opponentManagerName(opponentManagerName)
//                                    .hosting(hosting)
//                                    .isWin(isWin)
//                                    .build();
//
//                            // Save to the database
//                            ClubGame clubGame1 = clubGameService.saveClubGame(clubGame);
//                            System.out.println("save ClubGame : "+clubGame1.getClubGameId());
//                        } else {
//                            System.out.println("Error fetching related entities for row: " + Arrays.toString(columns));
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



//    @Bean
//    CommandLineRunner loadGameEventsData(GameService gameService, ClubService clubService, PlayerService playerService, GameEventService gameEventService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\game_events_1.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                // Skip the header
//                csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 10) {
//                        String gameEventId = columns[0];
//                        Date date = dateFormat.parse(columns[1]);
//                        Long gameId = Long.parseLong(columns[2]);
//                        int minute = Integer.parseInt(columns[3]);
//                        String type = columns[4];
//                        Long clubId = Long.parseLong(columns[5]);
//                        Long playerId = Long.parseLong(columns[6]);
//                        String description = columns[7];
//                        String playerInId = columns[8];
//                        String playerAssistId = columns[9];
//
//                        // Fetch related entities
//                        Game game = gameService.getGame(gameId);
//                        Club club = clubService.getClub(clubId);
//                        Player player = playerService.getPlayer(playerId);
//                        Player playerIn = playerInId.isEmpty() ? null : playerService.getPlayer(Long.parseLong(playerInId));
//                        Player playerAssist = playerAssistId.isEmpty() ? null : playerService.getPlayer(Long.parseLong(playerAssistId));
//
//                        if (game != null && club != null && player != null) {
//                            GameEvent gameEvent = GameEvent.builder()
//                                    .gameEventId(gameEventId)
//                                    .date(date)
//                                    .minute(minute)
//                                    .type(type)
//                                    .game(game)
//                                    .club(club)
//                                    .player(player)
//                                    .description(description)
//                                    .playerIn(playerIn)
//                                    .playerAssist(playerAssist)
//                                    .build();
//                            // Save to the database
//                            gameEventService.saveGameEvent(gameEvent);
//                            System.out.println("save gameEvent "+gameEvent.getGameEventId());
//                        } else {
//                            System.out.println("Error fetching related entities for row: " + Arrays.toString(columns));
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Game events data load complete.");
//            } catch (IOException | ParseException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }

//    @Bean
//    CommandLineRunner loadGameLineupsData(GameService gameService, ClubService clubService, PlayerService playerService, GameLineupService gameLineupService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\game_lineups.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                // Skip the header
//                csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 10) {
//                        String gameLineupsId = columns[0];
//                        Date date = dateFormat.parse(columns[1]);
//                        Long gameId = Long.parseLong(columns[2]);
//                        Long playerId = Long.parseLong(columns[3]);
//                        Long clubId = Long.parseLong(columns[4]);
//                        String playerName = columns[5];
//                        String type = columns[6];
//                        String position = columns[7];
//                        String number = columns[8];
//                        int teamCaptain = Integer.parseInt(columns[9]);
//
//                        // Fetch related entities
//                        Game game = gameService.getGame(gameId);
//                        Club club = clubService.getClub(clubId);
//                        Player player = playerService.getPlayer(playerId);
//
//                        if (game != null && club != null && player != null) {
//                            GameLineup gameLineup = GameLineup.builder()
//                                    .gameLineupsId(gameLineupsId)
//                                    .date(date)
//                                    .game(game)
//                                    .club(club)
//                                    .player(player)
//                                    .playerName(playerName)
//                                    .type(type)
//                                    .position(position)
//                                    .number(number)
//                                    .teamCaptain(teamCaptain)
//                                    .build();
//
//                            // Save to the database
//                            gameLineupService.saveGameLineup(gameLineup);
//                            System.out.println("saveTransfer "+gameLineup.getGameLineupsId());
//
//                        } else {
//                            System.out.println("Error fetching related entities for row: " + Arrays.toString(columns));
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Game lineups data load complete.");
//            } catch (IOException | ParseException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }
//
//    @Bean
//    CommandLineRunner loadPlayerValuationsData(PlayerService playerService, ClubService clubService, CompetitionService competitionService, PlayerValuationService playerValuationService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\player_valuations.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                // Skip the header
//                csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 5) {
//                        Long playerId = Long.parseLong(columns[0]);
//                        Date date = dateFormat.parse(columns[1]);
//                        Double marketValueInEur = Double.parseDouble(columns[2]);
//                        Long currentClubId = Long.parseLong(columns[3]);
//                        String competitionId = columns[4];
//
//                        // Fetch related entities
//                        Player player = playerService.getPlayer(playerId);
//                        Club currentClub = clubService.getClub(currentClubId);
//                        Competition competition = competitionService.getCompetition(competitionId);
//
//                        if (player != null && currentClub != null && competition != null) {
//                            PlayerValuation playerValuation = PlayerValuation.builder()
//                                    .player(player)
//                                    .date(date)
//                                    .marketValueInEur(marketValueInEur)
//                                    .currentClub(currentClub)
//                                    .competition(competition)
//                                    .build();
//
//                            // Save to the database
//                            PlayerValuation p = playerValuationService.savePlayerValuation(playerValuation);
//                            System.out.println("saveTransfer "+p.getValuationId());
//
//                        } else {
//                            System.out.println("Error fetching related entities for row: " + Arrays.toString(columns));
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Player valuations data load complete.");
//            } catch (IOException | ParseException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }
//    @Bean
//    CommandLineRunner loadTransferData(ClubService clubService, PlayerService playerService, TransferService transferService) {
//        return args -> {
//            try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\transfers.csv"), StandardCharsets.UTF_8)) {
//                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
//                CSVReader csvReader = new CSVReaderBuilder(br).withCSVParser(parser).build();
//                String[] columns;
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                // Skip the header
//                csvReader.readNext();
//
//                while ((columns = csvReader.readNext()) != null) {
//                    if (columns.length == 10) {
//                        Long playerId = Long.parseLong(columns[0]);
//                        Date transferDate = dateFormat.parse(columns[1]);
//                        String transferSeason = columns[2];
//                        Long fromClubId = columns[3].isEmpty() ? null : Long.parseLong(columns[3]);
//                        Long toClubId = columns[4].isEmpty() ? null : Long.parseLong(columns[4]);
//                        String fromClubName = columns[5];
//                        String toClubName = columns[6];
//                        double transferFee = columns[7].isEmpty() ? 0 : Double.parseDouble(columns[7]);
//                        double marketValueInEur = columns[8].isEmpty() ? 0 : Double.parseDouble(columns[8]);
//                        String playerName = columns[9];
//
//                        // Fetch related entities
//                        Player player = playerService.getPlayer(playerId);
//                        Club fromClub = fromClubId != null ? clubService.getClub(fromClubId) : null;
//                        Club toClub = toClubId != null ? clubService.getClub(toClubId) : null;
//
//                        if (player != null && fromClub!=null && toClub!=null) {
//                            Transfer transfer = Transfer.builder()
//                                    .player(player)
//                                    .transferDate(transferDate)
//                                    .transferSeason(transferSeason)
//                                    .fromClub(fromClub)
//                                    .toClub(toClub)
//                                    .fromClubName(fromClubName)
//                                    .toClubName(toClubName)
//                                    .transferFee(transferFee)
//                                    .marketValueInEur(marketValueInEur)
//                                    .playerName(playerName)
//                                    .build();
//
//                            // Save to the database
//                            Transfer t = transferService.saveTransfer(transfer);
//                            System.out.println("save Transfer "+t.getTransferId());
//                        } else {
//                            System.out.println("Error fetching player for row: " + Arrays.toString(columns));
//                        }
//                    } else {
//                        System.out.println("Invalid row with incorrect number of columns: " + Arrays.toString(columns));
//                    }
//                }
//                System.out.println("Transfer data load complete.");
//            } catch (IOException | ParseException e) {
//                System.out.println("Error reading CSV file");
//                e.printStackTrace();
//            }
//        };
//    }
}

