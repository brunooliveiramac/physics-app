package physics.com.physics.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.HashMap;
import java.util.Map;

import physics.com.physics.R;
import physics.com.physics.content.YouTubeContent;

/**
 * Created by bruno on 28/10/15.
 */
public class VideoListAdapter extends BaseAdapter implements YouTubeThumbnailView.OnInitializedListener {

    private Context mContext;
    private Map<View, YouTubeThumbnailLoader> mLoaders;

    public VideoListAdapter(final Context context) {
        this.mContext = context;
        this.mLoaders = new HashMap<>();
    }

    @Override
    public int getCount() {
        return YouTubeContent.ITEMS.size();
    }

    @Override
    public Object getItem(int position) {
        return YouTubeContent.ITEMS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentRow = convertView;
        VideoHolder holder;

        final YouTubeContent.YouTubeVideo item = YouTubeContent.ITEMS.get(position);

        if(currentRow == null) {
            //Create the row
            final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentRow = inflater.inflate(R.layout.row_layout, parent, false);

            holder = new VideoHolder();

            holder.title = (TextView) currentRow.findViewById(R.id.textView_title);
            holder.title.setText(item.title);

            //Initializing the thumbnail
            holder.thumb = (YouTubeThumbnailView) currentRow.findViewById(R.id.imageView_thumbnail);
            holder.thumb.setTag(item.id);
            holder.thumb.initialize(mContext.getString(R.string.DEVELOPER_KEY), this);

            currentRow.setTag(holder);

        } else {
            //Create it again
            holder = (VideoHolder) currentRow.getTag();
            final YouTubeThumbnailLoader loader = mLoaders.get(holder.thumb);

            //Setting title
            if(item != null) {
                holder.title.setText(item.title);

                if(loader == null) {
                    //loader is currently initializing
                    holder.thumb.setTag(item.id);
                } else {
                    loader.setVideo(item.id);
                }


            }
        }

        return currentRow;
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {
        mLoaders.put(view, loader);
        loader.setVideo((String) view.getTag());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult errorReason) {
        final String errorMessage = errorReason.toString();
        Toast.makeText(mContext, errorMessage, Toast.LENGTH_LONG).show();
    }

    static class VideoHolder {
        YouTubeThumbnailView thumb;
        TextView title;
    }
}
