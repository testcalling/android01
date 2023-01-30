package banjaluka.vodic;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;




import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import banjaluka.vodic.R;







import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;





@SuppressLint("SetJavaScriptEnabled")
public class Travel extends BaseActivity {

	private String[] imageUrls;
	static final  String PREFS_Zoom = "PREFS_Zoom";

	 private String zoomlevel;
	 private int Default_zoomlevel=50;
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_travel);

	
		WebView wv = (WebView)findViewById(R.id.my_webview4);
		wv.getSettings().setJavaScriptEnabled(true);
		GetZoom();
	    wv.setInitialScale(Default_zoomlevel);
	  
	   
	    
	    
		WebSettings settings = wv.getSettings();
		settings.setDomStorageEnabled(true);
		
		wv.setWebChromeClient(new WebChromeClient());
	
		wv.getSettings().setSupportZoom(true); 
		wv.getSettings().setBuiltInZoomControls(true);
	
		Toast toast = Toast.makeText(Travel.this, "Loading...", Toast.LENGTH_LONG);
		 toast.show();
		
		
		wv.loadUrl("http://studioprogression.orgfree.com/redvoznje.php");	 
     
         //wv.getSettings().setPluginsEnabled(true);
        
		settings.setPluginState(PluginState.ON);  
		wv.getSettings().setAllowFileAccess(true);
	    wv.getSettings().setLoadWithOverviewMode(true);
	    
	    
		
	
		
	  }
	private void GetZoom(){
	      try{
	       SharedPreferences settings = getSharedPreferences(PREFS_Zoom,0);
	          zoomlevel = settings.getString("zoom_level","");     
	       if (zoomlevel.length() >0)   
	        Default_zoomlevel = Integer.parseInt(zoomlevel);               
	       else
	       Default_zoomlevel =50;
	      }catch(Exception ex){
	       Log.e("******ZOOM ! ", "Exception GetZoom()  ::"+ex.getMessage());          
	      }
	     }
	
	
	 
	}
