package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

import android.support.v7.app.AppCompatActivity;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private  List<Message> data;
   static class MessageViewHolder extends RecyclerView.ViewHolder {
       View messageView;
       CircleImageView userImage;      //头像
       ImageView officeImage;
       TextView nameText; //姓名
       TextView contentText; //消息内容
       TextView timeText;          //时间

       public MessageViewHolder(@NonNull View itemView) {
           super(itemView);
           messageView = itemView;
           //用户头像
           userImage = (CircleImageView)itemView.findViewById(R.id.iv_avatar);
           nameText = (TextView) itemView.findViewById(R.id.tv_title);
           contentText = (TextView) itemView.findViewById(R.id.tv_description);
           timeText = (TextView) itemView.findViewById(R.id.tv_time);
           officeImage = (ImageView)itemView.findViewById(R.id.robot_notice);
       }
   }
    public MessageAdapter( List<Message> messages) {
        data = messages;
    }
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        final MessageViewHolder holder = new MessageViewHolder(view);

        holder.messageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TextView contentText =  (TextView) v.findViewById(R.id.tv_description);
                String content = (String) contentText.getText();
                Intent intent = new Intent(v.getContext(),ChartRoom.class);//使用v.getContext()获取上下文环境
                intent.putExtra("key",position);
                intent.putExtra("content",content);
                v.getContext().startActivity(intent);  //这里也要用v.getContext()
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message m = data.get(position);
        String name = m.getTitle();
        holder.nameText.setText(name);
        String content = m.getDescription();
        holder.contentText.setText(content);
        String time = m.getTime();
        holder.timeText.setText(time);
        String logo = m.getIcon();
        if(logo.equals("TYPE_ROBOT")){

            holder.userImage.setImageResource(R.drawable.session_robot);
        }
        if(logo.equals("TYPE_STRANGER")){

            holder.userImage.setImageResource(R.drawable.session_stranger);
        }
        if(logo.equals("TYPE_SYSTEM")){

            holder.userImage.setImageResource(R.drawable.session_system_notice);
        }
        if(logo.equals("TYPE_GAME")){

            holder.userImage.setImageResource(R.drawable.icon_micro_game_comment);
        }
        if(logo.equals("TYPE_USER")){

            holder.userImage.setImageResource(R.drawable.icon_girl);
        }

        boolean isOffice = m.isOfficial();
        if(isOffice) {
            holder.officeImage.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
