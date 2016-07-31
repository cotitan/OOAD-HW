package services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by tiankk on 16-7-31.
 */
public class MyServiceConnection implements ServiceConnection {
    private serviceClient.MyBinder myBinder;
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myBinder = (serviceClient.MyBinder) iBinder;
        System.out.println("*******service connected******");
    }
    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        System.out.println("*****service disconnected*****");
    }

    public serviceClient.MyBinder getMyBinder() { return myBinder; }

}
