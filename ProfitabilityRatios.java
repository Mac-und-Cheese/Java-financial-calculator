public class ProfitabilityRatios {
    public static double calculateReturnOnAssets(Data data) {
        return data.getNetIncome() / data.getTotalAssets();
    }

    public static double calculateReturnOnEquity(Data data) {
        return data.getNetIncome() / data.getEquity();
    }

    public static double calculateProfitMargin(Data data) {
        return data.getNetIncome() / data.getRevenue();
    }

    public static double calculateGrossMargin(Data data, double costOfGoodsSold) {
        return (data.getRevenue() - costOfGoodsSold) / data.getRevenue();
    }
}