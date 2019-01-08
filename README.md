# BatteryChargeMonitor
 This application used to monitor charge in and charge out plug 
 
# PowerConnectionReceiver
 Please add following snipt into your manifest file.
 
 ```xml
  <receiver android:name=".PowerConnectionReceiver">
            <intent-filter>
                <action android:name="android.intent.action.ACTION_POWER_CONNECTED"/>
                <action android:name="android.intent.action.ACTION_POWER_DISCONNECTED"/>
            </intent-filter>
  </receiver>
 ```

and add broadcast receiver into your project

```kotlin
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
```
This onReceive method will trigger whenever charge in and charge out plug 
