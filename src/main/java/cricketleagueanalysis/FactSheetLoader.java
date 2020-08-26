package cricketleagueanalysis;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class FactSheetLoader {

    public Map<String, FactSheetDAO> leagueFactLoader(CricketLeagueAnalyser.PlayerType playerType, String csvFilePath) throws CricketLeagueAnalyserException {
        if(playerType.equals(CricketLeagueAnalyser.PlayerType.BATSMEN)){
            return this.loadFactSheetData(IPLMostRunCSV.class,csvFilePath);
        }else if (playerType.equals(CricketLeagueAnalyser.PlayerType.BOWLER)) {
            return this.loadFactSheetData(IPLMostWktsCSV.class,csvFilePath);
        }else throw new CricketLeagueAnalyserException("Incorrect Player Type",
                CricketLeagueAnalyserException.ExceptionType.INVALID_PLAYER_TYPE);
    }

    private  <E> Map<String, FactSheetDAO> loadFactSheetData(Class<E> factSheetCSVClass, String csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, FactSheetDAO> censusStateMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, factSheetCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (factSheetCSVClass.getName().equals("cricketleagueanalysis.IPLMostRunCSV")){
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLMostRunCSV.class::cast)
                        .forEach(censusCSV -> censusStateMap.put(censusCSV.playerName, new FactSheetDAO(censusCSV)));
            } else if (factSheetCSVClass.getName().equals("cricketleagueanalysis.IPLMostWktsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLMostWktsCSV.class::cast)
                        .forEach(censusCSV -> censusStateMap.put(censusCSV.playerName, new FactSheetDAO(censusCSV)));
            }
            return censusStateMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FACT_SHEET_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }

}
