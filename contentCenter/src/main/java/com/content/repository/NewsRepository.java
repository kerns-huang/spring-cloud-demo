package com.content.repository;

import com.content.pojo.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kerns on 2017/4/12.
 */
@Repository
public interface NewsRepository extends ElasticsearchRepository<News, String> {
}
