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


public class Culture extends BaseActivity{

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
	
	String[] niz={"Svetislav Milosavljevic founded the Museum 1930. and since then the Museum is a very important cultural historic institution of Banja Luka. Until the World War II , when the building suffered a lot damage, the Museum was tha place of many historical exbitions. After the war, the Museum continues to work and today it is located in the centre of the city where you can see a number of historical exhibitions.","The former building of the railway station today is the Museum of Modern Art in Banja Luka and is located in the city center. The building was renovated in the 1980th for the purposes of the former gallery, and few years ago the gallery was transforem to the Museum. The Museum is open every day and there are numerous exhibitions of paintings, sculptures, photographs and other arts.","The National Theatre of Republic of Srpska was founded 1930. in Banja Luka and plays an important role in development of culture and art in the city.The first play was on October 18th 1930. with the presence of the governor Svetislav Milosavljevic who did a lot for the founding of the Theatre. Today plays are performed every day and one the most popular festivals in Banja Luka, the „Teatar Fest“, takes place at the National Theatre.","Multiplex cinema Palas has 676 seats, arranged in 4 air-conditioned rooms furnished with comfortable armchairs and most advanced technical equipment for film projection and superior digital stereo surround sound. In the lobby of the multiplex are Cinema cafe, billiards room and hall with fun games. On the repertoire of the cinema there films by leading U.S. companies, independent films and local productions. The cinema is located in the center of the city on the main square next to Boska.","Music Pavilion and coffee shop Staklenac are located in the heart of the city - in the Park Petar Kocic. Every day there are many cultural and entertainment events held here. The Music Pavilion is ideal for organizing music, dance and literary events, seminars, promotions, presentations, conferences, fashion shows, exhibitions, etc. Coffee shop Staklenac is located on the ground floor and it’s available for catering services."};
	String[] telS={"051215973","051215364","051317996","051211732","066119182"};
	String[] streetS={"Djure Danicica 1.","Trg srpskih junaka 2.","Kralja Petra I Karadjordjevica 78.","Bana Milosavljevica.","Kralja Petra I Karadjordjevica."};
	String[] mailS={"/","galrs@inecco.net","nprs@teol.net","blbioskop@bl-bioskop.ba","muzickipaviljon@aquana.ba"};
	String[] siteS={"www.muzejrs.com","www.msurs.org","www.np.rs.ba","www.bl-bioskop.ba","/"};
	
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
		private void load(){
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
		
			
			final View imageLayout = inflater.inflate(R.layout.item_culture, null);
			
			final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
			final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);

			imageLoader.displayImage(images[position], imageView, options, new ImageLoadingListener() {
				public void set()
				{
					
	telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Culture.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Culture.this, "Write e-mail", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Culture.this, "Visit this location", Toast.LENGTH_LONG);
								 toast.show();
								 String [] url = {"http://www.openstreetmap.org/?mlat=44.76913&mlon=17.19136&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.772249&mlon=17.189708&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.774145&mlon=17.193442&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.769855&mlon=17.189263&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77049&mlon=17.18822&zoom=16&layers=M"
								          
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
								 Toast toast = Toast.makeText(Culture.this, "Visit this web site", Toast.LENGTH_LONG);
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
					Toast.makeText(Culture.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					set();
					
					load();
					spinner.setVisibility(View.GONE);
					
					
					
					
					Animation anim = AnimationUtils.loadAnimation(Culture.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
			
				
					

					  
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