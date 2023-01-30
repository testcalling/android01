package banjaluka.vodic;



import banjaluka.vodic.R;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public abstract class BaseActivity extends Activity {

	protected ImageLoader imageLoader = ImageLoader.getInstance();
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		
		switch (item.getItemId()) {
			case R.id.item_clear_memory_cache:
				imageLoader.clearMemoryCache();
				return true;
			case R.id.item_clear_disc_cache:
				imageLoader.clearDiscCache();
			case R.id.exit:
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
				return true;
			case R.id.contact:
				try {
					 Toast toast = Toast.makeText(BaseActivity.this, "Write e-mail", Toast.LENGTH_LONG);
					 toast.show();
					
					 Intent intent = new Intent(Intent.ACTION_SEND);
					 intent.setType("text/plain");
					 intent.putExtra(Intent.EXTRA_EMAIL  ,new String[]{"softlysolutions@gmail.com".toString()});
					
					 startActivity(Intent.createChooser(intent, "Send mail..."));

	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Mailing", "Mail failed", activityException);
	                }
				
				return true;
			default:
				return false;
		}
	}
}
