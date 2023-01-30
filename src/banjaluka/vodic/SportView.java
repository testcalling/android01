package banjaluka.vodic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import banjaluka.vodic.R;


import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class SportView extends BaseActivity{

	private String[] imageUrls;
	private String[] adventureUrls;
	 private static final String AD_UNIT_ID_GOES_HERE = "a153352ccd9130c";
	  public AdView adView;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.ac_sport);
		
		
		//String[] text = getResources().getStringArray(R.array.text);
       // System.out.println(text);
		String[] sport = getResources().getStringArray(R.array.sport);
		
		//String[] text = getResources().getStringArray(R.array.text);
       // System.out.println(text);
		imageUrls = new String[sport.length];
		List<String> urls = new ArrayList<String>();
		urls.addAll(Arrays.asList(sport));
		
		imageUrls = (String[]) urls.toArray(new String[0]);
		

		//String[] text = getResources().getStringArray(R.array.text);
       // System.out.println(text);
		String[] adventure = getResources().getStringArray(R.array.adventure);
		
		//String[] text = getResources().getStringArray(R.array.text);
       // System.out.println(text);
		adventureUrls = new String[adventure.length];
		List<String> adventureurls = new ArrayList<String>();
		adventureurls.addAll(Arrays.asList(adventure));
		
		adventureUrls = (String[]) adventureurls.toArray(new String[0]);
		
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
	public void onSport(View view) {
		Intent intent = new Intent(this,Sport.class);
		intent.putExtra(Extra.IMAGES, imageUrls);
		startActivity(intent);
	}
	public void onAdventure(View view) {
		Intent intent = new Intent(this,Adventure.class);
		intent.putExtra(Extra.IMAGES, adventureUrls);
		startActivity(intent);
	}
}
