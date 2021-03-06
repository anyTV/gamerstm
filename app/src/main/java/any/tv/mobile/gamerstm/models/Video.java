package any.tv.mobile.gamerstm.models;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;

import any.tv.mobile.gamerstm.R;
import any.tv.mobile.gamerstm.activities.BaseActivity;
import any.tv.mobile.gamerstm.activities.YoutubePlayerActivity;
import any.tv.mobile.gamerstm.helpers.ActivityHelper;

/**
 * Created by adin234 on 28/09/2015.
 */
public class Video extends BaseModel {
    private String gamers_mobile_android_id;
    private String playlist_id;
    private String owner_id;
    private String video_id;
    private String image_source;
    private String video_title;
    private String owner;
    private String channel_id;
    private String description;
    private String engtitle;
    private int views;
    private int comments;
    private int likes;
    private String published_at;
    private boolean featured;

    /*SOME THINGS THAT SHOULDNT BE HERE*/
    private String avatar;
    private String user;
    private int viewCount;
    private int likeCount;
    private int commentCount;

    public Video() {}

    public String getGamers_mobile_android_id() {
        return gamers_mobile_android_id;
    }

    public void setGamers_mobile_android_id(String gamers_mobile_android_id) {
        this.gamers_mobile_android_id = gamers_mobile_android_id;
    }

    public String getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(String playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getVideo_id() {
        return video_id != null && !video_id.equals("") ? video_id : gamers_mobile_android_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getDescription() {
        return description;
    }

    public void setÐescription(String description) {
        this.description = description;
    }

    public String getEngtitle() {
        return engtitle;
    }

    public void setEngtitle(String engtitle) {
        this.engtitle = engtitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public View getView(final Context c, View convertView, ViewGroup parent) {
        View row = convertView;
        final Video self = this;

        if (row == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(c);
            row = vi.inflate(R.layout.home_category_item, null, false);
        }

        final ImageView thumbView = (ImageView) row.findViewById(R.id.videoThumb);

        Picasso.with(c).load(getImage_source()).into(thumbView);

        ((TextView) row.findViewById(R.id.titleText)).setText(this.getVideo_title());
        ((TextView) row.findViewById(R.id.ownerText)).setText(this.getOwner());
        ((TextView) row.findViewById(R.id.viewsText)).setText(this.getViews()+ " Views");
        ((TextView) row.findViewById(R.id.commentsText)).setText(this.getComments() + " Comments");

        row.findViewById(R.id.shareButton).setOnClickListener((BaseActivity) c);
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("video", self);
                ActivityHelper.startActivity(YoutubePlayerActivity.class, c, b);
            }
        });


        return row;
    }

    public String getUserImage() {
        return "http://cdn2.gamers.tm/user_avatars/"+getOwner_id()+".jpg";
    }
}
