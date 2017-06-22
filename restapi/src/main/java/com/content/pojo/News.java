package com.content.pojo;

import java.io.Serializable;

/**
 * Created by huangchunbo on 2017/5/8.
 */
public class News  implements Serializable {

    private Long id;
    private String title;//标题
    private String content;//内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }
}
