package com.zhiyou100.dao.mapper;

import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.model.VideoExample;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.SearchVideo;
import com.zhiyou100.dao.warp.VideoWarp;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);
    List<VideoWarp> show();
    int count(@Param("searchvideo") SearchVideo searchvideo);
    List<VideoWarp> findterm(@Param("searchvideo") SearchVideo searchvideo);
    Video selectByPrimaryKey(Integer id);
    List<CourseWarp> avgcourse();

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	void batch(@Param("id") String id);
}