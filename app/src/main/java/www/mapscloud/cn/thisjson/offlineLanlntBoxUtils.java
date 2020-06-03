package www.mapscloud.cn.thisjson;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wangyongcan on 2018/5/19.
 */

public class offlineLanlntBoxUtils {


    private static final String TAG = "offlineLanlntBoxUtils";
    public static final String JSON_FIELD_REGION_NAME = "FIELD_REGION_NAME";
    public static final String JSON_CHARSET = "UTF-8";

    public static Bundle putPathJson(Context mContext) {
        Bundle bundle = null;
        File file = new File(PathUtils.getinnerPath() + "/mapplus" + "/app" + "/file" + "/offlineLanlntBox.json");
        if (file.exists()) {

            StringBuffer stringBuffer = new StringBuffer();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = "";
                while ((readLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(readLine);
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException:" + e.toString());
                e.printStackTrace();
            }
            String jsonContext = stringBuffer.toString();
            Log.e(TAG, "jsonContext:" + jsonContext);
            Gson gson = new Gson();
            offlineLanlntBean offlineLanlntBean = gson.fromJson(jsonContext, offlineLanlntBean.class);



            String areaName = offlineLanlntBean.getAreaName();
            int maxZoom1 = offlineLanlntBean.getMaxZoom();
            int mixZoom1 = offlineLanlntBean.getMixZoom();
            double maxZoom2 = Double.parseDouble(maxZoom1 + "");
            double mixZoom2 = Double.parseDouble(mixZoom1 + "");
            double eastLongitude = offlineLanlntBean.getEastLongitude();
            double southLatitude = offlineLanlntBean.getSouthLatitude();
            double westLongitude = offlineLanlntBean.getWestLongitude();
            double northLatitude = offlineLanlntBean.getNorthLatitude();


            byte[] metadata;
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(JSON_FIELD_REGION_NAME, areaName); // regionName为配置文件中获取到的名称
                String json = jsonObject.toString();
                metadata = json.getBytes(JSON_CHARSET);
            } catch (Exception exception) {
                Log.e(TAG, "Failed to encode metadata: " + exception.getMessage());
                metadata = null;
            }


            Log.e(TAG, "areaName:" + areaName);
            Log.e(TAG, "maxZoom:" + maxZoom2);
            Log.e(TAG, "mixZoom:" + mixZoom2);
            Log.e(TAG, "eastLongitude:" + eastLongitude);
            Log.e(TAG, "southLatitude:" + southLatitude);
            Log.e(TAG, "westLongitude:" + westLongitude);
            Log.e(TAG, "northLatitude:" + northLatitude);


        } else {
            Toast.makeText(mContext, "缺少offlineLanlntBox.json文件", Toast.LENGTH_LONG).show();
            System.exit(0);
        }

        return bundle;

    }







}
