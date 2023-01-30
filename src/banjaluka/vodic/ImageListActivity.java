package banjaluka.vodic;

import java.util.ArrayList;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import banjaluka.vodic.R;


import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class ImageListActivity extends BaseActivity {

	private String[] imageUrls;

	private DisplayImageOptions options;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_image_list);

		
		/*ArrayList<JSONClass> jSonObject = new JSONClass().getJson();
		String [] jSonPictures = new String[new JSONClass().getJson().size()];
		for(int i = 0; i < jSonPictures.length; i++){
			jSonPictures[i] = "http://dev.ultimax.ba/web/shop/index.php?r=json/ComboImage&id=" + jSonObject.get(i).getId();
		}
		
		imageUrls = jSonPictures;*/
		
		options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.stub_image)
			.cacheInMemory()
			.cacheOnDisc()
			.build();

		ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(new ItemAdapter());
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				startImageGalleryActivity(position);
				
			}
		});
	}

	@Override
	protected void onStop() {
		imageLoader.stop();
		super.onStop();
	}

	private void startImageGalleryActivity(int position) {
		Intent intent = new Intent(this, ImagePagerActivity.class);
		intent.putExtra(Extra.IMAGES, imageUrls);
		intent.putExtra(Extra.IMAGE_POSITION, position);
		startActivity(intent);
	}

	class ItemAdapter extends BaseAdapter {

		private class ViewHolder {
			public TextView text;
			public ImageView image;
		}

		public int getCount() {
			return imageUrls.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			View view = convertView;
			final ViewHolder holder;
			if (convertView == null) {
				view = getLayoutInflater().inflate(R.layout.item_list_image, null);
				holder = new ViewHolder();
				holder.text = (TextView) view.findViewById(R.id.text);
				holder.image = (ImageView) view.findViewById(R.id.image);
				view.setTag(holder);
			} else
				holder = (ViewHolder) view.getTag();
			//ArrayList<JSONClass> jSonObjects = new JSONClass().getJson();
			//holder.text.setText(jSonObjects.get(position).getName());

			imageLoader.displayImage(imageUrls[position], holder.image, options);

			return view;
		}
	}
}