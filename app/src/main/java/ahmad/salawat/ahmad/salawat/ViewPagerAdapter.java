package ahmad.salawat.ahmad.salawat;

import android.app.Activity;
import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

//import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by ahmed on 10/11/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    LinearLayout linearLayout ;
    RelativeLayout relativeLayout;

    private Integer [] images = {R.drawable.a61,R.drawable.a60,R.drawable.a59,R.drawable.a58,R.drawable.a57,R.drawable.a56,R.drawable.a55,R.drawable.a54,R.drawable.a53,R.drawable.a52,R.drawable.a51,R.drawable.a50,R.drawable.a49,R.drawable.a48,R.drawable.a47,R.drawable.a46,R.drawable.a45,R.drawable.a44,R.drawable.a43,R.drawable.a42,R.drawable.a41,R.drawable.a40,R.drawable.a39,R.drawable.a38,R.drawable.a37,R.drawable.a36,R.drawable.a35,R.drawable.a34,R.drawable.a33,R.drawable.a32,R.drawable.a31,R.drawable.a30,R.drawable.a29,R.drawable.a28,R.drawable.a27,R.drawable.a26,R.drawable.a25,R.drawable.a24,R.drawable.a23,R.drawable.a22,R.drawable.a21,R.drawable.a20,R.drawable.a19,R.drawable.a18,R.drawable.a17,R.drawable.a16,R.drawable.a15,R.drawable.a14,R.drawable.a13,R.drawable.a12,R.drawable.a11,R.drawable.a10,R.drawable.a9,R.drawable.a8,R.drawable.a7,R.drawable.a6,R.drawable.a5,R.drawable.a4,R.drawable.a3,R.drawable.a2,R.drawable.a1,R.drawable.a0};
    public  ViewPagerAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
       // PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(imageView);
       // photoViewAttacher.update();

        imageView.setImageResource(images[position]);
        ViewPager pager = (ViewPager) container;
        pager.addView(view, 0);

        linearLayout = (LinearLayout) ((Activity)context).findViewById(R.id.linerlayout);
        relativeLayout = (RelativeLayout)((Activity)context).findViewById(R.id.brightness);





        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (relativeLayout.getVisibility() == View.VISIBLE) {
                    relativeLayout.setVisibility(View.GONE);
                 /*   WindowManager.LayoutParams layoutParams = ((Activity)context).getWindow().getAttributes();
                    layoutParams.screenBrightness = p.getIntPreference();
                    ((Activity)context).getWindow().setAttributes(layoutParams);*/

                } else {
                    if (linearLayout.getVisibility() == View.VISIBLE) {
                        linearLayout.setVisibility(View.GONE);

                    } else {
                        linearLayout.setVisibility(View.VISIBLE);
                    }


                }

            }
        });


        return  view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager pager = (ViewPager) container;
        View view = (View) object;
        pager.removeView(view);
    }
}
