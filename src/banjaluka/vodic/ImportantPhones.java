package banjaluka.vodic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import banjaluka.vodic.R;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ImportantPhones extends BaseActivity{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_phones);
		loadViews();
		
		 
				

		
	}
	public void loadViews()
	{
		
	    ((TextView)findViewById(R.id.textView2)).setText("Notification center");
	    ((TextView)findViewById(R.id.textView4)).setText("Police");
	    ((TextView)findViewById(R.id.textView6)).setText("Fire department");
	    ((TextView)findViewById(R.id.textView8)).setText("Ambulance");
	    
	   // ((TextView)findViewById(R.id.textView10)).setText("Current time");
	    ((TextView)findViewById(R.id.textView12)).setText("Information");
	    ((TextView)findViewById(R.id.textView14)).setText("Wakeup ordering");
	    ((TextView)findViewById(R.id.textView16)).setText("Handing telegrams by phone");
	    
	    ((TextView)findViewById(R.id.textView18)).setText("Bus station");
	    ((TextView)findViewById(R.id.textView20)).setText("Train station");
	    ((TextView)findViewById(R.id.textView22)).setText("Pharmacy '1.May'");
	    ((TextView)findViewById(R.id.textView24)).setText("Airport 'Mahovljani'");
	    ((TextView)findViewById(R.id.textView26)).setText("Banja Luka Fair");
	    
	    ((TextView)findViewById(R.id.textView30)).setText("Banja Luka Taxi");
	    ((TextView)findViewById(R.id.textView32)).setText("Euro Taxi");
	    final TextView tv3=(TextView)findViewById(R.id.textView3);
	    tv3.setText(Html.fromHtml("<u>121</u>"));
	    tv3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv3.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv5=(TextView)findViewById(R.id.textView5);
	    tv5.setText(Html.fromHtml("<u>122</u>"));
	    tv5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv5.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv7=(TextView)findViewById(R.id.textView7);
	    tv7.setText(Html.fromHtml("<u>123</u>"));
	    tv7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv7.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv9=(TextView)findViewById(R.id.textView9);
	    tv9.setText(Html.fromHtml("<u>124</u>"));
	    tv9.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv9.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv11=(TextView)findViewById(R.id.textView11);
	    tv11.setText(Html.fromHtml("<u>125</u>"));
	    tv11.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv11.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv13=(TextView)findViewById(R.id.textView13);
	    tv13.setText(Html.fromHtml("<u>1185</u>"));
	    tv13.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv13.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv15=(TextView)findViewById(R.id.textView15);
	    tv15.setText(Html.fromHtml("<u>1401</u>"));
	    tv15.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv15.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv17=(TextView)findViewById(R.id.textView17);
	    tv17.setText(Html.fromHtml("<u>1202</u>"));
	    tv17.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv17.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv19=(TextView)findViewById(R.id.textView19);
	    tv19.setText(Html.fromHtml("<u>090513000</u>"));
	    tv19.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv19.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv21=(TextView)findViewById(R.id.textView21);
	    tv21.setText(Html.fromHtml("<u>051301229</u>"));
	    tv21.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv21.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv23=(TextView)findViewById(R.id.textView23);
	    tv23.setText(Html.fromHtml("<u>051211088</u>"));
	    tv23.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv23.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv25=(TextView)findViewById(R.id.textView25);
	    tv25.setText(Html.fromHtml("<u>051830235</u>"));
	    tv25.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv25.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv27=(TextView)findViewById(R.id.textView27);
	    tv27.setText(Html.fromHtml("<u>051313281</u>"));
	    tv27.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv27.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    final TextView tv30=(TextView)findViewById(R.id.textView30);
	    tv30.setText(Html.fromHtml("<u>1544</u>"));
	    tv30.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv30.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv32=(TextView)findViewById(R.id.textView32);
	    tv32.setText(Html.fromHtml("<u>1555</u>"));
	    tv32.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv32.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv34=(TextView)findViewById(R.id.textView34);
	    tv34.setText(Html.fromHtml("<u>1551</u>"));
	    tv34.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv34.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv36=(TextView)findViewById(R.id.textView36);
	    tv36.setText(Html.fromHtml("<u>1550</u>"));
	    tv36.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv36.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv38=(TextView)findViewById(R.id.textView38);
	    tv38.setText(Html.fromHtml("<u>1533</u>"));
	    tv38.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv38.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv40=(TextView)findViewById(R.id.textView40);
	    tv40.setText(Html.fromHtml("<u>1550</u>"));
	    tv40.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv40.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv42=(TextView)findViewById(R.id.textView42);
	    tv42.setText(Html.fromHtml("<u>1566</u>"));
	    tv42.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv42.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv46=(TextView)findViewById(R.id.textView46);
	    tv46.setText(Html.fromHtml("<u>051213355</u>"));
	    tv46.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv46.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv48=(TextView)findViewById(R.id.textView48);
	    tv48.setText(Html.fromHtml("<u>051321530</u>"));
	    tv48.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv48.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv50=(TextView)findViewById(R.id.textView50);
	    tv50.setText(Html.fromHtml("<u>051224700</u>"));
	    tv50.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv50.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv52=(TextView)findViewById(R.id.textView52);
	    tv52.setText(Html.fromHtml("<u>051309103</u>"));
	    tv52.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv52.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    final TextView tv54=(TextView)findViewById(R.id.textView54);
	    tv54.setText(Html.fromHtml("<u>051443440</u>"));
	    tv54.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 try {
					   Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ tv54.getText().toString()));
	                    startActivity(callIntent);
				                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }

				
			}
		});
	    
	    
    	}
	
	}
