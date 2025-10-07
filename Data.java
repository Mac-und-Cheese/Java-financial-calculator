public class Data {
    private double currentAssets;
    private double currentLiabilities;
    private double totalAssets;
    private double totalLiabilities;
    private double netIncome;
    private double revenue;
    private double equity;
    private double costOfGoodsSold;
    private double inventory;
    private double cash;
    private double ebit;
    
    private Data() {}
    
    public double getCurrentAssets() { return currentAssets; }
    public double getCurrentLiabilities() { return currentLiabilities; }
    public double getTotalAssets() { return totalAssets; }
    public double getTotalLiabilities() { return totalLiabilities; }
    public double getNetIncome() { return netIncome; }
    public double getRevenue() { return revenue; }
    public double getEquity() { return equity; }
    public double getCostOfGoodsSold() { return costOfGoodsSold; }
    public double getInventory() { return inventory; }
    public double getCash() { return cash; }
    public double getEbit() { return ebit; }
    
    public static class Builder {
        private Data data;
        
        public Builder() {
            this.data = new Data();
        }
        
        public Builder setCurrentAssets(double currentAssets) {
            data.currentAssets = currentAssets;
            return this;
        }
        
        public Builder setCurrentLiabilities(double currentLiabilities) {
            data.currentLiabilities = currentLiabilities;
            return this;
        }
        
        public Builder setTotalAssets(double totalAssets) {
            data.totalAssets = totalAssets;
            return this;
        }
        
        public Builder setTotalLiabilities(double totalLiabilities) {
            data.totalLiabilities = totalLiabilities;
            return this;
        }
        
        public Builder setNetIncome(double netIncome) {
            data.netIncome = netIncome;
            return this;
        }
        
        public Builder setRevenue(double revenue) {
            data.revenue = revenue;
            return this;
        }
        
        public Builder setEquity(double equity) {
            data.equity = equity;
            return this;
        }
        
        public Builder setCostOfGoodsSold(double costOfGoodsSold) {
            data.costOfGoodsSold = costOfGoodsSold;
            return this;
        }
        
        public Builder setInventory(double inventory) {
            data.inventory = inventory;
            return this;
        }
        
        public Builder setCash(double cash) {
            data.cash = cash;
            return this;
        }
        public Builder setEbit(double ebit) {
            data.ebit = ebit;
            return this;
        }
        
        public Data build() {
            return data;
        }
    }
}