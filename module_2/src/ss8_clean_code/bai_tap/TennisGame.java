package ss8_clean_code.bai_tap;

public class TennisGame {

    public static final int ZERO_POINT = 0;
    public static final int ONE_POINT = 1;
    public static final int TWO_POINT = 2;
    public static final int THREE_POINT = 3;
    public static String getScore( int firstPlayerScore, int secondPlayerScore) {
        StringBuilder score = new StringBuilder();
        if (firstPlayerScore == secondPlayerScore) {
            switch (firstPlayerScore) {
                case ZERO_POINT:
                    score = new StringBuilder("Love-All");
                    break;
                case ONE_POINT:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case TWO_POINT:
                    score = new StringBuilder("Thirty-All");
                    break;
                case THREE_POINT:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;
            }
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            score = new StringBuilder(getAdvantagePoint(firstPlayerScore, secondPlayerScore));
        }else {
            getBigPoint(firstPlayerScore, secondPlayerScore, score);
        }
        return score.toString();
    }

    private static void getBigPoint(int firstPlayerScore, int secondPlayerScore, StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                score.append("-");
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case ZERO_POINT:
                    score.append("Love");
                    break;
                case ONE_POINT:
                    score.append("Fifteen");
                    break;
                case TWO_POINT:
                    score.append("Thirty");
                    break;
                case THREE_POINT:
                    score.append("Forty");
                    break;
            }
        }
    }
    private static String getAdvantagePoint(int firstPlayerScore, int secondPlayerScore) {
        String score ;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}