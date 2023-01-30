package banjaluka.vodic;



import TextViewJustify.TextViewJustify;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import banjaluka.vodic.R;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class PlacesPagerActivity extends BaseActivity {

	private ViewPager pager;
    private TextView tv;
    private TextView tvDesc;
    private TextView tel;
    private TextView telValue;
    private TextView mail;
    private TextView mailValue;
    private TextView street;
    private TextView streetValue;
    private TextView page;
	private DisplayImageOptions options;
	
	String[] niz={"Krajina Square.","Gospodska Street is the most popular, busiest and certainly the oldest streets of Banja Luka. If you like shopping, coffee and ice cream, or simply want to enjoy a walk through the city then Gospodska Street should not be missed when you come to Banja Luka.","Parkic-Park","Petar Kocic City Park is the perfect place to relax after a stroll through the downtown and shopping. Nature, fountains and modern music pavilion will provide an ideal place to relax.","Ban Milosavljevic Square. Svetislav Tisa Milosavljevic, the man responsible for building the historical and cultural center of Banja Luka, was the first governor of principality of Vrbas. He arrived to Banja Luka in 1929. and immediately started with the development of the entire principality. For a short period of time he did a lot of work to develop the principality and the most recognised building from that period are Banski Dvor, the Municipality building, the Theater and Museum.","City bridge. During the event 'Summer on the Vrbas river' here is a traditional jumps from city bridge.","The Kastel is the oldest historical complex in Banja Luka and it represents the historical core of the city which dates back all the way to the 3rd century. The fortress is located in the centre of the city on the bank of the mighy wild river Vrbas. The Kastel was built by the Roman Empire and during the Ottoman Empire it was expanded even more. Because of its location and the location of the city, the Kastel was an important military strategic location and served as a military fortification to protect merchant routes and river traffic. With the territory of 48 000 square metters and amphitheatar, parks and restaurant the Kastel is the place where many concerts, festivals, and other cultural entertainment and sport manifestations take place. So if you want the experience the history, enjoy fantastic cuisine or simply relax on the bank of the river, the Kastel is the place to visit.",
			"The largest and most famous picnic resort in Banja Luka is located on the south side of town. From the top of Banj Brdo, where there is the monument to fallen soldiers in World War II, you can enjoy a unique view of the whole of Banja Luka.There are a large number of hiking and biking trails, drinking water sources and landscaped picnic sites. "};
	String[] streets={"Veselina Maslese,Kralja Petra I Karadjordjevica.","Veselina Maslese","Bana Milosavljavica,Kralja Petra I Karadjordjevica.","Kralja Petra I Karadjordjevica.","Bana Dr. T, Lazarevica.","Patre,Cara Lazara.","Teodora Kolokotronisa.","Put banjaluckog odreda."};
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.ac_image_pager);
		
		
		Bundle bundle = getIntent().getExtras();
		String[] imageUrls = bundle.getStringArray(Extra.IMAGES);
		int pagerPosition = bundle.getInt(Extra.IMAGE_POSITION, 0);
		
		
		options = new DisplayImageOptions.Builder()
			.showImageForEmptyUri(R.drawable.image_for_empty_url)
			.cacheOnDisc()
			.imageScaleType(ImageScaleType.EXACT)
			.build();

		pager = (ViewPager) findViewById(R.id.pager);
		
		
		pager.setAdapter(new ImagePagerAdapter(imageUrls));

		pager.setCurrentItem(pagerPosition);

	
	}
   
	@Override
	protected void onStop() {
		
		imageLoader.stop();
		super.onStop();
	}
	
	

	private class ImagePagerAdapter extends PagerAdapter {

		private String[] images;
		int i=0;
		int currentItem;
		private LayoutInflater inflater;
		
		
		ImagePagerAdapter(String[] images) {
			this.images = images;
		 
			inflater = getLayoutInflater();
			  
		}
		public void load()
		{
			street = (TextView) findViewById(R.id.street);
			streetValue = (TextView) findViewById(R.id.streetvalue);
			tvDesc = ((TextView) findViewById(R.id.tvDesc));
			tv = ((TextView) findViewById(R.id.tv));
			
			page = (TextView) findViewById(R.id.page);
			
		}
		
		@Override
		public void destroyItem(View container, int position, Object object) {
		
			((ViewPager) container).removeView((View) object);
		}

		@Override
		public void finishUpdate(View container) {
		   
		}

		@Override
		public int getCount() {
			return images.length;
		}
		
		@Override
		public Object instantiateItem(View view, final int position) {
		
			
			final View imageLayout = inflater.inflate(R.layout.item_pager_places, null);
			
			final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
			final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);
			final String[] interestingplaces = getResources().getStringArray(R.array.images);
			
	    	
		   
			
			
			imageLoader.displayImage(images[position], imageView, options, new ImageLoadingListener() {
				
				
				public void set()
				{
				
				    tv.setText(niz[pager.getCurrentItem()]);
				    streetValue.setText(streets[pager.getCurrentItem()]);
				    SpannableString content = new SpannableString(streets[pager.getCurrentItem()]);
					content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
					streetValue.setText(content);
			    	
				    streetValue.setOnClickListener(new OnClickListener() {
				   
				    	
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(PlacesPagerActivity.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 String [] url = {"http://www.openstreetmap.org/?mlat=44.769968&mlon=17.18936&zoom=18&layers=M","http://www.openstreetmap.org/?mlat=44.77089&mlon=17.190661&zoom=18&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.77366&mlon=17.19316&zoom=16&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.77033&mlon=17.18856&zoom=16&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.77187&mlon=17.19264&zoom=16&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.76514&mlon=17.18855&zoom=16&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.76692&mlon=17.19006&zoom=16&layers=M",
								         "http://www.openstreetmap.org/?mlat=44.75246&mlon=17.1849&zoom=16&layers=M",
								         };
								 final Intent ii = new Intent(Intent.ACTION_VIEW);
							    	Uri u = null;
							    	if(pager.getCurrentItem()==0)
							    	{
							    	 u = Uri.parse(url[0]);
							    	}
							    	if(pager.getCurrentItem()==1)
							    	{
							    	 u = Uri.parse(url[1]);
							    	}
							    	if(pager.getCurrentItem()==2)
							    	{
							    	 u = Uri.parse(url[2]);
							    	}
							    	if(pager.getCurrentItem()==3)
							    	{
							    	 u = Uri.parse(url[3]);
							    	}
							    	if(pager.getCurrentItem()==4)
							    	{
							    	 u = Uri.parse(url[4]);
							    	}
							    	if(pager.getCurrentItem()==5)
							    	{
							    	 u = Uri.parse(url[5]);
							    	}
							    	if(pager.getCurrentItem()==6)
							    	{
							    	 u = Uri.parse(url[6]);
							    	}
							    	if(pager.getCurrentItem()==7)
							    	{
							    	 u = Uri.parse(url[7]);
							    	}
							    	ii.setData(u);
								   //Linkify.addLinks(streetValue, Linkify.ALL);
								 startActivity(ii);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
				    page.setText("Page: "+(pager.getCurrentItem()+1)+"/"+(interestingplaces.length-1));
		  			TextViewJustify.justifyText(((TextView)findViewById(R.id.tv)), 305f); 
		  			
				}
				public void onLoadingStarted() {
					
				   spinner.setVisibility(View.VISIBLE);
				   load();
				}
				

				public void onLoadingFailed(FailReason failReason) {
					String message = null;
					switch (failReason) {
						case IO_ERROR:
							message = "Input/Output error";
							break;
						case OUT_OF_MEMORY:
							message = "Out Of Memory error";
							break;
						case UNKNOWN:
							message = "Unknown error";
							break;
					}
					Toast.makeText(PlacesPagerActivity.this, message, Toast.LENGTH_SHORT).show();
		
					spinner.setVisibility(View.GONE);
				
					imageView.setImageResource(R.drawable.error);
					
					
				}

				public void onLoadingComplete(Bitmap loadedImage) {
				   
				    set();
					
				    load();
					
					spinner.setVisibility(View.GONE);
					
					Animation anim = AnimationUtils.loadAnimation(PlacesPagerActivity.this, R.anim.fade_in);
					imageView.setAnimation(anim);

					anim.start();
				
				}
          
				public void onLoadingCancelled() {
				
				}
			});
	
			if(currentItem < pager.getCurrentItem()){
              i++;
          
  			
			}
			
			else if(currentItem > pager.getCurrentItem())
			{
			  i--;
			 
			}
	
			((ViewPager) view).addView(imageLayout, 0);

			return imageLayout;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
		
			return view.equals(object);
		}

		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
		
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View container) {
		
		
		}
	}

	

	

	

	

	

	

	

	
	

	
}