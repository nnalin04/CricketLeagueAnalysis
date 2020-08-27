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

    public Map<String, FactSheetDAO> leagueFactLoader(CricketLeagueAnalyser.Cricketer cricketer, String[] csvFilePath) throws CricketLeagueAnalyserException {
        if(cricketer.equals(CricketLeagueAnalyser.Cricketer.BATSMEN)){
            return this.loadFactSheetData(IPLMostRunCSV.class,csvFilePath);
        }else if (cricketer.equals(CricketLeagueAnalyser.Cricketer.BOWLER)) {
            return this.loadFactSheetData(IPLMostWktsCSV.class,csvFilePath);
        }else throw new CricketLeagueAnalyserException("Incorrect Player Type",
                CricketLeagueAnalyserException.ExceptionType.INVALID_PLAYER_TYPE);
    }

    private  <E> Map<String, FactSheetDAO> loadFactSheetData(Class<E> factSheetCSVClass, String... csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, FactSheetDAO> factSheetMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, factSheetCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
            if (factSheetCSVClass.getName().equals("cricketleagueanalysis.IPLMostRunCSV")){
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLMostRunCSV.class::cast)
                        .forEach(censusCSV -> factSheetMap.put(censusCSV.playerName, new FactSheetDAO(censusCSV)));
            } else if (factSheetCSVClass.getName().equals("cricketleagueanalysis.IPLMostWktsCSV")) {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLMostWktsCSV.class::cast)
                        .forEach(censusCSV -> factSheetMap.put(censusCSV.playerName, new FactSheetDAO(censusCSV)));
            }
            if (csvFilePath.length == 1) {
                return factSheetMap;
            }
            this.loadFactSheet(factSheetMap, csvFilePath[1]);
            return factSheetMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FACT_SHEET_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }

    public Map<String, FactSheetDAO> loadFactSheet(Map<String, FactSheetDAO> factSheetMap, String csvFilePath) throws CricketLeagueAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<IPLMostWktsCSV> stateCodeCSVIterator = csvBuilder.getCSVFileIterator(reader, IPLMostWktsCSV.class);
            Iterable<IPLMostWktsCSV> csvIterable = () -> stateCodeCSVIterator;
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .filter(factSheet -> factSheetMap.get(factSheet.playerName) != null)
                    .forEach(factSheet -> factSheetMap.get(factSheet.playerName));
            return factSheetMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FACT_SHEET_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }

}
