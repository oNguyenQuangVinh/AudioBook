package com.example.vinh.afinal.Model;

/**
 * Created by vinh on 15-Nov-16.
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vinh on 23-Sep-16.
 */
public class ItemContent implements Serializable{
    private String title, content;
    private String image;

    public ArrayList<Chapter> getListChapter() {
        return listChapter;
    }

    public void setListChapter(ArrayList<Chapter> listChapter) {
        this.listChapter = listChapter;
    }

    private  ArrayList<Chapter> listChapter;
    private boolean favorite = false;
    private boolean isSelected;

//    public ItemContent(String title, String content, String image, List<Chapter> list) {
//        this.title = title;
//        this.content = content;
//        this.image = image;
//        this.list = list;
//    }

    public ItemContent() {
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite1) {
        favorite = favorite1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Chapter implements Serializable{
        private String titleC;
        private String link;

        public String getTitleC() {
            return titleC;
        }

        public void setTitleC(String titleC) {
            this.titleC = titleC;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

    }

}


