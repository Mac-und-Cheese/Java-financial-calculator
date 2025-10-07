public class SolvencyRatios {
    public static double calculateDebtToEquity(Data data) {
        return data.getTotalLiabilities() / data.getEquity();
    }

    public static double calculateDebtRatio(Data data) {
        return data.getTotalLiabilities() / data.getTotalAssets();
    }

    public static double calculateInterestCoverage(double ebit, double interestExpense) {
        return ebit / interestExpense;
    }
}