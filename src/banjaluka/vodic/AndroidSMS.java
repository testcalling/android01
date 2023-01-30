package banjaluka.vodic;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import banjaluka.vodic.R;

public class AndroidSMS extends Activity {
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.sms);
      
       final EditText edittextSmsNumber = (EditText)findViewById(R.id.smsnumber);
       final EditText edittextSmsText = (EditText)findViewById(R.id.smstext);
       Button buttonSendSms = (Button)findViewById(R.id.sendsms);
       Button buttonSendSms_intent = (Button)findViewById(R.id.sendsms_intent);
      
       buttonSendSms.setOnClickListener(new Button.OnClickListener(){

  
   public void onClick(View arg0) {
    // TODO Auto-generated method stub
    SmsManager smsManager = SmsManager.getDefault();
    String smsNumber = edittextSmsNumber.getText().toString();
    String smsText = edittextSmsText.getText().toString();
    smsManager.sendTextMessage(smsNumber, null, smsText, null, null);
   }});
      
       buttonSendSms_intent.setOnClickListener(new Button.OnClickListener(){

   public void onClick(View arg0) {
    // TODO Auto-generated method stub

    String smsNumber = edittextSmsNumber.getText().toString();
    String smsText = edittextSmsText.getText().toString();
    
    Uri uri = Uri.parse("smsto:" + smsNumber);
    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
    intent.putExtra("sms_body", smsText);  
    startActivity(intent);
   }});
   }
}
