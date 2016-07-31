package services;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import serverConnector.*;
/**
 * Created by tiankk on 2015/10/14.
 */
public class ClientThread extends Thread {

    private Handler handler;
    private Message returnMsg;

    public Handler rcvHandler;

    public void setHandlerOfService(Handler handler1) {
        handler = handler1;
    }

    public void run() {
        while (true) {
            Looper.prepare();

            rcvHandler = new Handler() {
                public void handleMessage(Message msg1) {
                    returnMsg = new Message();
                    switch (msg1.what) {
                        case 0x1:   // 0x1 for register
                            returnMsg.what = 0x2;   // 0x2 for the return message of register;
                            DataOperationPost reg = new DataOperationPost();
                            reg.setUrl(reg.getBaseUrl() + "/user/register");
                            reg.setJson(msg1.obj.toString());
                            returnMsg.obj = reg.Do();
                            break;
                        case 0x3:   // 0x1 for register
                            returnMsg.what = 0x4;   // 0x2 for the return message of register;
                            DataOperationPost login = new DataOperationPost();
                            login.setUrl(login.getBaseUrl() + "/user/login");
                            login.setJson(msg1.obj.toString());
                            returnMsg.obj = login.Do();
                            break;
                    }
                    handler.sendMessage(returnMsg);
                }
            };
            Looper.loop();
        }
    }
}
