package batterymonitor.dev.com.batterchargemonitor;


public final class ChargeStatus {
    private String ChargeIn;
    private String ChargeOut;
    private String TotalTime;

    public final String getChargeIn() {
        return this.ChargeIn;
    }

    public final void setChargeIn(String var1) {
        this.ChargeIn = var1;
    }

    public final String getChargeOut() {
        return this.ChargeOut;
    }

    public final void setChargeOut(String var1) {
        this.ChargeOut = var1;
    }

    public final String getTotalTime() {
        return this.TotalTime;
    }

    public final void setTotalTime(String var1) {
        this.TotalTime = var1;
    }
}
