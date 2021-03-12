package com.example.smartbroadcast;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * 香港卫视：http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8
 * CCTV1高清：http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8
 * CCTV3高清：http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8
 * CCTV5高清：http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8
 * CCTV5+高清：http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8
 * CCTV6高清：http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8
 * 苹果提供的测试源（点播）：http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton vr_guansai;
    ImageButton saishizhushou;
    ImageButton ditudaoyin;
    ImageButton wode;
    ImageView netImg1;
    ImageView netImg2;
    ImageView netImg3;
    ImageView netImg4;
    TextView game11Text;
    TextView game12Text;
    TextView game21Text;
    TextView game22Text;
    VideoView videoView1;
    VideoView videoView2;
    VideoView videoView3;
    VideoView videoView4;
    LinearLayout mid_layout;
    public String videoPlay_url;



    String url1 = "http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8";
    String url2 = "http://ivi.bupt.edu.cn/hls/cctv2.m3u8";
    String url3 = "http://ivi.bupt.edu.cn/hls/cctv6.m3u8";
    String url4 = "http://ivi.bupt.edu.cn/hls/cctv13.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vr_guansai = (ImageButton) findViewById(R.id.vrguansai);
        vr_guansai.setOnClickListener(this);

        saishizhushou = (ImageButton) findViewById(R.id.saishizhushou);
        saishizhushou.setOnClickListener(this);

        ditudaoyin = (ImageButton) findViewById(R.id.ditudaoyin);
        ditudaoyin.setOnClickListener(this);

        wode = (ImageButton) findViewById(R.id.wode);
        wode.setOnClickListener(this);

        videoView1=(VideoView) findViewById(R.id.mVideoView1);
        videoView1.setOnClickListener(this);

        videoView2=(VideoView) findViewById(R.id.mVideoView2);
        videoView2.setOnClickListener(this);

        videoView3=(VideoView) findViewById(R.id.mVideoView3);
        videoView3.setOnClickListener(this);

        videoView4=(VideoView) findViewById(R.id.mVideoView4);
        videoView4.setOnClickListener(this);

        mid_layout=(LinearLayout)findViewById(R.id.mid_layout);
        mid_layout.setOnClickListener(this);



        initVideo(); //视频初始化

        try {
            initGame();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    //对直播进行初始化
    private void initVideo() {
        VideoView videoView1 = findViewById(R.id.mVideoView1);
        videoView1.setVideoPath(url1);
        videoView1.requestFocus();
        videoView1.start();

        VideoView videoView2 = findViewById(R.id.mVideoView2);
        videoView2.setVideoPath(url2);
        videoView2.requestFocus();
        videoView2.start();

        VideoView videoView3 = findViewById(R.id.mVideoView3);
        videoView3.setVideoPath(url3);
        videoView3.requestFocus();
        videoView3.start();

        VideoView videoView4 = findViewById(R.id.mVideoView4);
        videoView4.setVideoPath(url4);
        videoView4.requestFocus();
        videoView4.start();

        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f);
            }
        });

        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f);
            }
        });

        videoView3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f);
            }
        });

        videoView4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setVolume(0f, 0f);
            }
        });
    }

    private void initGame() throws Exception {
//        List<Game> result = getJSONLastVideos("http://xiaoliu1205.com/Spider/covid19Info/spiders/game_data.json");
//        System.out.println(result.get(0).getGame11());

//        List<Game>result=HttpURLConnection_GET();
        String result = getJson();
        String game11 = "", game12 = "", game21 = "", game22 = "";
        for (int i = 12; i < result.length(); i++) {
            while (result.charAt(i) != '\"') {
                game11 += result.charAt(i);
                i++;
            }
            i += 14;
            while (result.charAt(i) != '\"') {
                game12 += result.charAt(i);
                i++;
            }
            i += 14;
            while (result.charAt(i) != '\"') {
                game21 += result.charAt(i);
                i++;
            }
            i += 14;
            while (result.charAt(i) != '\"') {
                game22 += result.charAt(i);
                i++;
            }
            break;
        }
        System.out.println(game11 + game12 + game21 + game22);
        netImg1 = findViewById(R.id.imageView8);
        netImg2 = findViewById(R.id.imageView10);
        netImg3 = findViewById(R.id.imageView9);
        netImg4 = findViewById(R.id.imageView11);

        game11Text = findViewById(R.id.textView5);
        game12Text = findViewById(R.id.textView6);
        game21Text = findViewById(R.id.textView4);
        game22Text = findViewById(R.id.textView7);
        game11Text.setText(game11);
        game12Text.setText(game12);
        game21Text.setText(game21);
        game22Text.setText(game22);

        String url1 = "http://www.xiaoliu1205.com/img/saishizhongxin/" + game11 + ".png";
        String url2 = "http://www.xiaoliu1205.com/img/saishizhongxin/" + game12 + ".png";
        String url3 = "http://www.xiaoliu1205.com/img/saishizhongxin/" + game21 + ".png";
        String url4 = "http://www.xiaoliu1205.com/img/saishizhongxin/" + game22 + ".png";
        Glide.with(this).load(url1).into(netImg1);
        Glide.with(this).load(url2).into(netImg2);
        Glide.with(this).load(url3).into(netImg3);
        Glide.with(this).load(url4).into(netImg4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vrguansai:
                Intent intent = new Intent(MainActivity.this, VR.class);
                startActivity(intent);
                break;

            case R.id.wode:
                Intent intent2 = new Intent(MainActivity.this, denglu.class);
                startActivity(intent2);
                break;
            case R.id.mVideoView1:
                videoPlay_url=url1;
                Intent intent3 = new Intent(MainActivity.this, videoPlay.class);
                intent3.putExtra("url", url1);
                startActivity(intent3);
                break;
            case R.id.mVideoView2:
                videoPlay_url=url2;
                Intent intent4 = new Intent(MainActivity.this, videoPlay.class);
                intent4.putExtra("url", url2);
                startActivity(intent4);
                break;
            case R.id.mVideoView3:
                videoPlay_url=url3;
                Intent intent5 = new Intent(MainActivity.this, videoPlay.class);
                intent5.putExtra("url", url3);
                startActivity(intent5);
                break;
            case R.id.mVideoView4:
                videoPlay_url=url4;
                Intent intent6 = new Intent(MainActivity.this, videoPlay.class);
                intent6.putExtra("url", url4);
                startActivity(intent6);
                break;
            case R.id.mid_layout:
                Uri uri = Uri.parse("https://tiyu.baidu.com/match/%E6%AC%A7%E5%86%A0/tab/%E8%B5%9B%E7%A8%8B/date_time/2021-02-17/from/baidu_aladdin");
                Intent intent7 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent7);

                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initVideo();

        List images = new ArrayList();
        images.add("http://www.xiaoliu1205.com/img/1.jpg");
        images.add("http://www.xiaoliu1205.com/img/2.jpg");
        images.add("http://www.xiaoliu1205.com/img/3.jpg");

        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //增加点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
//                Intent intent = new Intent(MainActivity.this, VR.class);
//                startActivity(intent);
                if(position==0)
                {
                    Uri uri = Uri.parse("http://slide.sports.sina.com.cn/g_laliga/slide_2_730_259784.html#p=1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if(position==1)
                {
                    Uri uri = Uri.parse("http://slide.sports.sina.com.cn/k/slide_2_786_259683.html#p=1");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://mp.weixin.qq.com/s?__biz=MjM5MzY0NDI4OA==&mid=2650592872&idx=1&sn=8d0b96c4b0c26b76817a41f3106bb532&chksm=be9b9c0789ec1511a03a018f8ccbd6a480a8df9840770ef53de5d3a851c40f15548282bd3ddb&token=1728927665&lang=zh_CN#rd");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                //Toast.makeText(MainActivity.this, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static List<Game> getJSONLastVideos(String path) throws Exception {
        List<Game> Games = new ArrayList<Game>();
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        byte[] data = StreamTool.getBytes(inStream);
        String json = new String(data);
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject item = array.getJSONObject(i);

            String game11 = item.getString("game11");
            String game12 = item.getString("game12");
            String game21 = item.getString("game21");
            String game22 = item.getString("game22");

            Games.add(new Game(game11, game12, game21, game22));
        }
        return Games;
    }

    public String getJson() {
        final String[] text = {""};
        //在子线程中获取服务器的数据
        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    URL url = new URL("http", "xiaoliu1205.com", 80, "/Spider/covid19Info/spiders/game_data.json");
                    InputStream input = url.openStream();   // 打开输入流
                    Scanner scan = new Scanner(input);
                    scan.useDelimiter("\n");                // 设置分隔符
                    while (scan.hasNext()) {
                        text[0] += scan.next();
                    }
                    //System.out.println(text[0]);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(text[0]);
            }
        };

        //启动线程
        thread.start();
        while (text[0].length() == 0) {

        }

        System.out.println(text[0]);
        return text[0];
    }

}

