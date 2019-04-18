package com.effective.dao.mapper.gen;

import com.effective.dao.po.Kv;
import com.effective.dao.po.KvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KvMapper {
    int countByExample(KvExample example);

    int deleteByExample(KvExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Kv record);

    int insertSelective(Kv record);

    List<Kv> selectByExampleWithBLOBs(KvExample example);

    List<Kv> selectByExample(KvExample example);

    Kv selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Kv record, @Param("example") KvExample example);

    int updateByExampleWithBLOBs(@Param("record") Kv record, @Param("example") KvExample example);

    int updateByExample(@Param("record") Kv record, @Param("example") KvExample example);

    int updateByPrimaryKeySelective(Kv record);

    int updateByPrimaryKeyWithBLOBs(Kv record);

    int updateByPrimaryKey(Kv record);

    Kv lockByPrimaryKey(Long id);

    List<Kv> lockByExample(KvExample example);
}