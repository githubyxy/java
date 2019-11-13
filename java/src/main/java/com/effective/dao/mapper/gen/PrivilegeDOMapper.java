package com.effective.dao.mapper.gen;

import com.effective.dao.po.PrivilegeDO;
import com.effective.dao.po.PrivilegeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeDOMapper {
    int countByExample(PrivilegeDOExample example);

    int deleteByExample(PrivilegeDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PrivilegeDO record);

    int insertSelective(PrivilegeDO record);

    List<PrivilegeDO> selectByExample(PrivilegeDOExample example);

    PrivilegeDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PrivilegeDO record, @Param("example") PrivilegeDOExample example);

    int updateByExample(@Param("record") PrivilegeDO record, @Param("example") PrivilegeDOExample example);

    int updateByPrimaryKeySelective(PrivilegeDO record);

    int updateByPrimaryKey(PrivilegeDO record);

    PrivilegeDO lockByPrimaryKey(Long id);

    List<PrivilegeDO> lockByExample(PrivilegeDOExample example);
}