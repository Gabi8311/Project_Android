package utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_project.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter {
    List<String> listTiltle;
    List<Integer>imageList;
    Context context;
    public MyAdapter(@NonNull Context context,List<String>listTiltle,List<Integer>imageList) {
        super(context, R.layout.activity_main8,listTiltle);

        this.listTiltle = listTiltle;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        textView.setText(listTiltle.get(position));
        imageView.setImageResource(imageList.get(position));

        return view;

    }
}
