package cricketleagueanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

    private static final String MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    CricketLeagueAnalyser cricketLeagueAnalyser = null;

    @Before
    public void setUp() {
        cricketLeagueAnalyser = new CricketLeagueAnalyser();
    }


    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum.Compare.BATTING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_STRIKE_RATE);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4s_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .FOUR_SIX);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnMaximum6sAnd4sWithStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .FOUR_SIX, IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_STRIKE_RATE);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverageWithBestStrikingRates_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_STRIKE_RATE, IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsWithBattingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_AVG, IPLComparatorAndEnum
                                    .Compare.RUN);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlerStrikeRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_STRIKE_RATE);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestEconomyRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .ECONOMY);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Ben Cutting", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestStrikeRateWith4wAnd5w_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare.W4ANDW5, IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_STRIKE_RATE);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Lasith Malinga", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverageWithStrikeRate_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_STRIKE_RATE, IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBowlingAverageWithMaxWicket_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BOWLER, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare
                                    .WICKET, IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Imran Tahir", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAndBowlingAverage_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN,
                MOST_RUN_CSV_FILE_PATH, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare.BATTING_AVG, IPLComparatorAndEnum
                                    .Compare
                                    .BOWLING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestRunsAndWickets_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN,
                MOST_RUN_CSV_FILE_PATH, MOST_WKTS_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare.WICKET, IPLComparatorAndEnum
                                    .Compare
                                    .RUN);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAverageWithMax100_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare.HUNDREDS, IPLComparatorAndEnum
                                    .Compare
                                    .BATTING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("David Warner", iplMostRunCSV[0].playerName);
    }

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBestBattingAverageWithMin100sAnd50_ShouldReturnSortedResult()
            throws CricketLeagueAnalyserException {
        cricketLeagueAnalyser.loadLeagueFactSheet(IPLComparatorAndEnum.Cricketer.BATSMEN, MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getSortedFacts(IPLComparatorAndEnum
                                    .Compare.HUNDRED_FIFTY, IPLComparatorAndEnum
                                    .Compare.BATTING_AVG);
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("Marcus Stoinis", iplMostRunCSV[0].playerName);
    }
}
