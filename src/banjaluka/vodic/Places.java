package banjaluka.vodic;


import TextViewJustify.TextViewJustify;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector.*;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import banjaluka.vodic.R;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;


public class Places extends BaseActivity {

	private String[] imageUrls;
	private String[] buildingsURL;
	private String[] cultureURL;
	private String[] chirchURL;
	private String[] natureURL;
	
	 private static final String AD_UNIT_ID_GOES_HERE = "a153352ccd9130c";
	  public AdView adView;
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.ac_places);
		
		String[] interestingplaces = getResources().getStringArray(R.array.images);
	
		imageUrls = new String[interestingplaces.length];
		List<String> urls = new ArrayList<String>();
		urls.addAll(Arrays.asList(interestingplaces));		//urls.addAll(Arrays.asList(lightImages));
		imageUrls = (String[]) urls.toArray(new String[0]);
		
		String[] buildings = getResources().getStringArray(R.array.buildings);
		
		buildingsURL = new String[buildings.length];
		List<String> buildingsurls = new ArrayList<String>();
		buildingsurls.addAll(Arrays.asList(buildings));		//urls.addAll(Arrays.asList(lightImages));
		buildingsURL = (String[]) buildingsurls.toArray(new String[0]);
	
        String[] culture = getResources().getStringArray(R.array.culture);
		
        cultureURL = new String[culture.length];
		List<String> cultureurls = new ArrayList<String>();
		cultureurls.addAll(Arrays.asList(culture));		//urls.addAll(Arrays.asList(lightImages));
		cultureURL = (String[]) cultureurls.toArray(new String[0]);
		
		String[] chirch = getResources().getStringArray(R.array.chirch);
			
	        chirchURL = new String[chirch.length];
			List<String> chirchurls = new ArrayList<String>();
			chirchurls.addAll(Arrays.asList(chirch));		//urls.addAll(Arrays.asList(lightImages));
			chirchURL = (String[]) chirchurls.toArray(new String[0]);
			
        String[] nature = getResources().getStringArray(R.array.nature);
			
           natureURL = new String[nature.length];
			List<String> natureurls = new ArrayList<String>();
			natureurls.addAll(Arrays.asList(nature));		//urls.addAll(Arrays.asList(lightImages));
			natureURL = (String[]) natureurls.toArray(new String[0]);
			
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
		Intent intent = new Intent(this, PlacesPagerActivity.class);
		intent.putExtra(Extra.IMAGES, imageUrls);
		startActivity(intent);
	}
	public void onBuildings(View view) {
		Intent intent = new Intent(this, Buildings.class);
		intent.putExtra(Extra.IMAGES, buildingsURL);
		startActivity(intent);
	}
	public void onCulture(View view) {
		Intent intent = new Intent(this, Culture.class);
		intent.putExtra(Extra.IMAGES, cultureURL);
		startActivity(intent);
	}
	public void onChirch(View view) {
		Intent intent = new Intent(this, Chirch.class);
		intent.putExtra(Extra.IMAGES, chirchURL);
		startActivity(intent);
	}
	public void onNature(View view) {
		Intent intent = new Intent(this, Nature.class);
		intent.putExtra(Extra.IMAGES, natureURL);
		startActivity(intent);
	}
    
}