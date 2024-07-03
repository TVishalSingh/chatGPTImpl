package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ViewHolder> {

    private List<ChoiceEntity> responseList;

    public ResponseAdapter(List<ChoiceEntity> responseList) {
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_response, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChoiceEntity choice = responseList.get(position);
        if (choice.isUserInput()) {
            holder.textViewRequest.setText("You: " + choice.getContent());
            holder.textViewRequest.setVisibility(View.VISIBLE);
            holder.textViewResponse.setVisibility(View.GONE);
        } else {
            holder.textViewResponse.setText("LUI: " + choice.getContent());
            holder.textViewResponse.setVisibility(View.VISIBLE);
            holder.textViewRequest.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewRequest;
        public TextView textViewResponse;

        public ViewHolder(View view) {
            super(view);
            textViewRequest = view.findViewById(R.id.textViewRequest);
            textViewResponse = view.findViewById(R.id.textViewResponse);
        }
    }
}*/
/*
public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ViewHolder> {

    private List<ChoiceEntity> responseList;

    public ResponseAdapter(List<ChoiceEntity> responseList) {
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_response, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChoiceEntity choice = responseList.get(position);
        holder.textView.setText(choice.getContent());
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }
}
*/


public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.MessageViewHolder> {

    private List<ChoiceEntity> responseList;

    public ResponseAdapter(List<ChoiceEntity> responseList) {
        this.responseList = responseList;
    }

    @Override
    public int getItemViewType(int position) {
        return responseList.get(position).isUserInput() ? 0 : 1;

    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_response, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        ChoiceEntity choiceEntity = responseList.get(position);
        holder.bind(choiceEntity, getItemViewType(position));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        void bind(ChoiceEntity choiceEntity, int viewType) {
            if (viewType == 0) {
                textView.setText("You: " + choiceEntity.getContent());
                textView.setBackgroundResource(R.color.user_input_background);
            } else {
                textView.setText("LUI: " + choiceEntity.getContent());
                textView.setBackgroundResource(R.color.response_background);
            }
        }
    }
}
