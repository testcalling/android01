package banjaluka.vodic;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import banjaluka.vodic.R;


import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class Shopping extends BaseActivity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.ac_shopping);
		int i=0;
		final TextView tv1=(TextView)findViewById(R.id.textV6);
		final TextView tv2=(TextView)findViewById(R.id.textV7);
		final TextView tv3=(TextView)findViewById(R.id.textV8);
	
		final TextView tv10=(TextView)findViewById(R.id.textV10);
		final TextView tv11=(TextView)findViewById(R.id.textV11);
		final TextView tv12=(TextView)findViewById(R.id.textV12);
		
		final TextView tv14=(TextView)findViewById(R.id.textV14);
		final TextView tv15=(TextView)findViewById(R.id.textV15);
		final TextView tv16=(TextView)findViewById(R.id.textV16);
		
		final TextView tv18=(TextView)findViewById(R.id.textV18);
		final TextView tv19=(TextView)findViewById(R.id.textV19);
		final TextView tv20=(TextView)findViewById(R.id.textV20);
		
		final TextView tv22=(TextView)findViewById(R.id.textV22);
		final TextView tv23=(TextView)findViewById(R.id.textV23);
		final TextView tv24=(TextView)findViewById(R.id.textV24);
		
		
		final String [] url = {"http://www.openstreetmap.org/?mlat=44.7757344.76844&mlon=17.20592&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.78958&mlon=17.20365&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.770061&mlon=17.190024&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.775629&mlon=17.197582&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.768641&mlon=17.189997&zoom=16&layers=M"};
    	
		
		 final Intent ii = new Intent(Intent.ACTION_VIEW);
	   
	
		tv1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					   Toast toast = Toast.makeText(Shopping.this, "Calling a Phone Number", Toast.LENGTH_LONG);
					   toast.show();
					
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv1.getText()));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		tv2.setOnClickListener(new OnClickListener() {
			   
	    	
					public void onClick(View v) {
						 try {
							 Toast toast = Toast.makeText(Shopping.this, "Visit this web site", Toast.LENGTH_LONG);
							 toast.show();
							
							     Uri u = null;
						    	 u = Uri.parse(url[0]);
						    
						    	ii.setData(u);
							   //Linkify.addLinks(streetValue, Linkify.ALL);
							 startActivity(ii);

			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
		tv3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					 Toast toast = Toast.makeText(Shopping.this, "Visit this address", Toast.LENGTH_LONG);
					 toast.show();
					 Linkify.addLinks(tv3, Linkify.ALL);

	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		//
      tv10.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					   Toast toast = Toast.makeText(Shopping.this, "Calling a Phone Number", Toast.LENGTH_LONG);
					   toast.show();
					
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv10.getText()));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		tv11.setOnClickListener(new OnClickListener() {
			   
	    	
					public void onClick(View v) {
						 try {
							 Toast toast = Toast.makeText(Shopping.this, "Visit this address", Toast.LENGTH_LONG);
							 toast.show();
							
							     Uri u = null;
						    	 u = Uri.parse(url[1]);
						    
						    	ii.setData(u);
							   //Linkify.addLinks(streetValue, Linkify.ALL);
							 startActivity(ii);

			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
		tv12.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					 Toast toast = Toast.makeText(Shopping.this, "Visit this web site", Toast.LENGTH_LONG);
					 toast.show();
					 Linkify.addLinks(tv12, Linkify.ALL);

	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		//
     tv14.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					   Toast toast = Toast.makeText(Shopping.this, "Calling a Phone Number", Toast.LENGTH_LONG);
					   toast.show();
					
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv14.getText()));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		tv15.setOnClickListener(new OnClickListener() {
			   
	    	
					public void onClick(View v) {
						 try {
							 Toast toast = Toast.makeText(Shopping.this, "Visit this address", Toast.LENGTH_LONG);
							 toast.show();
							
							     Uri u = null;
						    	 u = Uri.parse(url[2]);
						    
						    	ii.setData(u);
							   //Linkify.addLinks(streetValue, Linkify.ALL);
							 startActivity(ii);

			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
		tv16.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					 Toast toast = Toast.makeText(Shopping.this, "Visit this web site", Toast.LENGTH_LONG);
					 toast.show();
					 Linkify.addLinks(tv16, Linkify.ALL);

	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
		//
		 tv18.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					 try {
						   Toast toast = Toast.makeText(Shopping.this, "Calling a Phone Number", Toast.LENGTH_LONG);
						   toast.show();
						
						   Intent callIntent = new Intent(Intent.ACTION_CALL);
		                    callIntent.setData(Uri.parse("tel:"+ tv18.getText()));
		                    startActivity(callIntent);
		                } catch (ActivityNotFoundException activityException) {
		                    Log.e("Calling a Phone Number", "Call failed", activityException);
		                }

					
				}
			});
			tv19.setOnClickListener(new OnClickListener() {
				   
		    	
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Shopping.this, "Visit this address", Toast.LENGTH_LONG);
								 toast.show();
								
								     Uri u = null;
							    	 u = Uri.parse(url[3]);
							    
							    	ii.setData(u);
								   //Linkify.addLinks(streetValue, Linkify.ALL);
								 startActivity(ii);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
			tv20.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					 try {
						 Toast toast = Toast.makeText(Shopping.this, "Visit this web site", Toast.LENGTH_LONG);
						 toast.show();
						 Linkify.addLinks(tv20, Linkify.ALL);

		                } catch (ActivityNotFoundException activityException) {
		                    Log.e("Calling a Phone Number", "Call failed", activityException);
		                }

					
				}
			});
			//
          tv22.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					 try {
						   Toast toast = Toast.makeText(Shopping.this, "Calling a Phone Number", Toast.LENGTH_LONG);
						   toast.show();
						
						   Intent callIntent = new Intent(Intent.ACTION_CALL);
		                    callIntent.setData(Uri.parse("tel:"+ tv22.getText()));
		                    startActivity(callIntent);
		                } catch (ActivityNotFoundException activityException) {
		                    Log.e("Calling a Phone Number", "Call failed", activityException);
		                }

					
				}
			});
			tv23.setOnClickListener(new OnClickListener() {
				   
		    	
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Shopping.this, "Visit this address", Toast.LENGTH_LONG);
								 toast.show();
								
								     Uri u = null;
							    	 u = Uri.parse(url[4]);
							    
							    	ii.setData(u);
								   //Linkify.addLinks(streetValue, Linkify.ALL);
								 startActivity(ii);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
			tv24.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					 try {
						 Toast toast = Toast.makeText(Shopping.this, "Visit this web site", Toast.LENGTH_LONG);
						 toast.show();
						 Linkify.addLinks(tv24, Linkify.ALL);

		                } catch (ActivityNotFoundException activityException) {
		                    Log.e("Calling a Phone Number", "Call failed", activityException);
		                }

					
				}
			});
			//
			
				
		
			 
		
				
	}
}
