package batterymonitor.dev.com.batterchargemonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public final class PowerConnectionReceiver extends BroadcastReceiver {
    public static View.OnClickListener listener;

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        String currentDate = DateHelper.getDateStr(new Date());
        Context appCntxt = context.getApplicationContext();
        if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
            SharedPrefsUtils.setStringPreference(appCntxt, "charge_in", currentDate);
            Log.d("test", "Power Connected");
        } else if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            Log.d("test", "Power Disconnected");

            SharedPrefsUtils.setStringPreference(appCntxt, "charge_out", currentDate);
        }
        if (listener != null) {
            listener.onClick(null);
        }
    }
}
