package adapters;
import java.util.Random;

import com.sparks.feliz.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.os.Build;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PharmaListAdapter extends ArrayAdapter{
    private LayoutInflater inflater;
    private TextView Pharmacy;
    int color_var, doctor_var;
    Activity activity;
    String[] doctors = {"Raja", "Trisha", "Aishwarya", "Kareena", "Anushka", "Rajinikanth"};
    ImageView color;
    
    

    public PharmaListAdapter(Activity activity, String[] items){
       super(activity, R.layout.simplerow, items);
       this.activity = activity;
      // Pharmacy = (TextView) findViewById( R.id.textView2);
       inflater = activity.getWindow().getLayoutInflater();
      
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
      View myview = inflater.inflate(R.layout.simplerow, null);
      
      color = (ImageView) myview.findViewById(R.id.imageView1);
     TextView text = (TextView) myview.findViewById(R.id.textView5);
      
      color_var = new Random().nextInt()%3;
      if(color_var==0)
    	  color.setBackgroundColor(Color.parseColor("#259b24"));
      if(color_var==1)
    	  color.setBackgroundColor(Color.parseColor("#e51c23"));
      if(color_var==2)
    	  color.setBackgroundColor(Color.parseColor("#ffeb3b"));
      
      myview.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			showDialog(v);
			
		}
	});
    
      doctor_var = new Random().nextInt(6);
      
      text.setText("Doctor's name : " + doctors[doctor_var]);
      
      
      return myview;
    }
    
	public void showDialog(View v) {
		ContextThemeWrapper ctw = new ContextThemeWrapper(activity,
				android.R.style.Theme_Holo_Light_Dialog);
		final CharSequence[] items = {
				"1 *",
				"2 **",
				"3 ***",
				"4 ****",
				"5 *****"};
		AlertDialog.Builder builder = new AlertDialog.Builder(ctw);
		builder.setTitle("Give your rating!");
		builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				if(which <= 3)
					color.setBackgroundColor(Color.parseColor("#e51c23"));
				else
					color.setBackgroundColor(Color.parseColor("#259b24"));
				
			}
		});

		builder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(activity,
								"Thanks for the rating", Toast.LENGTH_LONG)
								.show();

					}
				});
		builder.show();

	}


}