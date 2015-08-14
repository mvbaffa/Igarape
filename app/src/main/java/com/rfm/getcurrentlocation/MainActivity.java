package com.rfm.getcurrentlocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements LocationListener {

    protected static LocationManager mLocationManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        TextView txtLat = (TextView) findViewById(R.id.latitudeTextView);
        txtLat.setText(location.getLatitude()+"");
        TextView txtLong = (TextView) findViewById(R.id.longitudeTextView);
        txtLong.setText(location.getLongitude()+"");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        TextView txtLat = (TextView) findViewById(R.id.latitudeTextView);
        TextView txtLong = (TextView) findViewById(R.id.longitudeTextView);
        txtLat.setText("Enabled");
        txtLong.setText("Enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        TextView txtLat = (TextView) findViewById(R.id.latitudeTextView);
        TextView txtLong = (TextView) findViewById(R.id.longitudeTextView);
        txtLat.setText("Disabled");
        txtLong.setText("Disabled");
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
