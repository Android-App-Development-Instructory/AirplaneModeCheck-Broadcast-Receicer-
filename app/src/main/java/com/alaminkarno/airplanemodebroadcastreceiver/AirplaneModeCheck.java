package com.alaminkarno.airplanemodebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeCheck extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){

            boolean isActive = isActive(context);

            if(isActive){
                Toast.makeText(context, "Airplane Mode is ON", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(context, "Airplane Mode is OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isActive(Context context) {
        return Settings.System.getInt(context.getContentResolver(),Settings.System.AIRPLANE_MODE_ON,-1) != 0;
    }
}
