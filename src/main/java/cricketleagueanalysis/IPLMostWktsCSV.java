package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWktsCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double bowlingAvg;

}
