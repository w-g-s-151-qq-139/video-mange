package com.zhiyou100.dao.mapper;

import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.SpeakerExample;
import com.zhiyou100.dao.warp.SearchSpeaker;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakerMapper {
    int countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);
    int count(@Param("speaker") SearchSpeaker speaker);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);
    List<Speaker> findall(@Param("speaker") SearchSpeaker speaker);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);
}