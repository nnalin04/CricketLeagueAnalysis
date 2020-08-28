package cricketleagueanalysis;

public class FactSheetDAO {

    public int fifty;
    public int hundreds;
    public int wicket;
    public int fiveWicket;
    public int fourWicket;
    public double ecoRate;
    public double bowlingAvg;
    public int runs;
    public int fours;
    public int sixes;
    public double strikeRate;
    public String playerName;
    public double battingAvg;

    public FactSheetDAO(IPLMostRunCSV iplMostRunCSV) {
        playerName = iplMostRunCSV.playerName;
        battingAvg = iplMostRunCSV.avgRun;
        strikeRate = iplMostRunCSV.strikeRate;
        fours = iplMostRunCSV.fours;
        sixes = iplMostRunCSV.sixes;
        runs = iplMostRunCSV.runs;
        hundreds = iplMostRunCSV.hundreds;
        fifty = iplMostRunCSV.fifty;
    }

    public FactSheetDAO(IPLMostWktsCSV iplMostWktsCSV){
        playerName = iplMostWktsCSV.playerName;
        bowlingAvg = iplMostWktsCSV.bowlingAvg;
        strikeRate = iplMostWktsCSV.strikeRate;
        ecoRate = iplMostWktsCSV.ecoRate;
        fourWicket = iplMostWktsCSV.fourWicket;
        fiveWicket = iplMostWktsCSV.fiveWicket;
        wicket = iplMostWktsCSV.wicket;
    }

    @Override
    public String toString() {
        return "FactSheetDAO{" +
                "fifty=" + fifty +
                ", hundreds=" + hundreds +
                ", wicket=" + wicket +
                ", fiveWicket=" + fiveWicket +
                ", fourWicket=" + fourWicket +
                ", ecoRate=" + ecoRate +
                ", bowlingAvg=" + bowlingAvg +
                ", runs=" + runs +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", strikeRate=" + strikeRate +
                ", playerName='" + playerName + '\'' +
                ", battingAvg=" + battingAvg +
                '}';
    }
}
