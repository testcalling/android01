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
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import banjaluka.vodic.R;

import java.awt.*;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;


public class Chirch extends BaseActivity{

	private ViewPager pager;
    private TextView tv;
    private TextView tvDesc;
    private TextView tel;
    private TextView telValue;
    private TextView mail;
    private TextView mailValue;
    private TextView street;
    private TextView streetValue;
    private TextView site;
    private TextView siteValue;
    private TextView page;
	private DisplayImageOptions options;
	
	String[] niz={"The Temple of Christ the Savior. At the site where today stands the Temple of Christ the Savior was the Church of the Holy Trinity which was built between the First and the Second World War. The temple is located in the downtown Banja Luka between Municipality building and Banski dvor. The temple has suffered extensive damage in April 1941. and one month later it was completely destroyed. Finally in 1993 the Church has received a permission and began restoration of the temple that now bears the name of Christ the Savior.","Church of the Holy Trinity was originally located in the downtown Banja Luka between Municipality building and Banski dvor. The church was completely demolished in May 1941. Believing that they will never be able to renew the Church, the Orthodox Serbs have built a new church in a new location under the name Church of the Holy Trinity. The church was built in 1963. until 1969. year.","At the 25th kilometer road, from Banja Luka to Mrkonjic city, is located, Krupa on the Vrbas river  and monastery dedicated to St. Elias. The monastery is very old, it is assumed that the 13th century, a folk tradition says was founded by Stefan Nemanja. And this monastery was destroy several times and finally neglected in the first half of the 16th Ages. ","The Banja Luka Cathedral of St. Bonaventura - God's Tent. This wonderful building has been projected in 1960s by Miroslav Matasovic, Croatian architect.","The monastery belongs to the Trappist order in Bosnia and Herzegovina and it is located a few kilometers from the center of Banja Luka. After several unsuccessful attempts to establish a monastery in Croatia, Franz Pfanner founded a monastery in Banja Luka in 1869 while Bosnia was still under Turkish rule. Until the First World War, Trappist community in Banja Luka actively involved in all spheres of cultural life. They held vocational schools, made the first privately owned hydro power plant and still produce the famous cheese 'Trappist'. At that time the monastery was the largest monastery of trappist order in the world. Unfortunately World War II has done great damage from which the monastery to this day has not recovered.Today the monastery is open to visitors and here you can buy the unique cheese 'Trappist'."};
	String[] telS={"051233370","/","051417091","051305984","051300951"};
	String[] streetS={"Trg srpskih vladara 3","Aleja Svetog Save 3","Krupa na Vrbasu","Kralja Petra I Karadjordjevica 80","Slatinska 1"};
	String[] mailS={"/","/","/","/","zupnik@trapisti-banjaluka.org"};
	String[] siteS={"hhsbl.org","/","/","www.biskupija-banjaluka.org","www.trapisti-banjaluka.org/"};
	
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
		int i;
		int currentItem = 0;
		private LayoutInflater inflater;

		ImagePagerAdapter(String[] images) {
			this.images = images;
		    i=0;
			inflater = getLayoutInflater();
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
		public Object instantiateItem(View view, int position) {
		
			
			final View imageLayout = inflater.inflate(R.layout.item_chirch, null);
			
			final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
			final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);

			imageLoader.displayImage(images[position], imageView, options, new ImageLoadingListener() {
				public void onLoadingStarted() {
					spinner.setVisibility(View.VISIBLE);
					
					street = (TextView) findViewById(R.id.street);
					streetValue = (TextView) findViewById(R.id.streetvalue);
					tvDesc = ((TextView) findViewById(R.id.tvDesc));
					tv = ((TextView) findViewById(R.id.tv));
					tel = (TextView) findViewById(R.id.tel);
					telValue = (TextView) findViewById(R.id.telvalue);
					mail = (TextView) findViewById(R.id.mail);
					mailValue = (TextView) findViewById(R.id.mailvalue);
					site = (TextView) findViewById(R.id.site);
					siteValue = (TextView) findViewById(R.id.sitevalue);
					page = (TextView) findViewById(R.id.page);
					
					
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
					Toast.makeText(Chirch.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();
				
					
					Animation anim = AnimationUtils.loadAnimation(Chirch.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
			
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Chirch.this, "Calling a Phone Number", Toast.LENGTH_LONG);
								   toast.show();
								
								   Intent callIntent = new Intent(Intent.ACTION_CALL);
				                    callIntent.setData(Uri.parse("tel:"+ telValue.getText().toString()));
				                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					
					
					mailValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Chirch.this, "Write e-mail", Toast.LENGTH_LONG);
								 toast.show();
								
								 Intent intent = new Intent(Intent.ACTION_SEND);
								 intent.setType("text/plain");
								 intent.putExtra(Intent.EXTRA_EMAIL  ,new String[]{mailValue.getText().toString()});
								
								 startActivity(Intent.createChooser(intent, "Send mail..."));

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Mailing", "Mail failed", activityException);
				                }

							
						}
						
					});
					tv.setText(niz[pager.getCurrentItem()]);TextViewJustify.justifyText(((TextView)findViewById(R.id.tv)), 305f); 
					streetValue.setText(streetS[pager.getCurrentItem()]);
					
					SpannableString content1 = new SpannableString(streetS[pager.getCurrentItem()]);
					content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
					streetValue.setText(content1);
			    	
				    streetValue.setOnClickListener(new OnClickListener() {
				   
				    	
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Chirch.this, "Visit this location", Toast.LENGTH_LONG);
								 toast.show();
								 String [] url = {"http://www.openstreetmap.org/?mlat=44.77228&mlon=17.19199&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77441&mlon=17.19641&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.61439&mlon=17.13635&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.775084&mlon=17.195053&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.80461&mlon=17.22511&zoom=16&layers=M"
								          
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
		
		ii.setData(u);
								   //Linkify.addLinks(streetValue, Linkify.ALL);
								 startActivity(ii);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					
					telValue.setText(telS[pager.getCurrentItem()]);
					mailValue.setText(mailS[pager.getCurrentItem()]);
					SpannableString content = new SpannableString(siteS[pager.getCurrentItem()]);
					content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
					siteValue.setText(content);
					
                    siteValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Chirch.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 Linkify.addLinks(siteValue, Linkify.ALL);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					String[] interestingplaces = getResources().getStringArray(R.array.images);
					page.setText("Page: "+(pager.getCurrentItem()+1)+"/"+(images.length-1));
					

					  
				}

				public void onLoadingCancelled() {
					// Do nothing
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