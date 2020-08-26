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
    public <E> Map<String, FactSheetDAO> loadFactSheetData(Class<E> factSheetCSVClass, String csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, FactSheetDAO> censusStateMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, factSheetCSVClass);
            Iterable<E> csvIterable = () -> csvFileIterator;
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(IPLMostRunCSV.class::cast)
                        .forEach(censusCSV -> censusStateMap.put(censusCSV.playerName, new FactSheetDAO(censusCSV)));
            return censusStateMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.FACT_SHEET_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }
}
