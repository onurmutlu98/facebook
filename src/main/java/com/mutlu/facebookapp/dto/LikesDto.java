package com.mutlu.facebookapp.dto;

public class LikesDto {
    int likesNumber;
    int dislikesNumber;
    String postComment;

    public int getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(int likesNumber) {
        this.likesNumber = likesNumber;
    }

    public int getDislikesNumber() {
        return dislikesNumber;
    }

    public void setDislikesNumber(int dislikesNumber) {
        this.dislikesNumber = dislikesNumber;
    }

    public String getPostComment() {
        return postComment;
    }

    public void setPostComment(String postComment) {
        this.postComment = postComment;
    }
}
