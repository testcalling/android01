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


public class Rest extends BaseActivity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.ac_rest);
		int i=0;
		final TextView tv1=(TextView)findViewById(R.id.textView6);
		final TextView tv2=(TextView)findViewById(R.id.textView7);
		final TextView tv3=(TextView)findViewById(R.id.textView8);
	
		final TextView tv10=(TextView)findViewById(R.id.textView10);
		final TextView tv11=(TextView)findViewById(R.id.textView11);
		final TextView tv12=(TextView)findViewById(R.id.textView12);
		
		final TextView tv14=(TextView)findViewById(R.id.textView14);
		final TextView tv15=(TextView)findViewById(R.id.textView15);
		final TextView tv16=(TextView)findViewById(R.id.textView16);
		
		final TextView tv18=(TextView)findViewById(R.id.textView18);
		final TextView tv19=(TextView)findViewById(R.id.textView19);
		final TextView tv20=(TextView)findViewById(R.id.textView20);
		
		final TextView tv22=(TextView)findViewById(R.id.textView22);
		final TextView tv23=(TextView)findViewById(R.id.textView23);
		final TextView tv24=(TextView)findViewById(R.id.textView24);
		
		final TextView tv26=(TextView)findViewById(R.id.textView26);
		final TextView tv27=(TextView)findViewById(R.id.textView27);
		final TextView tv28=(TextView)findViewById(R.id.textView28);
		
		
		
		final TextView tv34=(TextView)findViewById(R.id.textView34);
		final TextView tv35=(TextView)findViewById(R.id.textView35);
		final TextView tv36=(TextView)findViewById(R.id.textView36);
		
		final TextView tv38=(TextView)findViewById(R.id.textView38);
		final TextView tv39=(TextView)findViewById(R.id.textView39);
		final TextView tv40=(TextView)findViewById(R.id.textView40);
		final String [] url = {"http://www.openstreetmap.org/?mlat=44.771521&mlon=17.190564&zoom=16&layers=M","http://www.openstreetmap.org/?mlat=44.772797&mlon=17.195022&zoom=16&layers=M","http://www.openstreetmap.org/?mlat=44.763697&mlon=17.209013&zoom=16&layers=M","http://www.openstreetmap.org/?mlat=44.80241&mlon=17.22565&zoom=16&layers=M","http://www.openstreetmap.org/?mlat=44.75253&mlon=17.1676&zoom=16&layers=M#","http://www.openstreetmap.org/?mlat=44.7734&mlon=17.19457&zoom=16&layers=M#","http://www.openstreetmap.org/?mlat=44.766019&mlon=17.190713&zoom=16&layers=M#","http://www.openstreetmap.org/?mlat=44.764956&mlon=17.189967&zoom=16&layers=M#"};
    	
		
		 final Intent ii = new Intent(Intent.ACTION_VIEW);
	   
		
		
		
	   
		
		tv1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
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
					   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
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
					   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
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
						   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
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
						 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
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
						   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
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
						 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
						 toast.show();
						 Linkify.addLinks(tv24, Linkify.ALL);

		                } catch (ActivityNotFoundException activityException) {
		                    Log.e("Calling a Phone Number", "Call failed", activityException);
		                }

					
				}
			});
			//
			 tv26.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						 try {
							   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
							   toast.show();
							
							   Intent callIntent = new Intent(Intent.ACTION_CALL);
			                    callIntent.setData(Uri.parse("tel:"+ tv26.getText()));
			                    startActivity(callIntent);
			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
				tv27.setOnClickListener(new OnClickListener() {
					   
			    	
							public void onClick(View v) {
								 try {
									 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
									 toast.show();
									
									     Uri u = null;
								    	 u = Uri.parse(url[5]);
								    
								    	ii.setData(u);
									   //Linkify.addLinks(streetValue, Linkify.ALL);
									 startActivity(ii);

					                } catch (ActivityNotFoundException activityException) {
					                    Log.e("Calling a Phone Number", "Call failed", activityException);
					                }

								
							}
						});
				tv28.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						 try {
							 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
							 toast.show();
							 Linkify.addLinks(tv28, Linkify.ALL);

			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
				
				//
               tv34.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						 try {
							   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
							   toast.show();
							
							   Intent callIntent = new Intent(Intent.ACTION_CALL);
			                    callIntent.setData(Uri.parse("tel:"+ tv34.getText()));
			                    startActivity(callIntent);
			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
				tv35.setOnClickListener(new OnClickListener() {
					   
			    	
							public void onClick(View v) {
								 try {
									 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
									 toast.show();
									
									     Uri u = null;
								    	 u = Uri.parse(url[6]);
								    
								    	ii.setData(u);
									   //Linkify.addLinks(streetValue, Linkify.ALL);
									 startActivity(ii);

					                } catch (ActivityNotFoundException activityException) {
					                    Log.e("Calling a Phone Number", "Call failed", activityException);
					                }

								
							}
						});
				tv36.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						 try {
							 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
							 toast.show();
							 Linkify.addLinks(tv36, Linkify.ALL);

			                } catch (ActivityNotFoundException activityException) {
			                    Log.e("Calling a Phone Number", "Call failed", activityException);
			                }

						
					}
				});
				 tv38.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Rest.this, "Calling a Phone Number", Toast.LENGTH_LONG);
								   toast.show();
								
								   Intent callIntent = new Intent(Intent.ACTION_CALL);
				                    callIntent.setData(Uri.parse("tel:"+ tv38.getText()));
				                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					tv39.setOnClickListener(new OnClickListener() {
						   
				    	
								public void onClick(View v) {
									 try {
										 Toast toast = Toast.makeText(Rest.this, "Visit this address", Toast.LENGTH_LONG);
										 toast.show();
										
										     Uri u = null;
									    	 u = Uri.parse(url[7]);
									    
									    	ii.setData(u);
										   //Linkify.addLinks(streetValue, Linkify.ALL);
										 startActivity(ii);

						                } catch (ActivityNotFoundException activityException) {
						                    Log.e("Calling a Phone Number", "Call failed", activityException);
						                }

									
								}
							});
					tv40.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Rest.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 Linkify.addLinks(tv40, Linkify.ALL);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
				
		
				  
		
		
		
				
	}
}
