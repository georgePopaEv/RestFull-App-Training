package com.RestFull.example.RestfullWebservices.user;

public class Post {
    private Integer postId;
    private String title;

    public Post() {
    }

    public Post(String title) {
        this.title = title;
    }

    public Post(Integer postId) {
        this.postId = postId;
    }

    public Post(Integer postId, String title) {
        this.postId = postId;
        this.title = title;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                '}';
    }
}
