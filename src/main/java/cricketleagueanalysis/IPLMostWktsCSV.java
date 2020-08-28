package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostWktsCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double bowlingAvg;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "Econ", required = true)
    public double ecoRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicket;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWicket;

    @CsvBindByName(column = "Wkts", required = true)
    public int wicket;

    @Override
    public String toString() {
        return "IPLMostWktsCSV{" +
                "playerName='" + playerName + '\'' +
                ", bowlingAvg=" + bowlingAvg +
                ", strikeRate=" + strikeRate +
                ", ecoRate=" + ecoRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                ", wicket=" + wicket +
                '}';
    }
}
