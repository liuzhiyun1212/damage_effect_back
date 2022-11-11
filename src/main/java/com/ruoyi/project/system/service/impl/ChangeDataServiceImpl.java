package com.ruoyi.project.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.system.domain.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ChangeDataMapper;
import com.ruoyi.project.system.domain.ChangeData;
import com.ruoyi.project.system.service.IChangeDataService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class ChangeDataServiceImpl implements IChangeDataService
{
    @Autowired
    private ChangeDataMapper changeDataMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ChangeData selectChangeDataById(Long id)
    {
        return changeDataMapper.selectChangeDataById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param changeData 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ChangeData> selectChangeDataList(ChangeData changeData)
    {
        return changeDataMapper.selectChangeDataList(changeData);
    }

    /**
     * 获取树列表
     */
    @Override
    public List<TreeSelect>  selectChangeTreeList(ChangeData changeData)
    {
        List<ChangeData> depts = selectChangeDataList(changeData);
        return buildDeptTreeSelect(depts);
    }
    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<ChangeData> depts)
    {
        List<ChangeData> deptTrees = buildDeptTree(depts);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    @Override
    public List<ChangeData> buildDeptTree(List<ChangeData> depts)
    {
        List<ChangeData> returnList = new ArrayList<ChangeData>();
        List<Long> tempList = depts.stream().map(ChangeData::getId).collect(Collectors.toList());
        for (ChangeData dept : depts)
        {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId()))
            {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = depts;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<ChangeData> list, ChangeData t)
    {
        // 得到子节点列表
        List<ChangeData> childList = getChildList(list, t);
        t.setChildren(childList);
        for (ChangeData tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<ChangeData> list, ChangeData t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }

    /**
     * 得到子节点列表
     */
    private List<ChangeData> getChildList(List<ChangeData> list, ChangeData t)
    {
        List<ChangeData> tlist = new ArrayList<ChangeData>();
        Iterator<ChangeData> it = list.iterator();
        while (it.hasNext())
        {
            ChangeData n = (ChangeData) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 新增【请填写功能名称】
     *
     * @param changeData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertChangeData(ChangeData changeData)
    {
        return changeDataMapper.insertChangeData(changeData);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param changeData 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateChangeData(ChangeData changeData)
    {
        return changeDataMapper.updateChangeData(changeData);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteChangeDataByIds(Long[] ids)
    {
        return changeDataMapper.deleteChangeDataByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteChangeDataById(Long id)
    {
        return changeDataMapper.deleteChangeDataById(id);
    }
}
