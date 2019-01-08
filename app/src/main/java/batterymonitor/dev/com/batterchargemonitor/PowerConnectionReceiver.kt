package batterymonitor.dev.com.batterchargemonitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_POWER_CONNECTED
import android.content.Intent.ACTION_POWER_DISCONNECTED
import android.os.BatteryManager
import android.util.Log
import android.view.View
import java.util.*

class PowerConnectionReceiver : BroadcastReceiver() {

    companion object {
        var listener: View.OnClickListener? = null
    }

    override fun onReceive(context: Context, intent: Intent) {


        var currentDate = DateHelper.getDateStr(Date())
        if (intent.action.equals(ACTION_POWER_CONNECTED)) {
            SharedPrefsUtils.setStringPreference(context.applicationContext, "charge_in", currentDate!!);
            Log.d("test", "Power Connected")
        } else if (intent.action.equals(ACTION_POWER_DISCONNECTED)) {
            Log.d("test", "Power Disconnected")
            SharedPrefsUtils.setStringPreference(context.applicationContext, "charge_out", currentDate!!);
        }
        listener?.onClick(null)
    }
}
