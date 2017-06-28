package com.example.rijunath.viewholder_sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    int img[] = {R.mipmap.images, R.mipmap.yahoo};
    String name[] = {"facebook", "yahoo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new Myadp());
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Second.class);
                i.putExtra("pic", img[position]);
                startActivity(i);
            }
        });
    }

    public class Myadp extends BaseAdapter {
        private LayoutInflater inf;

        public Myadp(Context context) {
            this.inf = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return img.length;//20
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder h = new Holder();
            if (convertView == null) {
                convertView = inf.inflate(R.layout.row, parent, false);
                h.im = (ImageView) convertView.findViewById(R.id.im);
                h.tv = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(h);
            } else {
                h = (Holder) convertView.getTag();
            }
            h.im.setBackgroundResource(img[position]);
            h.tv.setText(name[position]);
            return convertView;
        }
    }

    public class Holder {
        ImageView im;
        TextView tv;
    }
}
