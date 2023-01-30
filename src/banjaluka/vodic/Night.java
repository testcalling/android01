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

public class Night extends BaseActivity{
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.ac_night);
		int i=0;
		final TextView tv1=(TextView)findViewById(R.id.textVie6);
		final TextView tv2=(TextView)findViewById(R.id.textVie7);
		final TextView tv3=(TextView)findViewById(R.id.textVie8);
	
		final TextView tv10=(TextView)findViewById(R.id.textVie10);
		final TextView tv11=(TextView)findViewById(R.id.textVie11);
		final TextView tv12=(TextView)findViewById(R.id.textVie12);
		
		final TextView tv14=(TextView)findViewById(R.id.textVie14);
		final TextView tv15=(TextView)findViewById(R.id.textVie15);
		final TextView tv16=(TextView)findViewById(R.id.textVie16);
		
		final TextView tv18=(TextView)findViewById(R.id.textVie18);
		final TextView tv19=(TextView)findViewById(R.id.textVie19);
		final TextView tv20=(TextView)findViewById(R.id.textVie20);
		
		final TextView tv22=(TextView)findViewById(R.id.textVie22);
		final TextView tv23=(TextView)findViewById(R.id.textVie23);
		final TextView tv24=(TextView)findViewById(R.id.textVie24);
		
		final TextView tv26=(TextView)findViewById(R.id.textVie26);
		final TextView tv27=(TextView)findViewById(R.id.textVie27);
		final TextView tv28=(TextView)findViewById(R.id.textVie28);
		
		
		
		final TextView tv34=(TextView)findViewById(R.id.textVie34);
		final TextView tv35=(TextView)findViewById(R.id.textVie35);
		final TextView tv36=(TextView)findViewById(R.id.textVie36);
		
		final TextView tv38=(TextView)findViewById(R.id.textVie38);
		final TextView tv39=(TextView)findViewById(R.id.textVie39);
		final TextView tv40=(TextView)findViewById(R.id.textVie40);
		
		final TextView tv42=(TextView)findViewById(R.id.textVie42);
		final TextView tv43=(TextView)findViewById(R.id.textVie43);
		final TextView tv44=(TextView)findViewById(R.id.textVie44);
		
		final TextView tv46=(TextView)findViewById(R.id.textVie46);
		final TextView tv47=(TextView)findViewById(R.id.textVie47);
		final TextView tv48=(TextView)findViewById(R.id.textVie48);
		final String [] url = {"http://www.openstreetmap.org/?mlat=44.80247&mlon=17.22544&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.76801&mlon=17.19901&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.771487&mlon=17.192229&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.760081&mlon=17.198234&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.77372&mlon=17.192612&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.771165&mlon=17.191013&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.769234&mlon=17.189103&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.770457&mlon=17.190095&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.77095&mlon=17.19593&zoom=16&layers=M",
				               "http://www.openstreetmap.org/?mlat=44.76214&mlon=17.18995&zoom=16&layers=M"};
    	
		
		 final Intent ii = new Intent(Intent.ACTION_VIEW);
	   
	
		tv1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 try {
					   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
					   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
					   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
					 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
						   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
						 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
						   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
						 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
							   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
									 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
							   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
									 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
							 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
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
								   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
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
										 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
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
								 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 Linkify.addLinks(tv40, Linkify.ALL);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
				
		        //
                tv42.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
								   toast.show();
								
								   Intent callIntent = new Intent(Intent.ACTION_CALL);
				                    callIntent.setData(Uri.parse("tel:"+ tv42.getText()));
				                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					tv43.setOnClickListener(new OnClickListener() {
						   
				    	
								public void onClick(View v) {
									 try {
										 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
										 toast.show();
										
										     Uri u = null;
									    	 u = Uri.parse(url[8]);
									    
									    	ii.setData(u);
										   //Linkify.addLinks(streetValue, Linkify.ALL);
										 startActivity(ii);

						                } catch (ActivityNotFoundException activityException) {
						                    Log.e("Calling a Phone Number", "Call failed", activityException);
						                }

									
								}
							});
					tv44.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 Linkify.addLinks(tv44, Linkify.ALL);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
                    tv46.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								   Toast toast = Toast.makeText(Night.this, "Calling a Phone Number", Toast.LENGTH_LONG);
								   toast.show();
								
								   Intent callIntent = new Intent(Intent.ACTION_CALL);
				                    callIntent.setData(Uri.parse("tel:"+ tv46.getText()));
				                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
					tv47.setOnClickListener(new OnClickListener() {
						   
				    	
								public void onClick(View v) {
									 try {
										 Toast toast = Toast.makeText(Night.this, "Visit this address", Toast.LENGTH_LONG);
										 toast.show();
										
										     Uri u = null;
									    	 u = Uri.parse(url[9]);
									    
									    	ii.setData(u);
										   //Linkify.addLinks(streetValue, Linkify.ALL);
										 startActivity(ii);

						                } catch (ActivityNotFoundException activityException) {
						                    Log.e("Calling a Phone Number", "Call failed", activityException);
						                }

									
								}
							});
					tv48.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							 try {
								 Toast toast = Toast.makeText(Night.this, "Visit this web site", Toast.LENGTH_LONG);
								 toast.show();
								 Linkify.addLinks(tv48, Linkify.ALL);

				                } catch (ActivityNotFoundException activityException) {
				                    Log.e("Calling a Phone Number", "Call failed", activityException);
				                }

							
						}
					});
				
		
				
		
				
	}
}
