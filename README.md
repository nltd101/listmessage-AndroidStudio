### Các tính năng từ các buổi trước
 - Cộng hai số.
 - Mở trình duyệt web bằng cách cung cấp URL.
 - Mở camera chụp hình và show hình ảnh lên màn hình.
### Dùng ListView biểu diễn tin nhắn
    - Có 4 dạng phần tử của listview: 
        - Tin nhắn đối phương bình thường.
        - Tin nhắn đối phương có avatar.
        - Tin nhắn bản thân bình thường.
        - Tin nhắn bản thân có avatar.
##### Cách làm:
Cách giải quyết chủ yếu trong class MessageArrayAdapter :


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
    
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (messageList.get(position).getSender().equals("me"))
            {
                if ((position+1==messageList.size())||(!messageList.get(position+1).getSender().equals("me")))
                {
                     View mymessage = layoutInflater.inflate(R.layout.layout_mymessage, null );
                    return(mymessage);
                }
                else
                {
                    View mymessagebasic = layoutInflater.inflate(R.layout.layout_mymessage_basic, null);
                    return(mymessagebasic);
                }
            }else
            {
                if ((position+1==messageList.size())||(messageList.get(position+1).getSender().equals("me")))
                {
                    View  yourmessage = layoutInflater.inflate(R.layout.layout_message, null);
                    return(yourmessage);
                }
                else
                {
                    View  yourmessagebasic = layoutInflater.inflate(R.layout.layout_message_basic, null);
                    return(yourmessagebasic);
                }
            }
        }
    }


