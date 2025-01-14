package com.football;
import com.football.entites.Club;
import com.football.services.CompetitionService;
import com.opencsv.CSVReader;
import com.football.entites.Competition;
import com.football.services.ClubService;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
//    public CommandLineRunner commandLineRunner(ClubService clubService,CompetitionService competitionService) {
//        return args -> {
//            // Chemin vers le fichier CSV
//            String csvFilePath = "C:\\Users\\asus\\Downloads\\football-api\\storage\\app\\public\\archive\\clubs.csv";
//
//            // Importer les clubs à partir du fichier CSV
//            importClubsFromCsv(csvFilePath,clubService,competitionService);
//        };
//    }
//	public void importClubsFromCsv(String csvFilePath,ClubService clubService, CompetitionService competitionService) {
//		try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
//			List<String[]> records = reader.readAll();
//			for (String[] record : records) {
//				// Récupération de la compétition associée à partir de son ID
//				Competition competition = competitionService.getCompetition(record[3]);
//				// Création d'un objet Club
//				Club club = new Club(
//						Long.parseLong(record[0]),
//						record[1], // clubCode
//						record[2], // name
//						competition, // domesticCompetition
//						parseDouble(record[4]), // totalMarketValue
//						Integer.parseInt(record[5]), // squadSize
//						Double.parseDouble(record[6]), // averageAge
//						Integer.parseInt(record[7]), // foreignersNumber
//						Double.parseDouble(record[8]), // foreignersPercentage
//						Integer.parseInt(record[9]), // nationalTeamPlayers
//						record[10], // stadiumName
//						Integer.parseInt(record[11]), // stadiumSeats
//						record[12], // netTransferRecord
//						record[13], // coachName
//						Integer.parseInt(record[14]), // lastSeason
//						record[15], // filename
//						record[16] // url
//				);
//				// Sauvegarde du club dans la base de données
//				clubService.saveClub(club);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (CsvException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//	private Double parseDouble(String value) {
//		if (value == null || value.isEmpty()) {
//			return null;
//		}
//		try {
//			return Double.parseDouble(value.replaceAll("[^0-9.]", ""));
//		} catch (NumberFormatException e) {
//			return null;
//		}
//	}

}

