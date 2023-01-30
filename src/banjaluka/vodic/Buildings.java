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

import com.google.ads.AdView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;


public class Buildings extends BaseActivity{

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
	
	String[] niz={"BanskiDvor. This historical building was built in 1932. and until 1941. it was the residence of the Vrbas principality governor.The Municipality building, the Palace of Republic of Srpska, the Temple Hrista Spasitelja (Christ the Savior) and Banski Dvor represent the historical centre of Banja Luka.Today, Banski Dvor is the cultural centre of Banja Luka or as some locals call it the Temple of Culture. This is the place where concerts, exbitions, theatrical plays and other international cultural artistic manifestations take place. Since 1978. the Banski Dvor is under the state protection.","The Palace of Republic of Srpska","The administrative center of the Government of the Republic of Serbian, was built for the accommodation of the Republic of Serbian institutions, especially government.","The National Assembly of the Republic of Srpska is a legislative body within the structure of power in the Republic of Srpska. It represents the central institution of the parliamentary structure of the Republic of Srpska, conducting normative, control, regulatory and elective functions falling under its competence, in that way providing democratic system and securing the rule of modern democracy in the Republic of Srpska. The National Assembly of the Republic of Srpska commences its work on 24 October, 1991 as the Assembly of the Serbian People of Bosnia and Herzegovina, with the administrative seat in Sarajevo.","The Archives of the Republic of Srpska is republic administrative organization within the Ministry of Education and Culture. The Archives carries out the determined activity in the whole territory of the Republic of Srpska. The Archives has a status of a central institution for the protection of cultural values."};
	String[] telS={"051305336","051248100","051339102","051338104","051340240"};
	String[] streetS={"Trg srpskih vladara 2","Bana Milosavljevica 4","Dr. Mladena Stojanovica","Vuka Karadzica 2","Aleja Svetog Save 1"};
	String[] mailS={"banski_dvor@blic.net","info@predsjednikrs.net","kabinet@vladars.net","/","arhivrs@inecco.net"};
	String[] siteS={"banskidvor.org","www.predsjednikrs.net","www.vladars.net","www.narodnaskupstinars.net","www.arhivrs.org"};


	
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
		
			
			final View imageLayout = inflater.inflate(R.layout.item_buildings, null);
			
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
					Toast.makeText(Buildings.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(R.drawable.error);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();

					
					Animation anim = AnimationUtils.loadAnimation(Buildings.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
					
				

				
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Buildings.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Buildings.this, "Write e-mail", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Buildings.this, "Visit this location", Toast.LENGTH_LONG);
								 toast.show();
								 String [] url = {"http://www.openstreetmap.org/?mlat=44.77304&mlon=17.19238&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77265&mlon=17.19332&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77801&mlon=17.19852&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77497&mlon=17.19349&zoom=16&layers=M",
										          "http://www.openstreetmap.org/?mlat=44.77456&mlon=17.19443&zoom=16&layers=M"
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
								 Toast toast = Toast.makeText(Buildings.this, "Visit this web site", Toast.LENGTH_LONG);
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