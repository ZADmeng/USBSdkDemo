package com.zmt.demo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hoho.android.usbserial.common.DataItem;
import com.hoho.android.usbserial.common.DeviceUtil;
import com.hoho.android.usbserial.common.ReceivedList;
import com.hoho.android.usbserial.common.ZMTDataReceived;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity implements ZMTDataReceived {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReceivedList.addDataReceived(this);
        DeviceUtil.getDeviceMac();//获取设备mac。
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
