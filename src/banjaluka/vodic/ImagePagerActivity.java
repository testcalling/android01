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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import banjaluka.vodic.R;

import java.awt.*;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class ImagePagerActivity extends BaseActivity {

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
	
	String[] niz={"Krajina Square","Trg Krajine, se nalazi u ulici Kralja Petra Karađorđevića.snfjkndsjkn frd fjkndkjgfn klfdkot jfdgjknfd jklgnfd kljnfdg klnjklfdfd kljlfdlfdj glkfd kljgdf lkjfdklg fd lfdkjglfd lkfd klfd klfdjgl dfdl lfdkjgd flkfd lfd klgfdj fd klfdg lfdk jgklfdjg ilkklfdj glfdkg jklfdgjkldfglkfdjg lfdjkg klgfd fed.,m fndjklsnfj dsu fhjkdshf iudjskf hd jkdhf jkhjkfs dkdsjkdsf jkdshf kjds fjksdhf kdskj jkdsfh ds kdsfj kdsjf ds kkds fkdsfjh kdskdsjhf kdsjfhk ds kdsjhf dksjhf sdfk sdskj hf  dshf jkhdsf djs f","065/182777","text4","text5","ddd","dddd","ddd"};
	String[] telS={"06545454","06587874455","065/182777","text4","text5"};
	
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
		
		
       
        	
        
		
		/*pager.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent e) {
				if( e.getAction()==MotionEvent.ACTION_MOVE | e.getAction()==MotionEvent.EDGE_LEFT){
					//actionTouch ();
				}
				return false;
			}
		});*/
		    
	
				
	}
    /*public void actionTouch ()
    {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(pager.getCurrentItem())
	       .setCancelable(false)
	       .setPositiveButton("dsds", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	                
	           }
	       })
	       .setNegativeButton("dsds", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	                dialog.cancel();
	           }
	       });
	AlertDialog alert = builder.create();
	alert.show();
    	
    }*/
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
		
			
			final View imageLayout = inflater.inflate(R.layout.item_pager_image, null);
			
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
					Toast.makeText(ImagePagerActivity.this, message, Toast.LENGTH_SHORT).show();

					spinner.setVisibility(View.GONE);
					imageView.setImageResource(android.R.drawable.ic_delete);
				}

				public void onLoadingComplete(Bitmap loadedImage) {
					
					spinner.setVisibility(View.GONE);
					
					
					currentItem = pager.getCurrentItem();
					System.out.println(pager.getCurrentItem());
					
					Animation anim = AnimationUtils.loadAnimation(ImagePagerActivity.this, R.anim.fade_in);
					imageView.setAnimation(anim);
					
				
					anim.start();
					
				

				
					telValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
				                    Intent callIntent = new Intent(Intent.ACTION_CALL);
				                    callIntent.setData(Uri.parse("tel:"+ tel.getText().toString()));
				                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					
					
					
					mailValue.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.email");
								 startActivity(intent);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					tv.setText(niz[i]);TextViewJustify.justifyText(((TextView)findViewById(R.id.tv)), 305f); 
					streetValue.setText("Ivana Kukuljevica 37");
					
                    
					telValue.setText("0005656");
					mailValue.setText("Mail: a@gmail.com");
					
					
					String[] interestingplaces = getResources().getStringArray(R.array.images);
					page.setText("Page: "+(pager.getCurrentItem()+1)+"/"+images.length);
					

					  
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