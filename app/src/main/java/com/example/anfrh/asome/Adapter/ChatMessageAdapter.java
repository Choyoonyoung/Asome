package com.example.anfrh.asome.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.anfrh.asome.Model.Chat;
import com.example.anfrh.asome.R;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.anfrh.asome.Constant.ACTION_IMG;
import static com.example.anfrh.asome.Constant.ACTION_TEXT;
import static com.example.anfrh.asome.Constant.TAG_IMG_MINE;
import static com.example.anfrh.asome.Constant.TAG_READ;


/**
 * [OUTLINE]
 * 채팅 액티비티의 메시지 리스트 어댑터와 뷰홀더
 */
public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageViewHolder> {

    //오른쪽은 내 메시지, 왼쪽은 상대 메시지
    private static final int RIGHT = 0, LEFT = 1;

    private ArrayList<Chat> chats;
    private ArrayList<Chat> messages_search_result;

    public ChatMessageAdapter(ArrayList<Chat> chats) {
        this.chats = chats;
        this.messages_search_result = new ArrayList<Chat>();
        this.messages_search_result.addAll(chats);
    }

    @Override
    public int getItemViewType(int position) {

        //오른쪽은 내 메시지, 왼쪽은 상대 메시지
        if (chats.get(position).getIs_me())
            return RIGHT;
        else
            return LEFT;

    }

    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        switch (viewType) {

            //내 메시지일 경우 뷰는 item_message_right
            case RIGHT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_right, parent, false);
                break;

            //상대 메시지일 경우 뷰는 item_message_left
            case LEFT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_left, parent, false);
                break;
        }

        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.bind(chat);
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        chats.clear();
        if (charText.length() == 0) {
            chats.addAll(messages_search_result);
        } else {
            for (Chat wp : messages_search_result) {
                if (wp.getMessage().toLowerCase(Locale.getDefault()).contains(charText)) {
                    chats.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }


}


class ChatMessageViewHolder extends RecyclerView.ViewHolder {


    //cf) 메시지 종류는 3가지 {텍스트, 이미지, 맵} : 종류를 명시하지 않고 메시지라고 칭한 것은 세 타입 모두

    TextView tv_user_real_name;//한글로 메시지를 보낸 사람의 이름을 쓰는 텍스트뷰
    TextView txtMessage;//텍스트 메시지 내용을 보여주는 텍스트뷰
    ImageView txtMessage_img;//이미지 메시지의 이미지를 보여주는 이미지뷰
    TextView txtTime;//텍스트 메시지를 보낸 시간을 보여주는 텍스트뷰
    TextView txtCheck;//상대방이 메시지를 읽었는지 보여주는 텍스트뷰
    TextView txtTime_img;//이미지 메시지를 보낸 시간을 보여주는 텍스트뷰
    LinearLayout container_txt;//텍스트 메시지의 레이아웃
    LinearLayout container_img;//이미지 메시지의 레이아웃
    TextView dateLine;//날짜 변경선을 보여주는 텍스트뷰
    Context context;

    public ChatMessageViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();

        txtCheck = (TextView) itemView.findViewById(R.id.read_check);
        txtMessage = (TextView) itemView.findViewById(R.id.tv_message);
        txtMessage_img = (ImageView) itemView.findViewById(R.id.message_img);
        txtTime_img = (TextView) itemView.findViewById(R.id.time_img);
        txtTime = (TextView) itemView.findViewById(R.id.timestamp);
        container_img = (LinearLayout) itemView.findViewById(R.id.message_img_set);
        container_txt = (LinearLayout) itemView.findViewById(R.id.msg_container);
        dateLine = (TextView) itemView.findViewById(R.id.dateLine);
        tv_user_real_name = (TextView) itemView.findViewById(R.id.tv_user_real_name);

    }


    /**
     * 들어오는 메시지의 종류마다 어떻게 화면에 출력할 지 정한다.
     * 1. 텍스트
     * 2. 이미지
     * 3. 내이미지
     * 4. 맵
     * 5. 날짜선
     */
    public void bind(final Chat chat) {

        //메시지를 보낸 사람이름을 세팅
        tv_user_real_name.setText(chat.getUser_no());

        //메시지의 읽음 처리
        //만약 읽음 처리가 필요없다면(날짜선) View.GONE 처리됨
        if (chat.getRead_check().equals(TAG_READ)) {
            txtCheck.setText("읽음");
        } else {
            txtCheck.setText("안읽음");
        }

        //케이스 마다 안쓰는 뷰 -> View.GONE
        //쓰는 뷰-->View.VISIBLE
        switch (chat.getAction()) {

            //텍스트 메시지 케이스
            //쓰는 뷰
            //안쓰는 뷰
            case ACTION_TEXT:
                container_img.setVisibility(View.GONE);
                container_txt.setVisibility(View.VISIBLE);
                txtCheck.setVisibility(View.VISIBLE);
                txtMessage.setVisibility(View.VISIBLE);
                txtTime.setVisibility(View.VISIBLE);
                txtMessage.setText(chat.getMessage());
                txtTime.setText(chat.getTimestamp());
                dateLine.setVisibility(View.GONE);
                break;

            /**
             * 이미지 케이스가 2개인 이유
             * */
            //상대가 나에게 이미지 보내는 케이스
            //쓰는 뷰
            //안쓰는 뷰
            case ACTION_IMG:
                final String imageUri = chat.getMessage();
                container_txt.setVisibility(View.GONE);
                container_img.setVisibility(View.VISIBLE);
                txtTime_img.setText(chat.getTimestamp());
                /*GlideUtil.setBitmapToView(imageUri, txtMessage_img);
                txtMessage_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, PhotoViewActivity.class).putExtra(IMAGE_DATA, imageUri));

                    }
                });
                */dateLine.setVisibility(View.GONE);
                break;

            //내가 상대에게 이미지 보내는 케이스
            //쓰는 뷰
            //안쓰는 뷰
            case TAG_IMG_MINE:
                final String imageUri_mine = chat.getMessage();
                container_txt.setVisibility(View.GONE);
                container_img.setVisibility(View.VISIBLE);
                txtTime_img.setText(chat.getTimestamp());
                txtMessage_img.setImageBitmap(chat.getMy_image_bitmap());

                //이미지 뷰 클릭시 이미지를 크게 볼수 있는 PhotoViewActivity.class로 넘어간다
               /* txtMessage_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, PhotoViewActivity.class).putExtra(IMAGE_DATA, imageUri_mine));
                    }
                });
               */ dateLine.setVisibility(View.GONE);
                break;

            //맵 메시지 케이스
            //쓰는 뷰
            //안쓰는 뷰
            /*case ACTION_MAP:
                txtMessage_img.setImageResource(R.drawable.ic_pin_drop_black_48dp);
                container_img.setVisibility(View.VISIBLE);
                container_txt.setVisibility(View.GONE);
                txtTime_img.setText(chat.getRoom_no());
                txtMessage_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), ViewMapActivity.class);
                        i.putExtra("lat", chat.getLatitude());
                        i.putExtra("lng", chat.getLongitude());
                        v.getContext().startActivity(i);
                    }
                });
                dateLine.setVisibility(View.GONE);

                break;

*/
            //날짜선 케이스
            //쓰는 뷰
            //안쓰는 뷰
            case "dateLine":
                container_img.setVisibility(View.GONE);
                container_txt.setVisibility(View.GONE);
                txtCheck.setVisibility(View.GONE);
                txtMessage.setVisibility(View.GONE);
                txtTime.setVisibility(View.GONE);
                dateLine.setVisibility(View.VISIBLE);
                dateLine.setText(chat.getMessage());
                break;

        }

    }
}
