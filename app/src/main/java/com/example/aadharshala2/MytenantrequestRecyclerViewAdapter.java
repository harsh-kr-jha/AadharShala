package com.example.aadharshala2;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aadharshala2.model.tenant;
import com.example.aadharshala2.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.aadharshala2.databinding.FragmentTenantBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MytenantrequestRecyclerViewAdapter extends RecyclerView.Adapter<MytenantrequestRecyclerViewAdapter.ViewHolder> {

    private final List<tenant> mValues;
    public TextView requestCode;
    public Button go;

    public MytenantrequestRecyclerViewAdapter(List<tenant> items ) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentTenantBinding.inflate(LayoutInflater.from(parent.getContext())));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        tenant item = mValues.get(position);

        TextView textView = holder.requestCode;
        textView.setText(item.getReqCode());
        Button go = holder.go;
        go.setText(item.getReqCode());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView requestCode;
        public Button go;

        public ViewHolder(FragmentTenantBinding binding) {
            super(binding.getRoot());

            requestCode = binding.reqCode;
            go = binding.gone;
            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}