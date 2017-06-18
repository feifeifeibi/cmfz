package com.baizhi.entity;

import java.util.Date;

public class Essay {

    private String id;

    private String title;

    private String flag;

    private Date pubdate;

    private String tid;

    private String link;

    private Guru guru;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", pubdate=" + pubdate +
                ", tid='" + tid + '\'' +
                ", link='" + link + '\'' +
                ", guru=" + guru +
                '}';
    }

    public Essay() {
        super();
    }

    public Essay(String id, String title, String flag, Date pubdate, String tid, String link, Guru guru) {
        this.id = id;
        this.title = title;
        this.flag = flag;
        this.pubdate = pubdate;
        this.tid = tid;
        this.link = link;
        this.guru = guru;
    }
}