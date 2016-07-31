package services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler;

/**
 * Created by tiankk on 10/13/15.
 */
public class serviceClient extends Service {

    private final MyBinder binder = new MyBinder();
    private ClientThread clientThread;

    public class MyBinder extends Binder {
        public MyBinder() {
            super();
        }
        public void setHandler(Handler handler1) {
            clientThread.setHandlerOfService(handler1);
        }
        public void sendMessage(Message msg1) {
            clientThread.rcvHandler.sendMessage(msg1);
        }
        public serviceClient getService() {
            return  serviceClient.this;
        }
    }

    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void onCreate() {
        super.onCreate();
        if (clientThread != null) {
            System.out.println("thread running");
            return;
        }
        synchronized (ClientThread.class) {
            clientThread = new ClientThread();
        }
        clientThread.start();
    }


    public void onDestroy() {
        super.onDestroy();
    }


}
