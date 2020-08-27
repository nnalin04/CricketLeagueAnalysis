package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double avgRun;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "100", required = true)
    public int hundreds;
}
