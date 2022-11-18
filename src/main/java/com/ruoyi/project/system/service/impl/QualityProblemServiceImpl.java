package com.ruoyi.project.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.mapper.QualityProblemMapper;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * quality_problemService业务层处理
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class QualityProblemServiceImpl implements IQualityProblemService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private QualityProblemMapper qualityProblemMapper;

    /**
     * 查询quality_problem
     *
     * @param id quality_problem主键
     * @return quality_problem
     */
    @Override
    public QualityProblem selectQualityProblemById(Long id)
    {
        return qualityProblemMapper.selectQualityProblemById(id);
    }

    /**
     * 查询quality_problem列表
     *
     * @param qualityProblem quality_problem
     * @return quality_problem
     */
    @Override
    public List<QualityProblem> selectQualityProblemList(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.selectQualityProblemList(qualityProblem);
    }

    /**
     * 新增quality_problem
     *
     * @param qualityProblem quality_problem
     * @return 结果
     */
    @Override
    public int insertQualityProblem(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.insertQualityProblem(qualityProblem);
    }

    /**
     * 修改quality_problem
     *
     * @param qualityProblem quality_problem
     * @return 结果
     */
    @Override
    public int updateQualityProblem(QualityProblem qualityProblem)
    {
        return qualityProblemMapper.updateQualityProblem(qualityProblem);
    }

    /**
     * 批量删除quality_problem
     *
     * @param ids 需要删除的quality_problem主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblemByIds(Long[] ids)
    {
        return qualityProblemMapper.deleteQualityProblemByIds(ids);
    }

    /**
     * 删除quality_problem信息
     *
     * @param id quality_problem主键
     * @return 结果
     */
    @Override
    public int deleteQualityProblemById(Long id)
    {
        return qualityProblemMapper.deleteQualityProblemById(id);
    }
    /**
     * 质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> qualityHappenSum(Sum sum) {
        return qualityProblemMapper.qualityHappenSum(sum);
    }
    /**
     * 年度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> yearHappenSum(Sum sum) {
        return qualityProblemMapper.yearHappenSum(sum);
    }
    /**
     * 质量问题涉及到的机型
     *
     * @param
     * @return 统计结果
     */
    @Override
    public List<Sum> sumByplaneType(Sum sum) {
        return qualityProblemMapper.sumByplaneType(sum);
    }

    @Override
    public String importData(List<QualityProblem> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<QualityProblem> existList = selectQualityProblemList(null);
        for (QualityProblem importData : dataManagementList)
        {
            try {

                /*boolean userFlag = false;
                for (QualityProblem entry : existList) {
                    if (entry.getResponsiblePerson().equals(importData.getResponsiblePerson())) {
                        userFlag = true;
                        break;
                    }
                }*/
                insertQualityProblem((importData));
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据 " + importData.getTitle() + " 导入成功");
                /*if (!userFlag) {
                    insertDataManagement(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + importData.getResponsiblePerson() + " 导入成功");
                } else if (isUpdateSupport) {
                    updateDataManagement(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + importData.getResponsiblePerson() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、数据 " + importData.getResponsiblePerson() + " 已存在");
                }*/
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + importData.getTitle() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * @Description 统计所有故障次数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public int selectAllCount(){
        return qualityProblemMapper.selectAllCount();
    }
    /**
     * @Description 统计不同故障件发生故障次数
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public List<FaultyPartsCount> selectCountByName(){
        return qualityProblemMapper.selectCountByName();
    }
    /**
     * @Description 统计故障件数量
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public int selectPartsCount(){
        return qualityProblemMapper.selectPartsCount();
    }

    @Override
    public List<GradeCount> selectByGradeFaultModel() {
        return qualityProblemMapper.selectByGradeFaultModel();
    }

    @Override
    public List<Sum> qualitySumByGrade() {
        return qualityProblemMapper.qualitySumByGrade();
    }

    @Override
    public List<Sum> productSumByGrade() {
        return qualityProblemMapper.productSumByGrade();
    }

    @Override
    public List<ProductModifyData> selectByGradeChanged() {
        return qualityProblemMapper.selectByGradeChanged();
    }

}
