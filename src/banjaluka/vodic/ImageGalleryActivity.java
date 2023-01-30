package banjaluka.vodic;

import android.graphics.Matrix;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import banjaluka.vodic.R;


import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class ImageGalleryActivity extends BaseActivity {

	private Gallery gallery;
  
	private DisplayImageOptions options;
   
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.ac_image_gallery);
		
		Bundle bundle = getIntent().getExtras();
		String[] imageUrls = bundle.getStringArray(Extra.IMAGES);
		int galleryPosition = bundle.getInt(Extra.IMAGE_POSITION, 0);
		
		Matrix matrix = new Matrix();
		matrix.postSkew(-0.2f, -0.2f);
		
		options = new DisplayImageOptions.Builder()
			.showImageForEmptyUri(R.drawable.image_for_empty_url)
			.showStubImage(R.drawable.stub_image)
			.cacheInMemory()
			.cacheOnDisc()
			.transform(matrix)
			.build();

		gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImagePagerAdapter(imageUrls));
		gallery.setSelection(galleryPosition);

		
	}

	@Override
	protected void onStop() {
		imageLoader.stop();
		super.onStop();
	}

	private class ImagePagerAdapter extends BaseAdapter {

		private String[] images;
		private LayoutInflater inflater;

		ImagePagerAdapter(String[] images) {
			this.images = images;
			inflater = getLayoutInflater();
		}

		public int getCount() {
			return images.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = (ImageView) convertView;
			if (imageView == null) {
				imageView = (ImageView) inflater.inflate(R.layout.item_gallery_image, parent, false);
			}
			imageLoader.displayImage(images[position], imageView, options);
			return imageView;
		}
	}
}