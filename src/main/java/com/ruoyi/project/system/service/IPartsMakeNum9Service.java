package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.PartsMakeNum9;

/**
 * 9：装备使用数据Service接口
 * 
 * @author ruoyi
 * @date 2022-11-18
 */
public interface IPartsMakeNum9Service 
{
    /**
     * 查询9：装备使用数据
     * 
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    public PartsMakeNum9 selectPartsMakeNum9ById(Long id);

    /**
     * 查询9：装备使用数据列表
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 9：装备使用数据集合
     */
    public List<PartsMakeNum9> selectPartsMakeNum9List(PartsMakeNum9 partsMakeNum9);

    /**
     * 新增9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    public int insertPartsMakeNum9(PartsMakeNum9 partsMakeNum9);

    /**
     * 修改9：装备使用数据
     * 
     * @param partsMakeNum9 9：装备使用数据
     * @return 结果
     */
    public int updatePartsMakeNum9(PartsMakeNum9 partsMakeNum9);

    /**
     * 批量删除9：装备使用数据
     * 
     * @param ids 需要删除的9：装备使用数据主键集合
     * @return 结果
     */
    public int deletePartsMakeNum9ByIds(Long[] ids);

    /**
     * 删除9：装备使用数据信息
     * 
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    public int deletePartsMakeNum9ById(Long id);
}
