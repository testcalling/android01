package banjaluka.vodic;



import banjaluka.vodic.R;


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


import java.awt.*;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;


public class Adventure extends BaseActivity{

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
	
	String[] niz={"Vrbas river is a mighty fast mountain river with a numerous wild parts and it is one of the most attractive rivers in Europe with the degree of difficulty 3-4. Vrbas river makes its way through two canyons - the canyon Tijesno and the  canyon Podmilacje. The length of the Vrbas River, which is suitable for water sports and adventures is 31 kilometers. The international degree of difficulty of the river Vrbas is 3-4 and in some places it is 1-2 so the river is suitable for people looking for wild adventure and adrenaline, but also for family enjoyment and peaceful activities. Given that there is a dam which regulates the flow of the Vrbas, water flow varies from 25 to 100 m3, and in spring it is more than 500 m3. The average summer temperature is 17 degrees Celsius, but the air is 30 degrees, which enables a comfortable adventure, vacation and enjoyment on the water. VrbasRiver is one of the most beautiful rivers in Bosnia and Herzegovina and in Europe thanks to the canyon, the rapids and cascades. Every year Banja Luka and the river Vrbas, host numerous competitions kayak, canoe and rafting. Rafting on the Vrbas is possible during the whole year and the best period is the spring and the summer. Banja Luka is the only city in Europe which offers night rafting! Discover why Banja Luka hosted the World Rafting Championships 2009 and European Kayak and Canoe Championship 2011.","Banja Luka Tandem Skydive. If you've always wanted to try out skydiving and didn�t have the courage or because of health or similar reasons, then the tandem jump is the thing for you. This safest parachute jump is performed with the accompaniment of professional instructor whom is linked to you with a tandem parachute. Preparations for such jump are performed at ground and last up to 30 minutes. All tandem jumps are performed from a height of 3000 meters where the free fall is of about 40 seconds. After opening the parachute at the altitude of 1500 meters you get to enjoy a comfortable parachute ride and panoramic tour of the environment. The price for one tandem jump is EUR 150 and photo&video of the jump is EUR 40. Jump and experience the adrenaline adventure!","Paintball is a sport in which players eliminate opponents by shootting at them with replicas of real weapons which fire paintballs(small balls filled with colour paint). Paintball is played in several fields such as natural fields and forests, speedball fields with inflatable obstacles, the old abandoned buildings ... It is up to you to choose! In paintball there are different games so one game can be played from a couple of seconds to several hours. We provide you with the best equipment and protection for the game: electronic markers, thermal masks, air bottles, protective suits, neck protectors and gloves for ladies and the youngest players. Experience the unforgettable painball adventure!","Banja Luka Rock Climbing. Thanks to the numerous hills and mountains, Banja Luka is a small paradise for rock climbing lovers. The area boasts several rock climbing sectors, with nice climbing routes of varying difficulty. You do not have to be experienced to try rock climbing, our professional guides will help you to feel the adrenaline, adventure and to test your limits."};
	String[] telS={"065932714","065974665","065699740","065326099"};
	String[] streetS={"Momcila Nastasijevica at no. 30","Jovana Ducica 100","Kralja Aleksandra I Karadjordjevica 108","Bulevar vojvode Petra Bojovica 1"};
	String[] mailS={"info@raftingvrbas.com","Padobranski.klub.banjaluka@gmail.com","info@kes-borac.com","extremebl@gmail.com"};
	String[] siteS={"www.raftingvrbas.com","www.padobranci.net","www.kes-borac.com","www.extremebl.com"};
	
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
					Toast.makeText(Adventure.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();
					
					
					Animation anim = AnimationUtils.loadAnimation(Adventure.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
			
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Adventure.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Adventure.this, "Write e-mail", Toast.LENGTH_LONG);
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
									 Toast toast = Toast.makeText(Adventure.this, "Visit this web site", Toast.LENGTH_LONG);
									 toast.show();
									 String [] url = {"http://www.openstreetmap.org/?mlat=44.74879&mlon=17.15664&zoom=16&layers=M",
									          "http://www.openstreetmap.org/?mlat=44.77448&mlon=17.18692&zoom=16&layers=M",
									          "http://www.openstreetmap.org/?mlat=44.77258&mlon=17.19094&zoom=16&layers=M",
									          "http://www.openstreetmap.org/?mlat=44.77248&mlon=17.20905&zoom=16&layers=M"
									          
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
								 
								 Toast toast = Toast.makeText(Adventure.this, "Visit this location", Toast.LENGTH_LONG);
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