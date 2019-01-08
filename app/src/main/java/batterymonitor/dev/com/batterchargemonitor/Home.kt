package batterymonitor.dev.com.batterchargemonitor

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import batterymonitor.dev.com.batterchargemonitor.databinding.ActivityHomeBinding
import java.util.concurrent.TimeUnit


class Home : AppCompatActivity() {
    lateinit var mainBinding: ActivityHomeBinding
    lateinit var chargeStatus: ChargeStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        chargeStatus = ChargeStatus()
        UpdateChargeStatus()
        mainBinding.chargeObj = chargeStatus
        mainBinding.executePendingBindings()

        PowerConnectionReceiver.listener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                UpdateChargeStatus()
                mainBinding?.invalidateAll()
            }

        }
    }

    private fun UpdateChargeStatus() {
        chargeStatus.ChargeIn = SharedPrefsUtils.getStringPreference(applicationContext, "charge_in")
        chargeStatus.ChargeOut = SharedPrefsUtils.getStringPreference(applicationContext, "charge_out")

        var chargeInTime = DateHelper.getDateWithServerTimeStamp(chargeStatus.ChargeIn!!)
        var chargeOutTime = DateHelper.getDateWithServerTimeStamp(chargeStatus.ChargeOut!!)
        if (chargeOutTime?.time!! > chargeInTime?.time!!)
            chargeStatus.TotalTime = TimeUnit.MILLISECONDS.toSeconds(chargeOutTime?.time!! - chargeInTime?.time!!).toString() + " Sec "
    }
}
