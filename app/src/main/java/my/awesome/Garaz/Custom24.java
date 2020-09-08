package my.awesome.Garaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

//import com.example.custom7.R;

public class Custom24 extends AppCompatActivity {
custom24Adapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom24);
        final ArrayList<custom24model> customflavor= new ArrayList<custom24model>();
        customflavor.add(new custom24model(R.drawable.hundaii,"service","subservice","price"));

        customAdapter = new custom24Adapter(customflavor,Custom24.this);
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        // Get a reference to the ListView, and attach the adapter to the listView.
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Custom24.this,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);
    }
}
