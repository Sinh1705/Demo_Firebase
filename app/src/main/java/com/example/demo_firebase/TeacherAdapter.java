package com.example.demo_firebase;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherAdapter extends FirebaseRecyclerAdapter<Teacher,TeacherAdapter.ViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TeacherAdapter(@NonNull FirebaseRecyclerOptions<Teacher> options) {
        super(options);
    }

    @NonNull
    @Override
    public TeacherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Teacher model) {
        holder.tvCourse.setText(model.getCourse());
        holder.tvEmail.setText(model.getEmail());
        holder.tvName.setText(model.getName());

        Glide.with(holder.img.getContext())
                .load(model.getSurl())
                .placeholder(R.drawable.anh_1) // Hiển thị ảnh này trong khi đang tải
                .circleCrop()
                .error(R.drawable.anh_1) // Hiển thị ảnh này nếu có lỗi khi tải
//                .apply(new RequestOptions()
//                        .diskCacheStrategy(DiskCacheStrategy.NONE) // Tắt bộ nhớ đệm để không lưu vào bộ nhớ cache
//                        .skipMemoryCache(true))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView tvName ,tvEmail, tvCourse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvCourse = itemView.findViewById(R.id.tv_course);
            img = itemView.findViewById(R.id.img_data);
        }
    }
}
