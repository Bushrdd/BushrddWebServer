package com.bushrdd.bushrddwebserver.utils;

import io.agora.media.RtcTokenBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Bushrdd
 * @date : 2023/12/22
 **/
public class VoiceCallTokenManager {
    public static String appId = "3abc2ac50f33447f922bd736bc06293d";
    private static String appCertificate = "908d1d17827e4316822daef885935a8d";//app证书
    // private static String channelName = "zxd_channel";//房间名
    private static String userAccount = "zxd_token";//string用户名
    // private static int uid = 2082341273;//int用户名
    private static int expirationTimeInSeconds = 3600 * 24 * 7;//有效时间

    public static String[] createToken(String channelName) throws Exception {
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int) (System.currentTimeMillis() / 1000 + expirationTimeInSeconds);//过期时间为创建时间(时间戳)+有效时间

        String result = token.buildTokenWithUserAccount(appId, appCertificate, channelName, userAccount, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        System.out.println(result);

        // result = token.buildTokenWithUid(appId, appCertificate, channelName, uid, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        // System.out.println(result);

        return new String[]{result, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis() + expirationTimeInSeconds * 1000))};
    }
}
