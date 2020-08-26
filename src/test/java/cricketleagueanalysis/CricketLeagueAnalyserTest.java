package cricketleagueanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

    private static final String MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAverageSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getStrikingRatesSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4s_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4sWithStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getMax4sAnd6sWithStrikeRatesSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverageWithBestStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAverageWithStrikeRatesSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsWithBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithBattingAverageSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].playerName);
    }
}
