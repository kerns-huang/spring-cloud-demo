package com.content.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by kerns on 2017/4/12.
 * 新闻类内容
 */
@Document(indexName = "customer", type = "external", shards = 1, replicas = 0, refreshInterval = "-1")
public class News {
    @Id
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
