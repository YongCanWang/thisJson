package www.mapscloud.cn.thisjson;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangyongcan on 2017/10/29.
 */

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class PathUtils {
    private String TAG = this.getClass().getSimpleName();



        public  static String getPrimaryStoragePath(Context mContext) {
        try {
            StorageManager sm = (StorageManager) mContext.getSystemService(mContext.STORAGE_SERVICE);
            Method getVolumePathsMethod = StorageManager.class.getMethod("getVolumePaths", null);
            String[] paths = (String[]) getVolumePathsMethod.invoke(sm, null);
            // first element in paths[] is primary storage path
            return paths[0];
        } catch (Exception e) {
            Log.e("PathUtils", "getPrimaryStoragePath() failed", e);
        }
        return null;
    }

    /**
     * 获取设备外卡路径
     * @return
     */

    public static String getSecondaryStoragePath(Context mContext) {
        try {
            StorageManager sm = (StorageManager) mContext.getSystemService(mContext.STORAGE_SERVICE);
            Method getVolumePathsMethod = StorageManager.class.getMethod("getVolumePaths", null);
            String[] paths = (String[]) getVolumePathsMethod.invoke(sm, null);
            // second element in paths[] is secondary storage path
            return paths[1];
        } catch (Exception e) {
            Log.e("PathUtils", "getSecondaryStoragePath() failed", e);
        }
        return null;
    }


    public static String getStorageState(Context mContext, String path) {
        try {
            StorageManager sm = (StorageManager) mContext.getSystemService(mContext.STORAGE_SERVICE);
            Method getVolumeStateMethod = StorageManager.class.getMethod("getVolumeState", new Class[] {String.class});
            String state = (String) getVolumeStateMethod.invoke(sm, path);
            return state;
        } catch (Exception e) {
            Log.e("PathUtils", "getStorageState() failed", e);
        }
        return null;
    }



    /**
     * android 6.0 获取内置外置sd卡路径
     * @param context
     * @return  如果挂载多个SD卡，则会返回多个SD卡路径
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static String[] getExtSDCardPath(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService(Context
                .STORAGE_SERVICE);
        try {
            Class<?>[] paramClasses = {};
            Method getVolumePathsMethod = StorageManager.class.getMethod("getVolumePaths", paramClasses);
            getVolumePathsMethod.setAccessible(true);
            Object[] params = {};
            Object invoke = getVolumePathsMethod.invoke(storageManager, params);
            return (String[])invoke;
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 1.获取外置sd卡路径 ，没有挂载sd卡则返回内置卡路径
     * @param context
     * @return
     */
    public static String getSdCardRootPath(Context context){
        String[] extSDCardPath = getExtSDCardPath(context);
        for (int i = 0; i < extSDCardPath.length; i++) {
            String sdCardPath = extSDCardPath[i];
            if(!sdCardPath.equals(getinnerPath())){
                File f = new File(sdCardPath);
                if(f.exists() && f.isDirectory() && f.list()!=null &&f.list().length > 0
                        && f.length() > 0){
                    return sdCardPath;
                }
            }
        }
        return getinnerPath();
    }


    /**
     *  获取设备内卡路径
     * @return
     */
    public static String getinnerPath() {

        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }


}
