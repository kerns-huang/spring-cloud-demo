package com.message.repository;

import com.message.pojo.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by kerns on 2017/4/12.
 */
public interface NewsRepository extends ElasticsearchRepository<News, String> {
}
