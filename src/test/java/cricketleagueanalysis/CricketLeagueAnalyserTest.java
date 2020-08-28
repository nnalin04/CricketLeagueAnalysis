package cricketleagueanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

    private static final String MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted(EnumCollection.battingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted(EnumCollection.strikeRateComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4s_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted(EnumCollection.fourAndSixComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4sWithStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.fourAndSixComparator, EnumCollection.strikeRateComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverageWithBestStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.strikeRateComparator, EnumCollection.battingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsWithBattingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.battingAvgComparator, EnumCollection.runComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted(EnumCollection.bowlingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlerStrikeRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.bowlerStrikeRateComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestEconomyRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.ecoRateComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ben Cutting", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestStrikeRateWith4wAnd5w_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.w4AndW5Comparator, EnumCollection.bowlerStrikeRateComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Lasith Malinga", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverageWithStrikeRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.bowlerStrikeRateComparator, EnumCollection.bowlingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverageWithMaxWicket_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.wicketComparator, EnumCollection.bowlingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Imran Tahir", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAndBowlingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN,
                MOST_RUN_CSV_FILE_PATH, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.battingAvgComparator, EnumCollection.bowlingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsAndWickets_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN,
                MOST_RUN_CSV_FILE_PATH, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.wicketComparator, EnumCollection.runComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAverageWithMax100_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.hundredComparator, EnumCollection.battingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAverageWithMin100sAnd50_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(EnumCollection.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSingleFactSorted
                (EnumCollection.hundredAnd50sComparator, EnumCollection.battingAvgComparator);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Marcus Stoinis", iplMostRunCSV[0].playerName);
    }
}
