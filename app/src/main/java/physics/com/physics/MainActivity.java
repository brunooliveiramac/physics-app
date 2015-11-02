package physics.com.physics;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import physics.com.physics.helper.MainHelper;
import physics.com.physics.util.ConnectionDetector;


public class MainActivity extends Activity {

    private MainHelper helper = new MainHelper(MainActivity.this);
    private ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectionDetector = new ConnectionDetector(this);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.alternative_activity_main);

        helper.initializeElements();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(!connectionDetector.isConnected()) {
//            Toast.makeText(this, "Você precisa estar conectado a internet", Toast.LENGTH_LONG).show();
            connectionDetector.wifiChangeDialogBuilder();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
