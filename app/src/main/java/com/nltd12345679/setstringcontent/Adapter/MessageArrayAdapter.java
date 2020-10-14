package com.nltd12345679.setstringcontent.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nltd12345679.setstringcontent.Object.Message;
import com.nltd12345679.setstringcontent.R;

import java.util.List;


/**
 * Created by cemas on 13.05.2016.
 */
public class  MessageArrayAdapter extends ArrayAdapter<Message> {

    private Context context;
    private List<Message> messageList;


    public MessageArrayAdapter(Context context, List<Message> list) {
        super(context,0,list);
        this.context = context;
        this.messageList = list;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }


    public void add(Message message) {
        if(message != null) {
            this.messageList.add(message);
            this.notifyDataSetChanged();
        }
    }

    public class ViewHolder{
        TextView textViewMessage;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = giveMeMyViewPlease(context, messageList,position);
        if(messageList != null && row.findViewById(R.id.textViewMessage) != null) {
            TextView textViewMessage = (TextView) row.findViewById(R.id.textViewMessage);
            ImageView imageView = row.findViewById(R.id.img_avt);
            Message message = messageList.get(position);
            if (imageView!=null){
                imageView.setImageResource(message.getAvtSender());
            }

            if(textViewMessage != null) {
                textViewMessage.setText(message.getContent());
            }
        }
        return row;
    }

    private View giveMeMyViewPlease(Context context, List<Message> messageList, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) LayoutInflater.from(context);// context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (messageList.get(position).getSender().equals("me")) {
            if ((position + 1 == messageList.size()) || (!messageList.get(position + 1).getSender().equals("me"))) {
                View mymessage = layoutInflater.inflate(R.layout.layout_mymessage, null);
                return (mymessage);
            } else {
                View mymessagebasic = layoutInflater.inflate(R.layout.layout_mymessage_basic, null);
                return (mymessagebasic);
            }
        } else {
            if ((position + 1 == messageList.size()) || (messageList.get(position + 1).getSender().equals("me"))) {
                View yourmessage = layoutInflater.inflate(R.layout.layout_message, null);
                return (yourmessage);
            } else {
                View yourmessagebasic = layoutInflater.inflate(R.layout.layout_message_basic, null);
                return (yourmessagebasic);
            }
        }
    }
}
