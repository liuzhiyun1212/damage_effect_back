package com.ruoyi.project.system.service;

import java.util.List;

import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.system.domain.ChangeData;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-11-10
 */
public interface IChangeDataService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ChangeData selectChangeDataById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param changeData 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ChangeData> selectChangeDataList(ChangeData changeData);

    /**
     * 新增【请填写功能名称】
     *
     * @param changeData 【请填写功能名称】
     * @return 结果
     */
    public int insertChangeData(ChangeData changeData);

    /**
     * 修改【请填写功能名称】
     *
     * @param changeData 【请填写功能名称】
     * @return 结果
     */
    public int updateChangeData(ChangeData changeData);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteChangeDataByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteChangeDataById(Long id);

    /**
     * 获取树列表
     */
    public List<TreeSelect>  selectChangeTreeList(ChangeData changeData);

    public List<TreeSelect> buildDeptTreeSelect(List<ChangeData> depts);

    public List<ChangeData> buildDeptTree(List<ChangeData> depts);
}
