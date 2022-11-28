package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.FaultyPartsCount;
import com.ruoyi.project.system.domain.PartsTypeCount;
import com.ruoyi.project.system.domain.QualityProblem;
import com.ruoyi.project.system.domain.Sum;
import com.ruoyi.project.system.domain.*;
import com.ruoyi.project.system.service.IQualityProblem1Service;
import com.ruoyi.project.system.service.IQualityProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
    @Autowired
    private IQualityProblem1Service qualityProblem1Service;
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
        Collections.reverse(list);
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
        Collections.reverse(list);
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
     * 4.2.1.2 质量问题涉及到的机型
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
     * 4.2.1.2筛选若某机型质量问题发生数大于质量问题机型平均发生数50%
     *
     * @param
     * @return 统计结果
     */
    @GetMapping("/selectPlaneType")
    public List<Sum> selectPlaneType(Sum sum) {
        List<Sum> list = sumByplaneType(sum);
        List<Sum> list1 = new ArrayList<>();
        int count=0;
        double average=0;
        for(int i=0;i<list.size();i++){
            count += list.get(i).getSum();
        }
        average = count/list.size();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getSum() > average*0.5){
                list1.add(list.get(i));
            }
        }
//        System.out.println("机型" + list1);
        return list1;
    }
    /**4.2.1.6
     * @Description      4.2.1.7质量问题发生地理环境
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/sumByEnvironment")
    public List<Sum> sumByEnvironment(){
        List<Sum> list = qualityProblemService.sumByEnvironment();
        return list;
    }
    /**4.2.1.6
     * @Description      4.2.1.7删选发生地理环境质量问题发生数大于平均发生互50%
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/highSumByEnvironment")
    public List<Sum> highSumByEnvironment(){
        List<Sum> list = sumByEnvironment();
        List<Sum> list1 = new ArrayList<>();
        int count=0;
        double average=0;
        for(int i=0;i<list.size();i++){
            count += list.get(i).getSum();
        }
        average = count/list.size();
        for(int i=0;i<list.size();i++) {
            if(list.get(i).getSum() > average*0.5){
                list1.add(list.get(i));
            }
        }
        System.out.println("发生地理环境" + list1);
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
        float allFloat = (float)allCount;
        double averageDouble = (allFloat/faultyPartsCount)*0.5;
        List<FaultyPartsCount> list = qualityProblemService.selectCountByName();
        List<FaultyPartsCount> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            FaultyPartsCount faultyCount = list.get(i);
            int count = faultyCount.getPartsCount();
            double percentage=((double) count/ averageDouble)*100;
            String percentage1 = String.format("%.2f",percentage)+"%";
            faultyCount.setPartsProportion(percentage1);
            if (count > averageDouble){
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

    @GetMapping("/selectPartsTypeCount")
    public List<PartsTypeCount> selectPartsTypeCount() {
        int allCount = qualityProblemService.selectAllCount();
        int partsTypeCount = qualityProblemService.selectPartsTypeCount();
        float allFloat = (float)allCount;
        double averageDouble = (allFloat/partsTypeCount)*0.5;
        List<PartsTypeCount> list = qualityProblemService.selectCountByType();
        List<PartsTypeCount> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            PartsTypeCount partsTypeCount1 = list.get(i);
            int count = partsTypeCount1.getPartsCount();
            double percentage=((double) count/ averageDouble)*100;
            String percentage1 = String.format("%.2f",percentage)+"%";
            partsTypeCount1.setPartsProportion(percentage1);
//            if (count > averageDouble){
            PartsTypeCount partsTypeCount2 = list.get(0);
            String count1 = partsTypeCount2.getPartsProportion();
                list2.add(partsTypeCount1);
//            }
        }

        return list2;
    }
    @GetMapping("/selectAllType")
    public List<PartsTypeCount> selectAllType() {
        List<PartsTypeCount> list = qualityProblemService.selectCountByType();
        return list;
    }


    public List<QualityProblem1Controller.ModelCount> faultStatistics(QualityProblem1 qualityProblem1)
    {
        Set<String> modelName = new HashSet<>();
        List<QualityProblem1> list = qualityProblem1Service.selectQualityProblem1List(qualityProblem1);
        List<QualityProblem1Controller.ModelCount> listMC = new ArrayList<>();

        int count;
        for(QualityProblem1 q:list){
            modelName.add(q.getFaultModel());
        }

        for (String s:modelName) {
            count = 0;
            QualityProblem1Controller.ModelCount modelCount = new QualityProblem1Controller.ModelCount();
            for (QualityProblem1 q : list) {
                if (Objects.equals(s, q.getFaultModel())) {
                    modelCount.setFaultModel(s);
                    count++;
                    modelCount.setModelCount(count);
                }
            }
            listMC.add(modelCount);
        }
        return listMC;
    }

    /**4.2.2.16
     * @Description  (根据dev_use_time)不同状态故障模式
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectState1")
    public List<String> selectState1(){
        List<DevState> devState = qualityProblemService.selectState1();
        QualityProblem1 qualityProblem1 = new QualityProblem1();
        List<QualityProblem1Controller.ModelCount> list2 = faultStatistics(qualityProblem1);
        List<String> list3=new ArrayList<>();
        int mark=0;
        for(DevState d:devState){
            for(QualityProblem1Controller.ModelCount m:list2){
                if(d.getPartsModel().equals(m.getFaultModel())){
                    list3.add(d.getState());
                }
            }
        }
        List<String> res=new ArrayList<>();
        for(String s:list3){
            mark=0;
            for(String i:res){
                if(s.equals(i)){
                    mark=-1;
                }
            }
            if(mark==0){
                res.add(s);
            }
        }
//        System.out.println("测试状态" + res);
        return res;
    }
    /**4.2.2.16
     * @Description  (根据dev_repaired)不同状态统计质量总数
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectQualityByState1")
    public List<Sum> selectQualityByState1(){
        List<Sum> list1 = qualityProblemService.selectQualityByState1();
        List<String> s1 = selectState1();
        List<Sum> res = new ArrayList<>();
        for(Sum i:list1){
            for(String j:s1){
                if(i.getQuarter() == null){
                    continue;
                }
                if(i.getQuarter().equals(j)){
                    res.add(i);
                }
            }
        }
        List<Sum> qualitySum = selectQualityByState2();
        for(Sum s:qualitySum){
            res.add(s);
        }
        return res;
    }
    /**4.2.2.16
     * @Description  (根据dev_repaired是否大修过)不同状态质量总数
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
//    @GetMapping("/selectQualityByState2")
    public List<Sum> selectQualityByState2(){
        List<Sum> list1=qualityProblemService.selectQualityByState2();
        QualityProblem q = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(q);
        QualityProblem1 qualityProblem1 = new QualityProblem1();
        List<QualityProblem1Controller.ModelCount> list2 = faultStatistics(qualityProblem1);
        String s="";
        List<Sum> res = new ArrayList<>();
        for(QualityProblem i:list){
            if(i.getDevRepaired() == null){
                continue;
            }
            for(QualityProblem1Controller.ModelCount m: list2){
                if(m.getFaultModel().equals(i.getFaultModel()) && i.getDevRepaired().equals("是")){
                    s="大修过";
                }
            }
        }
        for(Sum i:list1){
            if(i.getQuarter().equals("是")){
                Sum sum = new Sum();
                sum.setQuarter("大修过");
                sum.setSum(i.getSum());
                res.add(sum);
            }
        }
        return res;
    }
    /**4.2.2.16
     * @Description (根据dev_use_time)不同状态装备的故障件数量
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectTroubleByState1")
    public List<Sum> selectTroubleByState1(){
        List<Sum> list1 = qualityProblemService.selectTroubleByState1();
        List<String> s1 = selectState1();
        List<Sum> res = new ArrayList<>();
        for(Sum i:list1){
            for(String j:s1){
                if(i.getQuarter() == null){
                    continue;
                }
                if(i.getQuarter().equals(j)){
                    res.add(i);
                }
            }
        }
        List<Sum> troubleSum = selectTroubleByState2();
        for(Sum s:troubleSum){
            res.add(s);
        }
//        System.out.println("测试状态" + res);
        return res;
    }
    @GetMapping("/selectTroubleByState2")
    public List<Sum> selectTroubleByState2(){
        List<Sum> list1 = qualityProblemService.selectTroubleByState2();
        QualityProblem q = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(q);
        QualityProblem1 qualityProblem1 = new QualityProblem1();
        List<QualityProblem1Controller.ModelCount> list2 = faultStatistics(qualityProblem1);
        String s="";
        List<Sum> res = new ArrayList<>();
        for(QualityProblem i:list){
            if(i.getDevRepaired() == null){
                continue;
            }
            for(QualityProblem1Controller.ModelCount m: list2){
                if(m.getFaultModel().equals(i.getFaultModel()) && i.getDevRepaired().equals("是")){
                    s="大修过";
                }
            }
        }
        for(Sum i:list1){
            if(i.getQuarter().equals("是")){
                Sum sum = new Sum();
                sum.setQuarter("大修过");
                sum.setSum(i.getSum());
                res.add(sum);
            }
        }
        return res;

    }
    /**4.2.2.3
     * @Description 高发故障模式涉及到的故障件的生产班组
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectByGradeFaultModel")
    public List<String> selectByGradeFaultModel(){
        List<GradeCount> list = new ArrayList<>();
        List<GradeCount> list1 = qualityProblemService.selectByGradeFaultModel();
        QualityProblem1 qualityProblem1 = new QualityProblem1();
        List<QualityProblem1Controller.ModelCount> list2 = faultStatistics(qualityProblem1);
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1.get(i).getFaultModel().equals(list2.get(j).getFaultModel())){
                    list.add(list1.get(i));
                }
            }
        }

        List<String> result = new ArrayList<>();
        int mark=0;
        for (GradeCount str : list) {
            mark=0;
            for (String g : result) {
                if (str.getProductMakeGroup().equals(g)) {
                    mark = -1;
                }
            }
            if (mark == 0) {
                result.add(str.getProductMakeGroup());
            }
        }
//        System.out.println("测试aaaaaaaaa" + result);
        return result;
    }
    /**4.2.2.3
     * @Description 生产班组统计质量问题总数
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/qualitySumByGrade")
    public List<Integer> qualitySumByGrade() {
        List<Sum> l1 = qualityProblemService.qualitySumByGrade();
        List<String> grade = new ArrayList<>();
               grade = selectByGradeFaultModel();
        List<Integer> res = new ArrayList<>();
        for(Sum i:l1){
            for(String j:grade){
                if(i.getQuarter().equals(j)){
                    res.add(i.getSum());
                }
            }
        }
//        System.out.println("测试aaaaaaaaa" + l1);
  //      System.out.println("测试aaaaaaaaa" + res);
        return res;
    }
    /**4.2.2.3
     * @Description 生产班组统计产品总数
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/productSumByGrade")
    public List<Integer> productSumByGrade() {
        List<Sum> l1 = qualityProblemService.productSumByGrade();
        List<String> grade = selectByGradeFaultModel();
        List<Integer> res = new ArrayList<>();
        for(Sum i:l1){
            for(String j:grade){
                if(i.getQuarter().equals(j)){
                    res.add(i.getSum());
                }
            }
        }
//        System.out.println("测试aaaaaaaaa" + l1);
//        System.out.println("测试aaaaaaaaa" + res);
        return res;
    }
    static class time1{
        private String name;
        private List<Date> list=new ArrayList<>();
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Date> getList() {
            return list;
        }

        public void setList(List<Date> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "Time1{" +
                    "name='" + name + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    static class timeCount{
        private String name;
        private Date time;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "TimeCount{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    '}';
        }
    }
    /**4.2.2.3
     * @Description 故障件生产班组变更
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectByGradeChanged")
    public List<timeCount> selectByGradeChanged(){
        List <ProductModifyData> list = qualityProblemService.selectByGradeChanged();
        List<timeCount> res = new ArrayList<>();
        for(ProductModifyData p:list){
            timeCount t1=new timeCount();
            t1.setName(p.getProductName());
            t1.setTime(p.getModifyTime());
            res.add(t1);
        }
//        System.out.println("测试aaaaaaaaa" + res);

        return res;
    }
    /**4.2.2.3
     * @Description 时间线图用故障件生产班组变更
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/timeGradeChanged")
    public List<time1> timeGradeChanged(){
        List<String> st = new ArrayList<>();
        List<String> st1 = new ArrayList<>();
        List<time1> res = new ArrayList<>();
        List <ProductModifyData> list = qualityProblemService.selectByGradeChanged();
        int mark=0;
        for(ProductModifyData p:list){
            mark=0;
            for(String s:st){
                if(p.getProductName().equals(s)){
                    mark=-1;
                }
            }
            if(mark==0){
                st.add(p.getProductName());
            }
        }
        for(String s:st){
            time1 t1= new time1();
            List<Date> t = new ArrayList<>();
//            t.clear();
            for(ProductModifyData p:list){
                if(s.equals(p.getProductName())){
                    t.add(p.getModifyTime());
                    t1.setList(t);
                    t1.setName(s);
                }
            }
            res.add(t1);
        }
//        System.out.println("测试aaaaaaaaa" + res);
        return res;
    }
//    使用环境实体
    static class Environment {
        private String environment;
        private String faultModel;

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }

        public String getFaultModel() {
            return faultModel;
        }

        public void setFaultModel(String faultModel) {
            this.faultModel = faultModel;
        }
        @Override
        public String toString() {
            return "Environment{" +
                    "environment='" + environment + '\'' +
                    ", faultModel='" + faultModel + '\'' +
                    '}';
        }
    }
    /**4.2.2.16
     * @Description 质量问题高发故障模式涉及到的装备使用环境
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectEnvironment")
    public List<Environment> selectEnvironment(){
        QualityProblem q = new QualityProblem();
        List<QualityProblem> list = qualityProblemService.selectQualityProblemList(q);
        QualityProblem1 qualityProblem1 = new QualityProblem1();
        List<QualityProblem1Controller.ModelCount> list2 = faultStatistics(qualityProblem1);

        List<Environment> res = new ArrayList<>();
        for(QualityProblem i:list){
            for(QualityProblem1Controller.ModelCount m: list2){
                if(m.getFaultModel().equals(i.getFaultModel())){
                    Environment environment = new Environment();
                    environment.setFaultModel(i.getFaultModel());
                    environment.setEnvironment(i.getEnvironment());
                    res.add(environment);
                }
            }
        }
        return res;
    }
    /**4.2.2.16
     * @Description 不同使用环境中装备数量
     * @Author lixin
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectDevByEnvironment")
    public List<Sum> selectDevByEnvironment(){
        List<String> list = new ArrayList<>();
        List<Sum> count = qualityProblemService.selectDevByEnvironment();
        List<Environment> e = selectEnvironment();
        List<Sum> res = new ArrayList<>();
        int mark=0;
        for(Environment i: e){
            mark=0;
            if(i.getEnvironment() == null){
                i.setEnvironment(" ");
            }
            for(String s:list){
                if(i.getEnvironment().equals(s)){
                    mark=1;
                }
            }
            if(mark==0){
                list.add(i.getEnvironment());
            }
        }
        for(Sum s:count){
            if(s.getQuarter() == null){
                s.setQuarter(" ");
            }
            for(String i:list){
                if(s.getQuarter().equals(i)){
                    res.add(s);
                }
            }
        }
//        System.out.println("测试aaaaaaaaa" + res);
        return res;
    }
    /**4.2.2.16
     * @Description 不同使用环境中对应质量问题数
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/selectQualityByEnvironment")
    public List<Sum> selectQualityByEnvironment(){
        List<String> list = new ArrayList<>();
        List<Sum> count = qualityProblemService.selectQualityByEnvironment();
        List<Environment> e = selectEnvironment();
        List<Sum> res = new ArrayList<>();
        int mark=0;
        for(Environment i: e){
            mark=0;
            if(i.getEnvironment() == null){
                i.setEnvironment(" ");
            }
            for(String s:list){
                if(i.getEnvironment().equals(s)){
                    mark=1;
                }
            }
            if(mark==0){
                list.add(i.getEnvironment());
            }
        }
        for(Sum s:count){
            if(s.getQuarter() == null){
                s.setQuarter(" ");
            }
            for(String i:list){
                if(s.getQuarter().equals(i)){
                    res.add(s);
                }
            }
        }
        System.out.println("测试aaaaaaaaa" + res);
        return res;
    }

    /**
     * @Description 4.2.2.6 故障件生产设备变更情况
     * @Author lvXingFeng
     */
    @GetMapping("/selectByProduceDeviceChanged")
    public List<timeCount> selectByProduceDeviceChanged() {
        List<ProductModifyData> list = qualityProblemService.selectByProduceDeviceChanged();
        List<timeCount> res = new ArrayList<>();
        for (ProductModifyData p : list) {
            timeCount t1 = new timeCount();
            t1.setName(p.getProductName());
            t1.setTime(p.getModifyTime());
            res.add(t1);
        }
//        System.out.println("测试aaaaaaaaa" + res);

        return res;
    }

    /**
     * 4.2.2.3
     *
     * @Description 时间线图用故障件生产设备变更
     * @Author lvXingFeng
     */
    @GetMapping("/timeProduceDeviceChanged")
    public List<time1> timeProduceDeviceChanged() {
        List<String> st = new ArrayList<>();
        List<String> st1 = new ArrayList<>();
        List<time1> res = new ArrayList<>();
        List<ProductModifyData> list = qualityProblemService.selectByProduceDeviceChanged();
        int mark = 0;
        for (ProductModifyData p : list) {
            for (String s : st) {
                if (p.getProductName().equals(s)) {
                    mark = -1;
                }
            }
            if (mark == 0) {
                st.add(p.getProductName());
            }
        }
        for (String s : st) {
            time1 t1 = new time1();
            List<Date> t = new ArrayList<>();
            for (ProductModifyData p : list) {
                if (s.equals(p.getProductName())) {
                    t.add(p.getModifyTime());
                    t1.setList(t);
                    t1.setName(s);
                }
            }
            res.add(t1);
        }
        return res;
    }
    /**4.2.1.6
     * @Description  质量问题故障模式随时间变化情况
     * @Author lixn
     * @Date  2022/11/14
     * @Param
     * @Return
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @GetMapping("/faultModelByQuarter")
    public List<Sum> faultModelByQuarter(){
        List<Sum> list = new ArrayList<>();

        List<Sum> listall = qualityProblemService.faultModelByQuarter();
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
        System.out.println("测试aaaaaaaaa" + list);
        Collections.reverse(list);
        return list;
    }
    @GetMapping("/faultModelByYear")
    public List<Sum> faultModelByYear(){
        List<Sum> list = new ArrayList<>();
        List<Sum> listall = qualityProblemService.faultModelByYear();
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
        System.out.println("测试vvvvvvvvvvvv" + list);
        Collections.reverse(list);
        return list;
    }
//    质量问题故障模式季度总数
    @GetMapping("/faultModelByQuarterSum")
    public List<Sum> faultModelByQuarterSum(Sum sum) {
        List<Sum> list = qualityProblemService.faultModelByQuarter();

        List<Sum> list1=faultModelByQuarter();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list1.size();j++){
                if(list.get(i).getQuarter().equals(list1.get(j).getQuarter())){
                    list.get(i).setCondition(list1.get(j).getCondition());
                }
            }
        }
        return list;
    }
    //    质量问题故障模式年度总数
    @GetMapping("/faultModelByYearSum")
    public List<Sum> faultModelByYearSum(Sum sum){
        List<Sum> list = qualityProblemService.faultModelByYear();
//        Collections.reverse(list);
        List<Sum> list1=faultModelByYear();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list1.size();j++){
                if(list.get(i).getQuarter().equals(list1.get(j).getQuarter())){
                    list.get(i).setCondition(list1.get(j).getCondition());
                }
            }
        }
        return list;
    }
}
