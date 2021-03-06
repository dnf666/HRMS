package com.mis.hrm.project.dao;

import com.mis.hrm.project.po.Project;
import com.mis.hrm.util.BaseMapper;
import com.mis.hrm.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper extends BaseMapper<Project> {
    int getProjectCount(Project project);

    int deleteByProjectIds(@Param("numList")List<Integer> numList, @Param("companyId") String companyId);
}
