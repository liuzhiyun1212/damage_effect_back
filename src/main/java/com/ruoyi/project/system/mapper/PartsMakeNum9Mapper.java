package com.ruoyi.project.system.mapper;

import java.util.List;

import com.ruoyi.project.system.domain.CountQuality;
import com.ruoyi.project.system.domain.PartsMakeNum9;
import com.ruoyi.project.system.domain.ProductModify;

/**
 * 9：装备使用数据Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-18
 */
public interface PartsMakeNum9Mapper
{
    /**
     * 查询9：装备使用数据
     *
     * @param id 9：装备使用数据主键
     * @return 9：装备使用数据
     */
    public PartsMakeNum9 selectPartsMakeNum9ById(Long id);

    /**
     * 故障件生产数量及对应质量问题数
     */
    public List<CountQuality> selectNumFaultQuality();

    /**
     * 故障件生产数量
     */

    public List<CountQuality> selectNumFault();

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
     * 删除9：装备使用数据
     *
     * @param id 9：装备使用数据主键
     * @return 结果
     */
    public int deletePartsMakeNum9ById(Long id);

    /**
     * 批量删除9：装备使用数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePartsMakeNum9ByIds(Long[] ids);
}
