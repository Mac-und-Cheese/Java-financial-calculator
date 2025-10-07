public class LiquidityRatios{
    public static double calculateCurrentRatio(Data data) {
        return data.getCurrentAssets() / data.getCurrentLiabilities();
    }
    public static double calculateQuickRatio(Data data, double inventory) {
        return (data.getCurrentAssets() - inventory) / data.getCurrentLiabilities();
    }
    public static double calculateCashRatio(Data data, double cash) {
        return cash / data.getCurrentLiabilities();
    }
}