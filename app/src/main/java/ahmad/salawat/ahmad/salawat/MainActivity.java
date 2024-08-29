package ahmad.salawat.ahmad.salawat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.PowerManager;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;


import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Shard implements View.OnClickListener {
    protected PowerManager.WakeLock wakeLock;
    Button button1;
    Button button2;
    static Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button buttonprivecy;
    LinearLayout linearLayout , container ;
    RelativeLayout linearLayout1  ;
    TextView exit;

    FloatingActionButton Switcher;
    boolean Dark = false;

    RelativeLayout relativeLayout;
    int s;
    int y;
    int z;
    private int pg = 0, startPage, current = 0, state = 0, savedPage = 0;
    private Database myDB;
    public int save = 0;

    private ViewFlipper flipper;
    private ViewPager slider;
    private ViewPager colorpage;
    private Bundle bundle;
    private ViewPagerAdapter pagerAdapter;
    private ColorAdabter colorAdabter;
    private Integer[] images = {R.drawable.a0, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20, R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a27, R.drawable.a28, R.drawable.a29, R.drawable.a30, R.drawable.a31, R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35, R.drawable.a36, R.drawable.a37, R.drawable.a38, R.drawable.a39, R.drawable.a40, R.drawable.a41, R.drawable.a42, R.drawable.a43, R.drawable.a44, R.drawable.a45, R.drawable.a46, R.drawable.a47, R.drawable.a48, R.drawable.a49, R.drawable.a50, R.drawable.a51, R.drawable.a52, R.drawable.a53, R.drawable.a54, R.drawable.a55, R.drawable.a56, R.drawable.a57, R.drawable.a58, R.drawable.a59, R.drawable.a60, R.drawable.a61};
    private ListView list;
    private ImageAdapter imageAdapter;
    private int status = 0;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity";
    private int tempFirstVisibleItem = -1;
    @SuppressLint("InvalidWakeLockTag")
    ConsentForm form;
    private int sp;
    private int p = 61;
    SeekBar brightness_seekBar;



    int[] color = {R.color.color1,R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7,R.color.color8,R.color.color9,R.color.color10,R.color.color11,R.color.color12,R.color.color13,R.color.color14,R.color.color15,R.color.color16,R.color.color17,R.color.color18,R.color.color19,R.color.color20,R.color.color21,R.color.color22,R.color.color23,R.color.color24,R.color.color25,R.color.color26,R.color.color27};
    int colornum;


    @SuppressLint({"InvalidWakeLockTag", "MissingPermission"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(
                        RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);
        AdRequest adRequest = new AdRequest.Builder().build();


        getWindow().addFlags(128);

        setContentView(R.layout.activity_main);


        final PowerManager powerManager=(PowerManager)getSystemService(Context.POWER_SERVICE);
        this.wakeLock=powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK,TAG);
        this.wakeLock.acquire();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mInterstitialAd.load(this,getString(R.string.admob_mInterstitialAd), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
        /*mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                mInterstitialAd=null;
                Log.d(TAG, "Ad dismissed fullscreen content.");
               // mInterstitialAd = null;

            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                mInterstitialAd=null;
                Log.e(TAG, "Ad failed to show fullscreen content.");
              //  mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });
*/


        final AdView mAdView = (AdView) findViewById(R.id.adView);

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });
        ConsentInformation consentInformation =
                ConsentInformation.getInstance(MainActivity.this);
//// test
        // ConsentInformation.getInstance(this).addTestDevice("62577C087ADC5497524E2FAF2B0E67AE");
/////
        String[] publisherIds = {getString(R.string.admob_pub)};
        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                // User's consent status successfully updated.
                Log.d(TAG, "onConsentInfoUpdated");
                switch (consentStatus) {
                    case PERSONALIZED:
                        Log.d(TAG, "PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.PERSONALIZED);
                        break;
                    case NON_PERSONALIZED:
                        Log.d(TAG, "NON_PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.NON_PERSONALIZED);
                        break;
                    // User's consent status successfully updated.
                    case UNKNOWN:
                        Log.d(TAG, "UNKNOWN");
                        if
                        (ConsentInformation.getInstance(MainActivity.this).isRequestLocationInEeaOrUnknown
                                ()) {
                            URL privacyUrl = null;
                            try {
// TODO: Replace with your app's privacy policy URL.
                                privacyUrl = new URL("https://sites.google.com/view/ahmad-awad/home");
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
// Handle error.
                            }
                            form = new ConsentForm.Builder(MainActivity.this,
                                    privacyUrl)
                                    .withListener(new ConsentFormListener() {
                                        @Override
                                        public void onConsentFormLoaded() {
// Consent form loaded successfully.
                                            Log.d(TAG, "onConsentFormLoaded");
                                            showform();
                                        }

                                        @Override
                                        public void onConsentFormOpened() {
// Consent form was displayed.
                                            Log.d(TAG, "onConsentFormOpened");
                                        }

                                        @Override
                                        public void onConsentFormClosed(
                                                ConsentStatus consentStatus, Boolean
                                                userPrefersAdFree) {
// Consent form was closed.
                                            Log.d(TAG, "onConsentFormClosed");
                                        }

                                        @Override
                                        public void onConsentFormError(String
                                                                               errorDescription) {
// Consent form error.
                                            Log.d(TAG, "onConsentFormError");
                                            Log.d(TAG, errorDescription);
                                        }
                                    })
                                    .withPersonalizedAdsOption()
                                    .withNonPersonalizedAdsOption()
                                    .build();
                            form.load();
                        } else {
                            Log.d(TAG, "PERSONALIZED else");
                            ConsentInformation.getInstance(MainActivity.this)
                                    .setConsentStatus(ConsentStatus.PERSONALIZED);
                        }
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
                Log.d(TAG, "onFailedToUpdateConsentInfo");
                Log.d(TAG, errorDescription);
            }
        });
        Log.v("501", "start");



       /* bundle = getIntent().getExtras();
        SharedPreferences share = getSharedPreferences("savefil" , Context.MODE_PRIVATE);

        sp = share.getInt("currentPag", 0) ;
*/

        y = getSavedPuzzelCount();
        // z = getSavedPuzzelCount2();
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        exit=(TextView)findViewById(R.id.exit);
        buttonprivecy = (Button)findViewById(R.id.buttonprivecy);

        container=(LinearLayout)findViewById(R.id.container) ;
        colornum=getcolor();
        container.setBackgroundColor(getResources().getColor(color[colornum]));

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        exit.setOnClickListener(this);
        buttonprivecy.setOnClickListener(this);

       // img.setOnClickListener(this);

        Switcher = findViewById(R.id.switcher);
        Dark = getThemeStatePref();
        if(Dark) {
            // dark theme is on

          /*  searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
*/
        }
        else
        {
        /*    // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
*/
        }

        relativeLayout =(RelativeLayout)findViewById(R.id.brightness);
        linearLayout1 = (RelativeLayout) findViewById(R.id.menu_linearLayout_brightness);
        linearLayout1.setOnClickListener(this);


        linearLayout = (LinearLayout) findViewById(R.id.linerlayout);
        linearLayout.setVisibility(View.GONE);


        brightness_seekBar = (SeekBar) findViewById(R.id.brightness_seekBar);
        brightness_seekBar.setProgress(255-getIntPreference());
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = brightness_seekBar.getProgress();
        getWindow().setAttributes(layoutParams);
        brightness_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(255-progress);
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = progress;
                getWindow().setAttributes(layoutParams);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        flipper = (ViewFlipper) findViewById(R.id.content);
        slider = (ViewPager) findViewById(R.id.slider);
        colorpage=(ViewPager)findViewById(R.id.colorpage);
        list = (ListView) findViewById(R.id.imageList);

        myDB = new Database(this);


        if(0 == myDB.getAllData().getCount()){
            if(button3.getVisibility()==View.VISIBLE){
                button3.setVisibility(View.GONE);
            }
        }



        pag();
        list();
        cp();


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            list();
            status = 0;

        } else {
            flipper.setDisplayedChild(1);
            pag();
            status = 1;
        }


       // back();



    }

    private void list() {
        imageAdapter = new ImageAdapter(this, images);
        list = (ListView) findViewById(R.id.imageList);
        list.setAdapter(imageAdapter);
        //startPage = getCurrentPage() ;
            /*if(bundle != null){
                startPage = bundle.getInt("index");
                list.setSelection(startPage);
            }else if (startPage == 0){
                list.setSelection(sp);
            }else {
                list.setSelection(startPage);
            }
*/


        //z = getSavedPuzzelCount();
        z = getSavedPuzzelCount2();
        if (z == 0) {
            s = y;
        } else {
            s = z;
        }

        list.setSelection(s);

        list.setOnScrollListener(new ListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //setCurrentPage(firstVisibleItem );
                //savePuzzelCount(firstVisibleItem);
                savePuzzelCount2(firstVisibleItem);
                //slider.setCurrentItem(p - firstVisibleItem);
               /* if (tempFirstVisibleItem != firstVisibleItem){
                    savePuzzelCount(firstVisibleItem + 1);
                    tempFirstVisibleItem = firstVisibleItem ;

                }*/

            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }


        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                save = position;
                if (linearLayout.getVisibility() == View.VISIBLE) {
                    linearLayout.setVisibility(View.GONE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                }

            }

        });

    }

    private void cp(){
        colorAdabter=new ColorAdabter(this);
        colorpage=(ViewPager)findViewById(R.id.colorpage);
        colorpage.setAdapter(colorAdabter);
        colorpage.setCurrentItem(colornum);
        colorpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                //setCurrentPage(p - position);
                setcolor(position);
                container.setBackgroundColor(getResources().getColor(color[position]));
                //savePuzzelCount(p-position);
                //list.setSelection(p - position);


            }

            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

        });
    }

    private void pag() {
        pagerAdapter = new ViewPagerAdapter(this);
        slider = (ViewPager) findViewById(R.id.slider);
        slider.setAdapter(pagerAdapter);
        /*startPage = getCurrentPage() ;
            if(bundle != null){
                startPage = bundle.getInt("index");
                slider.setCurrentItem(p - startPage);
            }else if (startPage == 0){
                slider.setCurrentItem(p - sp);
            }else {
                slider.setCurrentItem(p - startPage);

            }*/
        // y = getSavedPuzzelCount();
        z = getSavedPuzzelCount2();
        if (z == 0) {
            s = y;
        } else {
            s = z;
        }

        slider.setCurrentItem(p - s);

        slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                //setCurrentPage(p - position);
                savePuzzelCount2(p - position);
                //savePuzzelCount(p-position);
                //list.setSelection(p - position);


            }

            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

        });


    }


    private void showform() {
        if (form != null) {
            Log.d(TAG, "show ok");
            form.show();
        }
    }





    @Override
    public void onDestroy(){
        this.wakeLock.release();
        super.onDestroy();
    }



    @Override
    protected void onStop() {
        if (status == 0) {
            save = imageAdapter.currentPos();
        } else {
            save = p - slider.getCurrentItem();
        }
        savePuzzelCount(save);
        super.onStop();

    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            list();
            status = 0;

        } else {

            flipper.setDisplayedChild(1);
            pag();
            status = 1;

        }
    }

    void displayInterstitialAd() {
      /*  mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }



    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(MainActivity.this, Index.class);
            startActivity(intent);
         //   displayInterstitialAd();
        } else if (v == button2) {
            if (status == 0) {
                save = imageAdapter.currentPos();
            } else {
                save = p - slider.getCurrentItem();
            }
            boolean isInserted = myDB.insertData(save);
            Log.v("save", save + "");

            if (isInserted == true) {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة", Toast.LENGTH_LONG).show();

                if(button3.getVisibility()==View.GONE){
                    button3.setVisibility(View.VISIBLE);
                }


            }else {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة سابقاً", Toast.LENGTH_LONG).show();
            }

            displayInterstitialAd();
        } else if (v == button3) {
            Intent intent1 = new Intent(MainActivity.this, Favorit.class);
            startActivity(intent1);
        //    displayInterstitialAd();
        } else if (v == button4) {
            Intent intent2 = new Intent(MainActivity.this, About.class);
            startActivity(intent2);
        //    displayInterstitialAd();

        }else if (v == button5) {
           // StartAppAd.showAd(this);
            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/developer?id=%D8%A3%D8%AD%D9%85%D8%AF%20%D8%B9%D9%88%D8%B6%20%D9%81%D9%83%D8%B1%D9%89"));

            startActivity(intent3);

        }else if (v == button6) {
            Intent intent4=new Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT,"السلام عليكم"+"\n"+"https://play.google.com/store/apps/details?id="+getPackageName());
            Intent.createChooser(intent4,"مشاركة التطبيق");
            startActivity(intent4);

         //   displayInterstitialAd();
        }else if (v == button7) {


            Intent intent5=new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse("market://details?id="+getPackageName()));
            startActivity(intent5);

            displayInterstitialAd();
        }else if (v==linearLayout1){
            linearLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            //Intent intent6 = new Intent(getCurrentActivity(),Brightnes.class);
            //  intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            //  startActivity(intent6);


        }else if (v==exit){
            relativeLayout.setVisibility(View.GONE);

         //   displayInterstitialAd();
        }else if (v==buttonprivecy){
            Intent intent=new Intent(MainActivity.this,PrivacyPolicy.class);
            startActivity(intent);
        }
       // displayInterstitialAd();
        //startAppAd.showAd(); // show the ad
    }




    public class ColorAdabter extends PagerAdapter {



        private Context context;
        private LayoutInflater inflater;
        private LinearLayout contain;

        public ColorAdabter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return color.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int po) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.colorrawe, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.colrrawe);
            imageView.setImageResource(color[po]);
            ViewPager pager = (ViewPager) container;
            pager.addView(view, 0);
/*
            contain=(LinearLayout)((Activity)context).findViewById(R.id.container);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
*/
            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            ViewPager pager = (ViewPager) container;
            View view = (View) object;
            pager.removeView(view);
        }

    }
}
