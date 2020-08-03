package negi.ritikachaaras.java_quiz;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickedListener mListener;

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(view, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getMtext1());
        holder.relat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(position);
//        holder.relat.setBackgroundColor(Color.LTGRAY);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList) {
        mExampleList = exampleList;
    }


    public interface OnItemClickedListener {
        void onItemClick(int position);

    }

    void setItemOnClickListener(OnItemClickedListener listener) {
        mListener = listener;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageview;
        TextView mTextView1;
        RelativeLayout relat;

        public ExampleViewHolder(View itemView, final OnItemClickedListener listener) {
            super(itemView);
            relat = itemView.findViewById(R.id.relat);
            mImageview = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {

                        int positon = getAdapterPosition();
                        if (positon != RecyclerView.NO_POSITION) ;
                    }

                }
            });

        }
    }
}
