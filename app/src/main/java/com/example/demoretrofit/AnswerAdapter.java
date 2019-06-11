package com.example.demoretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demoretrofit.Data.Model.Result;

import java.util.List;
public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.Viewholder> {
    private List<Result>mresult;
    private Context context;
    private PostItemListener mPostItemListener;
    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textView;
        PostItemListener postItemListener;

        public Viewholder(@NonNull View itemView, PostItemListener mPostItemListener) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_name);
            this.postItemListener = mPostItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public AnswerAdapter(List<Result> mresult, Context context, PostItemListener mPostItemListener) {
        this.mresult = mresult;
        this.context = context;
        this.mPostItemListener = mPostItemListener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_recyclerviewhome, viewGroup, false);
        Viewholder viewholder = new Viewholder(view, this.mPostItemListener);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        Result result=mresult.get(i);
        TextView tv=viewholder.textView;
        tv.setText(result.getFirstName());
    }
    public void updateAnswers(List<Result> result) {
        mresult = result;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mresult.size();
    }
    public interface PostItemListener {
        void onPostClick(long id);
    }
}
