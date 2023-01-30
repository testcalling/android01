package banjaluka.vodic;

import java.util.ArrayList;




import java.util.Arrays;
import java.util.List;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import banjaluka.vodic.R;







import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class HomeActivity extends BaseActivity {

	private String[] imageUrls;
	  private static final String AD_UNIT_ID_GOES_HERE = "a153352ccd9130c";
	  public AdView adView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
	 
		setContentView(R.layout.ac_home);
		
		
		ImageButton sharingButton =(ImageButton) findViewById(R.id.share);
		
		sharingButton.setImageResource(R.drawable.facebookbutton);
		
		sharingButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent(Intent.ACTION_SEND);
				  // intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=Orion.Soft \n\n"));
				  // startActivity(intent);
				onShare(v);
				
			
			}
			 
		});
		
		adView = new AdView(this, AdSize.BANNER, AD_UNIT_ID_GOES_HERE);

		LinearLayout layout = (LinearLayout) findViewById(R.id.lineara);
	    layout.addView(adView);

	    AdRequest adRequest = new AdRequest();

	    boolean inEmulator = "generic".equals(Build.BRAND.toLowerCase());
	    if (inEmulator) 
	    {
	        adRequest.addTestDevice(AdRequest.TEST_EMULATOR);
	    } 
	    else 
	    {
	        adRequest.addTestDevice("11111111101111111110111111111011");
	    }

		   adView.loadAd(adRequest);

		
	}

	
	public void onPlaces(View view) {
		
		Intent intent = new Intent(this, Places.class);
	//	intent.putExtra(Extra.IMAGES, imageUrls);
		startActivity(intent);
	}
	public void onTravel(View view) {
		Intent intent = new Intent(this, TabSample.class);
	//	intent.putExtra(Extra.IMAGES, imageUrls);
		startActivity(intent);
	}
	public void onMaps(View view) {
		Intent intent = new Intent(this, Maps.class);

		startActivity(intent);
		
	}
	public void onTemp(View view) {
		Intent intent = new Intent(this,ActivityWeatherSettings.class);
	
		startActivity(intent);
	}
	public void onSport(View view) {
		Intent intent = new Intent(this,SportView.class);
	
		startActivity(intent);
	}
	public void onPhones(View view) {
		Intent intent = new Intent(this,ImportantPhones.class);
	
		startActivity(intent);
	}
	public void onAbout(View view) {
		Intent intent = new Intent(this,About.class);
	
		startActivity(intent);
	}
	public void onNight(View view) {
		Intent intent = new Intent(this,Rest.class);
	
		startActivity(intent);
	}
	public void onRest(View view) {
		Intent intent = new Intent(this,Night.class);
	
		startActivity(intent);
	}
	public void onHotel(View view) {
		Intent intent = new Intent(this,Hotel.class);
	
		startActivity(intent);
	}
	public void onShop(View view) {
		Intent intent = new Intent(this,Shopping.class);
	
		startActivity(intent);
	}
	public void onSMS(View view) {
		Intent intent = new Intent(this,AndroidSMS.class);
	
		startActivity(intent);
	}
	public void onShare(View view) {
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,  "https://play.google.com/store/apps/details?id=banjaluka.vodic");
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Banja Luka Guide");
		startActivity(Intent.createChooser(sharingIntent, "Share using"));
	
	}
}