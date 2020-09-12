package my.awesome.Garaz;

import android.content.Context;
import android.content.SharedPreferences;

public class Sharedpref {
    public static final String SHARED_PREF_NAME="my_shared_preff";
    private static  Sharedpref minstance;
    private Context mctx;

    public Sharedpref(Context mctx) {
        this.mctx = mctx;
    }
    public static synchronized Sharedpref getInstance(Context mctx){
        if (minstance==null){
            minstance=new Sharedpref(mctx);
        }
        return minstance;
    }
    public void saveitem(custom24model item){
        SharedPreferences sharedPreferences=mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("id",item.getImage());
        editor.putString("sub",item.getText());
        editor.apply();
    }
   public custom24model getUser(){
        SharedPreferences sharedPreferences=mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        custom24model item=new custom24model(sharedPreferences.getInt("id",-1),sharedPreferences.getString("sub",null) );
        return item;
   }
    public static void deleteUser(Context mctx){
        SharedPreferences sharedPreferences=mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
