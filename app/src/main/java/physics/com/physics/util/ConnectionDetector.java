package physics.com.physics.util;

import android.content.Context;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by bruno on 02/11/15.
 */
public class ConnectionDetector {
    private Context mContext;
    private WifiManager manager;

    public ConnectionDetector(Context context) {
        this.mContext = context;
        manager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
    }

    public boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    public void wifiChangeDialogBuilder() {
        if(!manager.isWifiEnabled()) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("Não há conexão com a internet :(");
            alertDialog.setMessage("Gostaria de ligar o WiFi?");

            alertDialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    manager.setWifiEnabled(true);
                }
            });
            alertDialog.show();
        } else {
            Toast.makeText(mContext, "Verifique sua conexão com a internet", Toast.LENGTH_SHORT).show();
        }
    }
}
