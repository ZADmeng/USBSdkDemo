# USBSdkDemo
### 添加     maven { url "https://jitpack.io" }
### 以aar的形式引入项目
、、、
implementation(name:'usbSerialForAndroid-release', ext:'aar')
、、、
### 在你的Application 中启动服务
、、、
public class ZMTApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), PushDataServer.class);
        startService(intent);
    }
}
、、、
### 在任意activity implements ZMTDataReceived 
、、、
public class MainActivity extends AppCompatActivity implements ZMTDataReceived {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceivedList.addDataReceived(this);
    }

    @Override
    public void dataReceived(List<DataItem> list, long l) {
        for (int i = 0; i < list.size(); i++) {
            Log.e("收到的结果", "Mac:" + list.get(i).getMac() + "|||Sig:" + list.get(i).getSig() + "|||time:" + getDateToString(l));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ReceivedList.removeReceived(this);
    }

    /*时间戳转换成字符窜*/
    public String getDateToString(long time) {
        SimpleDateFormat sf = null;
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }
}
、、、
