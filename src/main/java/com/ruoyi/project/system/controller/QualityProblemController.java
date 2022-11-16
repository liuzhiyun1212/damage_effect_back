package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.Sum;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * quality_problemController
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system/dev")
public class QualityProblemController extends BaseController
{
    @Autowired
    private IQualityProblemService qualityProblemService;

    /**
     * 查询quality_problem列表
     */
    @PreAuthorize("@ss.hasPermi('system:dev:list')")
    @GetMapping("/list")
    public TableDataInfo list(QualityProblem qualityProblem)
    {
        startPage();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public TableDataInfo listAll(QualityProblem qualityProblem)
    {
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        return getDataTable(list);
    }


    /**
     * 导出quality_problem列表
     */
    @PreAuthorize("@ss.hasPermi('system:dev:export')")
    @Log(title = "quality_problem", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QualityProblem qualityProblem)
    {
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(qualityProblem);
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        util.exportExcel(response, list, "quality_problem数据");
    }

    /**
     * 获取quality_problem详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dev:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(qualityProblemService.selectQualityProblemById(id));
    }

    /**
     * 新增quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:add')")
    @Log(title = "quality_problem", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QualityProblem qualityProblem)
    {
        return toAjax(qualityProblemService.insertQualityProblem(qualityProblem));
    }

    /**
     * 修改quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:edit')")
    @Log(title = "quality_problem", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QualityProblem qualityProblem)
    {
        return toAjax(qualityProblemService.updateQualityProblem(qualityProblem));
    }

    /**
     * 删除quality_problem
     */
    @PreAuthorize("@ss.hasPermi('system:dev:remove')")
    @Log(title = "quality_problem", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(qualityProblemService.deleteQualityProblemByIds(ids));
    }
    /**
     * 导入数据管理列表
     */
    @Log(title = "数据管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        List<QualityProblem> QualityProblemList = util.importExcel(file.getInputStream());
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = getUsername();
        String message = qualityProblemService.importData(QualityProblemList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<QualityProblem> util = new ExcelUtil<QualityProblem>(QualityProblem.class);
        util.importTemplateExcel(response, "质量问题数据");
    }

    /**
     * 季度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/qualityHappenSum")
    public List<Sum> qualityHappenSum(Sum sum) {
        List<Sum> list = qualityProblemService.qualityHappenSum(sum);
        List<Sum> list1=season(sum);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list1.size();j++){
                if(list.get(i).getQuarter().equals(list1.get(j).getQuarter())){
                    list.get(i).setCondition(list1.get(j).getCondition());
                }
            }
        }
        return list;
    }

//    @GetMapping("/oneQuality")
    public List oneQuality(Sum sum){
        List<Sum> list=qualityHappenSum(sum);
        List<List<Sum>> bigList = new ArrayList<>();
        bigList.add(oneTime(list));
        bigList.add(twoTime(list));
        bigList.add(threeTime(list));
        return bigList;
    }
    /**
     * 年度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/yearHappenSum")
    public List<Sum> yearHappenSum(Sum sum){
        List<Sum> list = qualityProblemService.yearHappenSum(sum);
        List<Sum> list1=year(sum);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list1.size();j++){
                if(list.get(i).getQuarter().equals(list1.get(j).getQuarter())){
                    list.get(i).setCondition(list1.get(j).getCondition());
                }
            }
        }
        return list;
    }
//    @GetMapping("/oneYear")
    public List oneYear(Sum sum){
        List<Sum> list=yearHappenSum(sum);
        List<List<Sum>> bigList = new ArrayList<>();
        bigList.add(oneTime(list));
        bigList.add(twoTime(list));
        bigList.add(threeTime(list));
        return bigList;
    }

    @GetMapping("/oneQuality")
    public List season(Sum sum){
        List<Sum> list = new ArrayList<>();
        List<Sum> listall = qualityProblemService.qualityHappenSum(sum);
        int mark=0;
        for(int i=0;i<listall.size();i++) {
            mark=0;
            Sum obj = new Sum();
            if(i-1 >=0){
                if (listall.get(i).getSum() < listall.get(i - 1).getSum() / 2 || listall.get(i).getSum() > listall.get(i - 1).getSum() * 1.5) {
                    mark = 1;
                    obj.setQuarter(listall.get(i).getQuarter());
                    obj.setSum(listall.get(i).getSum());
                    obj.setCondition("1");
                }
            }
            if(i+2<listall.size()){
                if ((listall.get(i).getSum() * 1.2 < listall.get(i + 1).getSum() && listall.get(i + 1).getSum() * 1.2 < listall.get(i + 2).getSum()) ||
                        (listall.get(i).getSum() * 0.8 > listall.get(i + 1).getSum() && listall.get(i + 1).getSum() * 0.8 > listall.get(i + 2).getSum())) {
                    if (mark == 1) {
                        obj.setCondition("1,2");
                        mark=12;
                    } else if (mark == 0) {
                        mark = 2;
                        obj.setQuarter(listall.get(i).getQuarter());
                        obj.setSum(listall.get(i).getSum());
                        obj.setCondition("2");
                    }
                }
                if ((listall.get(i).getSum() < listall.get(i + 1).getSum() && listall.get(i + 1).getSum() < listall.get(i + 2).getSum()) ||
                        (listall.get(i).getSum() > listall.get(i + 1).getSum() && listall.get(i + 1).getSum() > listall.get(i + 2).getSum())) {
                    if (mark == 1) {
                        obj.setCondition("1,3");
                    } else if (mark == 0) {
                        obj.setQuarter(listall.get(i).getQuarter());
                        obj.setSum(listall.get(i).getSum());
                        obj.setCondition("3");
                    } else if (mark == 12) {
                        obj.setCondition("1,2,3");
                    }
                    else if (mark == 2) {
                        obj.setCondition("2,3");
                    }
                }
            }
            if(obj.getQuarter()!=null){
                list.add(obj);
            }

        }
        return list;
    }
    /**
     * 年度质量问题发生时间
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/oneYear")
    public List year(Sum sum){
        List<Sum> list = new ArrayList<>();
        List<Sum> listall = qualityProblemService.yearHappenSum(sum);
        int mark=0;
        for(int i=0;i<listall.size();i++) {
            mark=0;
            Sum obj = new Sum();
            if(i-1 >=0){
                if (listall.get(i).getSum() < listall.get(i - 1).getSum() / 2 || listall.get(i).getSum() > listall.get(i - 1).getSum() * 1.5) {
                    mark = 1;
                    obj.setQuarter(listall.get(i).getQuarter());
                    obj.setSum(listall.get(i).getSum());
                    obj.setCondition("1");
                }
            }
            if(i+2<listall.size()){
                if ((listall.get(i).getSum() * 1.2 < listall.get(i + 1).getSum() && listall.get(i + 1).getSum() * 1.2 < listall.get(i + 2).getSum()) ||
                        (listall.get(i).getSum() * 0.8 > listall.get(i + 1).getSum() && listall.get(i + 1).getSum() * 0.8 > listall.get(i + 2).getSum())) {
                    if (mark == 1) {
                        obj.setCondition("1,2");
                        mark=12;
                    } else if (mark == 0) {
                        mark = 2;
                        obj.setQuarter(listall.get(i).getQuarter());
                        obj.setSum(listall.get(i).getSum());
                        obj.setCondition("2");
                    }
                }
                if ((listall.get(i).getSum() < listall.get(i + 1).getSum() && listall.get(i + 1).getSum() < listall.get(i + 2).getSum()) ||
                        (listall.get(i).getSum() > listall.get(i + 1).getSum() && listall.get(i + 1).getSum() > listall.get(i + 2).getSum())) {
                    if (mark == 1) {
                        obj.setCondition("1,3");
                    } else if (mark == 0) {
                        obj.setQuarter(listall.get(i).getQuarter());
                        obj.setSum(listall.get(i).getSum());
                        obj.setCondition("3");
                    } else if (mark == 12) {
                        obj.setCondition("1,2,3");
                    }
                    else if (mark == 2) {
                        obj.setCondition("2,3");
                    }
                }
            }
            if(obj.getQuarter()!=null){
                list.add(obj);
            }

        }
        return list;
    }

    /**
     * 条件1较上一时间增加或减少50%以上
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> oneTime(List<Sum> list){
        List<Sum> list1=new ArrayList<>();
        for(int i=1;i<list.size();i++){
            if(list.get(i).getSum()<list.get(i-1).getSum()/2||list.get(i).getSum()>list.get(i-1).getSum()*1.5){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    /**
     * 条件2连续两个时间段增加或减少20%以上
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> twoTime(List<Sum> list){
        List<Sum> list2=new ArrayList<>();
        for(int i=0;i<list.size()-2;i++){
            if((list.get(i).getSum()*1.2<list.get(i+1).getSum() && list.get(i+1).getSum()*1.2<list.get(i+2).getSum()) ||
                    (list.get(i).getSum()*0.8>list.get(i+1).getSum() && list.get(i+1).getSum()*0.8>list.get(i+2).getSum())){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
    /**
     * 条件3连续三个时间段呈单调变化趋势
     *
     * @param
     * @return 统计结果
     */
    public List<Sum> threeTime(List<Sum> list){
        List<Sum> list3 = new ArrayList<>();
        for(int i=0;i<list.size()-2;i++){
            if((list.get(i).getSum()<list.get(i+1).getSum() && list.get(i+1).getSum()<list.get(i+2).getSum())||
            (list.get(i).getSum()>list.get(i+1).getSum() && list.get(i+1).getSum()>list.get(i+2).getSum())){
                list3.add(list.get(i));
            }
        }
        return list3;
    }
    /**
     * 质量问题涉及到的机型
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/sumByplaneType")
    public List<Sum> sumByplaneType(Sum sum) {
        List<Sum> list = qualityProblemService.sumByplaneType(sum);
        System.out.println("机型" + list);
//        System.out.println("aaaaaaaaaaaa" + list);
        return list;
    }
    /**
     * 筛选若某机型质量问题发生数大于质量问题机型平均发生数50%
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/selectPlaneType")
    public List<Sum> selectPlaneType(Sum sum) {
        List<Sum> list = sumByplaneType(sum);
        List<Sum> list1 = new ArrayList<>();
        int count=0;
        int average=0;
        for(int i=0;i<list.size();i++){
            count += list.get(i).getSum();
        }
        average = count/list.size();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getSum() >= average){
                list1.add(list.get(i));
            }
        }
        System.out.println("机型" + list1);
        return list1;
    }

    /**
     * @Description 统计爆发故障件的型号-名称及数量
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectFaultyCount")
    public List<FaultyPartsCount> selectFaultyCount() {
        int allCount = qualityProblemService.selectAllCount();
        int faultyPartsCount = qualityProblemService.selectPartsCount();
        int average = allCount/faultyPartsCount;
        List<FaultyPartsCount> list = qualityProblemService.selectCountByName();
        List<FaultyPartsCount> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            FaultyPartsCount faultyCount = list.get(i);
            int count = faultyCount.getPartsCount();
            faultyCount.setPartsProportion(average);
            if (count > average){
                list2.add(faultyCount);
            }
        }
        return list2;
    }
    /**
     * @Description 统计所有故障件的型号-名称及数量
     * @Author guohuijia
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectAllFaulty")
    public List<FaultyPartsCount> selectAllFaulty() {
        List<FaultyPartsCount> list = qualityProblemService.selectCountByName();
        return list;
    }
}
