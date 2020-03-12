package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapi2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Model.Example;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {
    private List<Example> movies;

    public MyRecyclerView(List<Example> movies) {
        this.movies = movies;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,null);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String s = "https://image.tmdb.org/t/p/w185";
            Picasso.get().load(s+movies.get(position).getPosterPath()).into(holder.poster);
            holder.tittle.setText(movies.get(position).getTitle());
            holder.rating.setText("Rating: "+movies.get(position).getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tittle, rating;
        ImageView poster;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.movieTittle);
            rating = itemView.findViewById(R.id.movieRating);
            poster = itemView.findViewById(R.id.tagImage);
        }
    }
}
