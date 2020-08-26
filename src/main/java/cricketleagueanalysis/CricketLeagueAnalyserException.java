package cricketleagueanalysis;

public class CricketLeagueAnalyserException extends Exception {

    public enum ExceptionType {
        FACT_SHEET_FILE_PROBLEM, INVALID_PLAYER_TYPE;
    }

    public ExceptionType type;

    public CricketLeagueAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketLeagueAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CricketLeagueAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
