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


public class Sport extends BaseActivity{

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
	
	String[] niz={"Aquana, offers the following services: Water park, Aquana restaurant and Sorriso food.","Wellness fortuna offers the following services: hotel, restaurants, wine club, wellness, swimming pool, sport clubs and playroom.","Eco center 'Ljekarice.'","City Olympic pool, offers the following services: swimming lessons, aqua aerobic and additional content.","Tourist centre Balkana has five extremely modern and comfortable bungalows, equipped to the highest standards and fitting perfectly in a natural settings. Each bungalow has private terrace overlooking the lake, satellite television, living room area, comfortable bedrooms. Bungalows can accommodate up to 30 guests, and up to 15 guests can be accommodate in the rooms which are part of restaurant complex. Hotel Krajina, located in the town of Mrkonjic Grad, is also open to visitors and can accommodate up to 50 guests. After the renovation, all rooms offer the higest standards in modern hotel comfort.","F.C. Borac","Banj hill-Gym in nature.","Riding Club-Cokorska polja,Banja Luka"};
	String[] telS={"051228400","051358641","052318089","051456230","050212505","051301793","/","065034518"};
	String[] streetS={"Aleja Svetog Save 80.","Rakovackih rudara 12.","Eko-Centar 'Ljekarice'.","Veljka Mladjenovica N.N.","Tourist centre BALKANA, Mrkonjic Grad.","Vladike Platona 6.","Brace Jugovica.","Cokorska polja"};
	String[] mailS={"info@aquana.ba","fortuna1@teol.net","ekocentarljekarice@yahoo.com","gob@aquana.ba","tcbalkana@yahoo.com","kontakt@fkborac.net","/","/"};
	String[] siteS={"aquana.ba","www.wellnessfortuna.net","www.ekocentarljekarice.com/","aquana.ba/gob/","www.tcbalkana.com/en/index.php","www.fkborac.net/sajt/","/","http://www.cokorska-polja.com"};
	
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
		
			
			final View imageLayout = inflater.inflate(R.layout.item_sport, null);
			
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
					Toast.makeText(Sport.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();
				
					
					Animation anim = AnimationUtils.loadAnimation(Sport.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
			
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Sport.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Sport.this, "Write e-mail", Toast.LENGTH_LONG);
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
					
					 SpannableString content = new SpannableString(streetS[pager.getCurrentItem()]);
						content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
						streetValue.setText(content);
				    	
					    streetValue.setOnClickListener(new OnClickListener() {
					   
					    	
							public void onClick(View v) {
								 try {
									 Toast toast = Toast.makeText(Sport.this, "Visit this location", Toast.LENGTH_LONG);
									 toast.show();
									 String [] url = {"http://www.openstreetmap.org/?mlat=44.77448&mlon=17.20061&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.79475&mlon=17.19249&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.8898&mlon=16.8962&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.77141&mlon=17.22239&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.41606&mlon=17.04841&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.774702&mlon=17.197122&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.75676&mlon=17.18308&zoom=16&layers=M",
											          "http://www.openstreetmap.org/?mlat=44.78424&mlon=17.15893&zoom=16&layers=M"
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
					
                    
					telValue.setText(telS[pager.getCurrentItem()]);
					mailValue.setText(mailS[pager.getCurrentItem()]);
					SpannableString content1 = new SpannableString(siteS[pager.getCurrentItem()]);
					content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
					siteValue.setText(content1);
					
                    siteValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 
								 
								 Toast toast = Toast.makeText(Sport.this, "Visit this web site", Toast.LENGTH_LONG);
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