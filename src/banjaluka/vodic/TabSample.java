package banjaluka.vodic;

import banjaluka.vodic.R;
import android.app.TabActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.widget.TabHost;
import android.content.Intent;
public class TabSample extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost);
        TabHost tabHost = getTabHost();       
     
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Bus-departures").setContent(new Intent(this, Odlazni.class)));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Bus-arrivals").setContent(new Intent(this, Dolazni.class)));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Train-timetable").setContent(new Intent(this, Travel.class)));
        tabHost.setCurrentTab(0); 
    }
}