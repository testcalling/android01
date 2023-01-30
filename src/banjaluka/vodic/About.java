package banjaluka.vodic;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import banjaluka.vodic.R;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;



import TextViewJustify.TextViewJustify;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class About extends BaseActivity {
 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_about);
        TextView clima = (TextView)findViewById(R.id.tvClimaDesc);
        TextView currency = (TextView)findViewById(R.id.tvCurrencyDesc);
        TextView bank = (TextView)findViewById(R.id.tvBankDesc);
        TextView parking = (TextView)findViewById(R.id.tvParkingDesc);
        TextView tel = (TextView)findViewById(R.id.tvTelDesc);
        TextView food = (TextView)findViewById(R.id.tvFoodDesc);
        TextView drink = (TextView)findViewById(R.id.tvDrinkDesc);
        clima.setText("Banja Luka’s climate is typical of average continental conditions. January is the coldest month of the year with the average high temperature at 3°C and an average low of – 3°C.\nThe warmest month is July which averages between 15°C and 27°C.Rain in Banja Luka peaks in the month of September.\nAverage annual precipitation is approximately 988 mm. Snow decorates the streets of Banja Luka every year.");
		currency.setText("The official currency in Banja Luka and Bosnia and Herzegovina is KM (convertible mark or BOSNIAN CONVERTIBLE MARK - BAM; 1KM = 100 fenings) and your money can be exchanged in exchange offices or in one of the many banks.\nBanknotes are in denominations of 10KM, 20KM, 50KM, 100KM and 200KM while coins are 1KM, 2KM, 5KM or 10, 20 and 50 fenings. You can check out online currency converter for detailed exchange rates.\nCredit cards are accepted at most places in the city, and also there is a large number of ATM’s. ");
		bank.setText("Monday - Friday: 8:00 to 19:00 \nSaturday: 8:00 to 13:00 Sunday is not a working day");
        parking.setText("In Banja Luka, there is a large number of parking spaces in the city center and in the vicinity. On every parking lot there is a parking meter machine where you can buy a parking ticket.\nThe machine accepts coins in denominations of 50 pfennig, 1KM, 2KM and 5KM. Once you have purchased a ticket for parking it is necessary to put it in your car in plain sight as a confirmation that you have paid for parking. Parking meter machine does not returng your change! Parking is paid by the hour, and the price depends on the proximity of downtown so there are two zones:\nZone 1 (RED ZONE) - in the city center. The cost for each hour of parking is 1KM or for an entire day 5KM.\nZone 2 (BLUE ZONE) - downtown vicinity. The cost for each hour of parking is 50 pfennig or a whole day 3KM. Payment of parking can also be made via your mobile phone. You need to send SMS message with your licence plate number (without spaces, lines) to the corresponding phone number. Example:\nlicense plate 123-A-456 SMS 123A456\nlicense plate A12-B-345 SMS A12B345");
        tel.setText("Using a telephone for international calls is quite expensive."

+"\nTo place a call:"
+"\n• To Bosnia and Herzegovina:dial +387"
+"\n• From Bosnia and Herzegovina: dial either 00 or + – country code – city code without the number 0"

+"\nFor local calls, phone booths are usually the best option. Phone booths are often located by the post offices and train/bus stations. To make a call, a relatively inexpensive phone card can be purchased at the post office or at a newspaper kiosk."

+"\nMake sure to check the price before making calls from any hotel.");
        food.setText("If you like meat, you'll love Banja Luka. Meat is a standard for any meal. However, there is still lots of interesting meals you can make do if you are a vegetarian.\n"
+"Here is a list of the most popular traditional dishes:\n"
+"Cevapi - small meat sausages of lamb and beef mix. They are usually served with fresh onions and pita bread on the side. Cevapi usually come in pointer finger size sausages and are offered by five or ten pieces, although the variety commonly found in Banja Luka (banjalucki cevap) usually consists of quadrangular pieces of meat.\n"
+"Teletina - is veal, usually served in cutlets. Veal in BiH is not produced by locking calves in a cage to ensure softer meat.\n"
+"Janjetina - lamb grilled over an open fire.\n"
+"Musaka - a meat pie made of minced beef, very similar to shepherds pie.\n"
+"Filovane paprike - fried peppers stuffed with minced meat and spices.\n"
+"Prsut - air dried ham, similar to Italian proscuitto.\n"
+"Suho Meso - dried meat, either beef or pork.\n"
+"Sarma - meat and rice rolled in cabbage or grape leaves.\n"
+"'Ispod Saca' - similar to Dutch oven. A metal dish is placed on hot coals, the food is placed in the dish and covered by a lid which is then completely covered in hot coals and left to bake.\n"
+"Vlasicki Sir - similar to Travnicki cheese. It is a highland cheese from the mountain villages on Vlasic Mountain in central Bosnia.\n"
+"Mladi Sir - Cottage cheese. It has a soft texture and is unsalted. Often times it is served with a cream sauce on top. It is very healthy.\n"
+"Kajmak - is analogous to clotted cream in the UK. The top layer of fat skimmed from milk, it is creamy and extremely tasty. Kajmak and Ustipak (doughnut type roll) is a wonderful appetizer.\n"
+"Iz mjeha - sheep milk poured into a specially sewn sheep skin 'bag'. After a time the dry cheese is taken out of the skin container and the result is a strong, dry cheese that resembles real Parmesan.\n");
        drink.setText("Rakia or Rakija is considered to be a national drink. Its alcohol content is normally 40%, but home-produced rakia can be a tongue burner, typically 50 to 60%! Frequently used as a common drink at all celebrations, birthdays, holy holidays, slava (Orthodox christian custom of honoring a patron saint) and even funerals. Common flavors are slivovitz, traditionally made from plums and lozova, which is made from grapes. But, you can also distill from pears, peaches, apricots, apples, figs and cherries. Plum and grape rakia are sometimes mixed with other ingredients, such as herbs, honey, sour cherries and walnuts after distillation.\n"
+"Nektar pivo is the local beer, brewed in Banja Luka.");
	   
	}
}
