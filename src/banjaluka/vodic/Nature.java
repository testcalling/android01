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


public class Nature extends BaseActivity{

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
	
	String[] niz={"Banj brdo-Tresnjik. The largest and most famous picnic resort in Banja Luka is located on the south side of town. From the top of Banj Brdo, where there is the monument to fallen soldiers in World War II, you can enjoy a unique view of the whole of Banja Luka. There are a large number of hiking and biking trails, drinking water sources and landscaped picnic sites.","Zoological garden is located about 5 km northeast of the city center. There is a gym in nature.","Ethno Village 'Vuk' Sibovi is located on the southwest side of the city.  In the natural environment, there are decorated picnic sites and several hiking trails. One of the most famous is Banjalucka itinerary.","Cascades of the Krupa. The water mills and the cascades of the Krupa river represent a real attraction for all the visitors to this tiny village. There is a sculpture colony held annually which gathers the artists from all over the world. They are all motivated by miraculous power of nature for their creation.","Eco-camp Zelenkovac is a mountain camp residing at the height of 863 meters above sea level. The Eco-camp is placed on the banks of the clear mountain spring Zelenkovac.  For decades the waters of Zelenkovac have been powering the fifteen watermills placed throughout the area. Throughout the years Zelenkovac has hosted various gatherings such as art-colonies, jazz concerts, 'poetry evenings', school classes in nature, theater shows, sport contests and many other activities."};
	String[] telS={"/","065519657","065437371","/","050278649"};
	String[] streetS={"Put banjaluckog odreda.","Vase Pelagica 58","Sibovi NN","Krupa na Vrbasu NN","Zelenkovac NN,Podrasnica, Mrkonjic Grad"};
	String[] mailS={"/","/","drljacaranka@hotmail.com","/","zelenkovac@blic.net"};
	String[] siteS={"/","/","/","/","www.zelenkovac.org"};
	
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
		
			
			final View imageLayout = inflater.inflate(R.layout.item_nature, null);
			
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
					Toast.makeText(Nature.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();
				
					
					Animation anim = AnimationUtils.loadAnimation(Nature.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
			
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Nature.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Nature.this, "Write e-mail", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Nature.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 String [] url = {"http://www.openstreetmap.org/?mlat=44.74438&mlon=17.16373&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.7984&mlon=17.22979&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.76932&mlon=17.16581&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.61672&mlon=17.1373&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.3941&mlon=16.9806&zoom=16&layers=M"
								          
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
								 Toast toast = Toast.makeText(Nature.this, "Visit this web site", Toast.LENGTH_LONG);
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