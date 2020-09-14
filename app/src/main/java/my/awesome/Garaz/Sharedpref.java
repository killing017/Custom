package my.awesome.Garaz;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Sharedpref {

    public static final String SHARED_PREF_NAME="my_shared_preff";
    private static  Sharedpref minstance;
    private Context mctx;

int counter;



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
       // counter=sharedPreferences.getInt("count",0);
        int i=0;
        editor.putInt("id"+i,item.getImage());
        editor.putString("sub"+i,item.getText());
      //  editor.putInt("pos",position);
        editor.apply();
        editor.commit();

        i++;
    }
   public custom24model getUser(){
        SharedPreferences sharedPreferences=mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        int i=0;
        custom24model item=new custom24model(sharedPreferences.getInt("id"+i,-1),sharedPreferences.getString("sub"+i,null) );
        i++;
        return item;
   }

    public static void deleteUser(Context mctx){
        SharedPreferences sharedPreferences=mctx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }
}
