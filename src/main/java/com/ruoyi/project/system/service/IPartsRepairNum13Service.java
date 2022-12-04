package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.PartsRepairNum13;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-12-02
 */
public interface IPartsRepairNum13Service 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PartsRepairNum13 selectPartsRepairNum13ById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PartsRepairNum13> selectPartsRepairNum13List(PartsRepairNum13 partsRepairNum13);

    /**
     * 新增【请填写功能名称】
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 结果
     */
    public int insertPartsRepairNum13(PartsRepairNum13 partsRepairNum13);

    /**
     * 修改【请填写功能名称】
     * 
     * @param partsRepairNum13 【请填写功能名称】
     * @return 结果
     */
    public int updatePartsRepairNum13(PartsRepairNum13 partsRepairNum13);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePartsRepairNum13ByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePartsRepairNum13ById(Long id);
}
