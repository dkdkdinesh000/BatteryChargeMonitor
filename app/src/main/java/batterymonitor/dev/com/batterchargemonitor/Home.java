package batterymonitor.dev.com.batterchargemonitor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import batterymonitor.dev.com.batterchargemonitor.databinding.ActivityHomeBinding;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class Home extends AppCompatActivity {
    public ActivityHomeBinding mainBinding;
    public ChargeStatus chargeStatus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainBinding = DataBindingUtil.setContentView((Activity) this, R.layout.activity_home);
        this.chargeStatus = new ChargeStatus();
        this.UpdateChargeStatus();

        mainBinding.setChargeObj(chargeStatus);
        mainBinding.executePendingBindings();
        PowerConnectionReceiver.listener = new View.OnClickListener() {
            public void onClick(View v) {
                UpdateChargeStatus();
                if (mainBinding != null) {
                    mainBinding.invalidateAll();
                }
            }
        };
    }

    private void UpdateChargeStatus() {
        String chargeInStr = SharedPrefsUtils.getStringPreference(this.getApplicationContext(), "charge_in");
        String chargeOutStr = SharedPrefsUtils.getStringPreference(this.getApplicationContext(), "charge_out");

        if (null == chargeInStr || chargeInStr.isEmpty() || null == chargeOutStr || chargeOutStr.isEmpty())
            return;

        this.chargeStatus.setChargeIn(chargeInStr);
        this.chargeStatus.setChargeOut(chargeOutStr);

        Date chargeInTime = DateHelper.getDateWithServerTimeStamp(this.chargeStatus.getChargeIn());
        Date chargeOutTime = DateHelper.getDateWithServerTimeStamp(this.chargeStatus.getChargeOut());

        if (chargeOutTime.getTime() > chargeInTime.getTime()) {
            Long timeDiff = (chargeOutTime.getTime() - chargeInTime.getTime());
            Long timeSec = TimeUnit.MILLISECONDS.toSeconds(timeDiff);
            this.chargeStatus.setTotalTime("" + timeSec.toString() + " Sec");
        }

    }

}
