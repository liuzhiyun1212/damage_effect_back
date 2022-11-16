package com.ruoyi.project.system.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.project.system.domain.install_way;
import com.ruoyi.project.system.domain.partsSite;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.ProductDesign;
import com.ruoyi.project.system.service.IProductDesignService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 成品件设计数据Controller
 *
 * @author ruoyi
 * @date 2022-11-11
 */
@RestController
@RequestMapping("/system/design")
public class ProductDesignController extends BaseController
{
    @Autowired
    private IProductDesignService productDesignService;

    /**
     * 查询成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:design:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductDesign productDesign)
    {
        startPage();
        List<ProductDesign> list = productDesignService.selectProductDesignList(productDesign);
        return getDataTable(list);
    }

    @GetMapping("/listall")
    public List<ProductDesign> listall(ProductDesign productDesign)
    {

        List<ProductDesign> list = productDesignService.selectProductDesignList(productDesign);
        return list;
    }


    @GetMapping("/partssite")
    public List<partsSite> list()
    {

        List<partsSite> list = productDesignService.selectpartsSite();
        for(partsSite i : list){
            i.setLeftMiddleRight(i.getLeftMiddleRight()+mockLongBetween2(-0.2, 0.2));
            i.setUpperMiddleLower(i.getUpperMiddleLower()+mockLongBetween2(-0.2, 0.2));
            i.setFrame(i.getFrame()+mockLongBetween2(-0.2, 0.2));
        }
        return list;
    }

    public double mockLongBetween2(double begin, double end) {
        double between = end - begin;
        double random = Math.random();
        double randomBetween = new Double(random * between);
        double result = begin + randomBetween;
        return result;
    }

    @GetMapping("/pointcount")
    public List<partsSite> pointcount(ProductDesign productDesign){
        int sum=0;
        List<partsSite> listall= productDesignService.selectPartsSitenum();
        List<partsSite> list = new ArrayList<>();
        for(partsSite p : listall){
            sum+=p.getNum();
        }
        for(partsSite p : listall){
            if(p.getNum()>sum*0.3){
                list.add(p);
            }
        }

       /* List<ProductDesign> listdesign = productDesignService.selectProductDesignList(productDesign);
        for(ProductDesign p : listdesign ){
            for(partsSite par : list){
                if(p.getFrame()==par.getFrame()&&p.getLeftMiddleRight()==par.getLeftMiddleRight()&&p.getUpperMiddleLower()==par.getUpperMiddleLower()){
                    listdesign.add(p);
                }
            }
        }*/
        return list;
    }

    @GetMapping("/getinstall_way")
    public List<install_way2> getinstall_way(){
    List<ProductDesign> list = productDesignService.selectPartsinstall();
        List<install_way2> list2 = new ArrayList<>();
        for(ProductDesign i : list){
            install_way2 install_way=new install_way2();
            install_way.setFinishedName(i.getFinishedName());
            install_way.setFinishedModel(i.getFinishedModel());
            install_way.setLeftMiddleRight(i.getLeftMiddleRight()+mockLongBetween2(-0.2, 0.2));
            install_way.setUpperMiddleLower(i.getUpperMiddleLower()+mockLongBetween2(-0.2, 0.2));
            install_way.setFrame(i.getFrame()+mockLongBetween2(-0.2, 0.2));
            install_way.setInstallMethod(i.getInstallMethod());
            list2.add(install_way);
        }
    /*List<String> intall_way = new ArrayList<>();
    for(ProductDesign p : list){
        int mark=0;
        for(String s : intall_way){
            if(p.getInstallMethod().equals(s)){
                mark=-1;
            }
        }
        if(mark==0){
            intall_way.add(p.getInstallMethod());
        }
    }*/
        return  list2;
}

    @GetMapping("/getana_install_way")
    public List<install_way> ana_install_way(){
        List<partsSite> listqua = productDesignService.selectPartsqulitynum();
        List<partsSite> listins = productDesignService.selectPartsinstallnum();
        List<install_way> listway = productDesignService.selectinstallmethod();
        List<install_way> list = new ArrayList<>();
        List<install_way> final_list = new ArrayList<>();
        for(partsSite p : listqua){
            for(partsSite par : listins){
                if(p.getFinishedModel().equals(par.getFinishedModel())&&p.getFinishedName().equals(par.getFinishedName())){
                    double averge = p.getNum().doubleValue()/par.getNum().doubleValue()*0.5;
                    System.out.println("11111--"+p.getNum());
                    System.out.println("11111--"+par.getNum());
                    System.out.println("11111--"+p.getNum().doubleValue()/par.getNum().doubleValue());
                    System.out.println("11111--"+p.getNum().doubleValue()/par.getNum().doubleValue()*0.5);
                    System.out.println("---------------");
                    install_way ins = new install_way();
                    ins.setFinishedModel(par.getFinishedModel());
                    ins.setFinishedName(par.getFinishedName());
                    ins.setAverge(averge);
                    list.add(ins);
                }
            }
        }
        for(install_way i : listway){
            for(install_way l : list){
                if(i.getFinishedModel().equals(l.getFinishedModel())&&i.getFinishedName().equals(l.getFinishedName())&&i.getNum()>l.getAverge()){
                    final_list.add(i);
                }
            }
        }
        return final_list;
    }

    static class install_way2{
        public double getLeftMiddleRight() {
            return LeftMiddleRight;
        }

        public void setLeftMiddleRight(double leftMiddleRight) {
            LeftMiddleRight = leftMiddleRight;
        }

        public double getUpperMiddleLower() {
            return UpperMiddleLower;
        }

        public void setUpperMiddleLower(double upperMiddleLower) {
            UpperMiddleLower = upperMiddleLower;
        }

        public double getFrame() {
            return Frame;
        }

        public void setFrame(double frame) {
            Frame = frame;
        }

        public String getFinishedName() {
            return finishedName;
        }

        public void setFinishedName(String finishedName) {
            this.finishedName = finishedName;
        }

        public String getFinishedModel() {
            return finishedModel;
        }

        public void setFinishedModel(String finishedModel) {
            this.finishedModel = finishedModel;
        }

        public String getInstallMethod() {
            return installMethod;
        }

        public void setInstallMethod(String installMethod) {
            this.installMethod = installMethod;
        }

        private double LeftMiddleRight;
        private double UpperMiddleLower;
        private double Frame;
        private String finishedName;
        private String finishedModel;
        private String installMethod;
    }


    /**
     * 导出成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:design:export')")
    @Log(title = "成品件设计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductDesign productDesign)
    {
        List<ProductDesign> list = productDesignService.selectProductDesignList(productDesign);
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        util.exportExcel(response, list, "成品件设计数据数据");
    }

    /**
     * 获取成品件设计数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:design:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productDesignService.selectProductDesignById(id));
    }

    /**
     * 新增成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:add')")
    @Log(title = "成品件设计数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductDesign productDesign)
    {
        return toAjax(productDesignService.insertProductDesign(productDesign));
    }

    /**
     * 修改成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:edit')")
    @Log(title = "成品件设计数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductDesign productDesign)
    {
        return toAjax(productDesignService.updateProductDesign(productDesign));
    }

    /**
     * 删除成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:design:remove')")
    @Log(title = "成品件设计数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productDesignService.deleteProductDesignByIds(ids));
    }

    /**
     * 导入产品设计列表
     */
    @Log(title = "产品设计", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        List<ProductDesign> importDataList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = productDesignService.importData(importDataList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * @Description 下载导入产品设计模板
     * @Author guohuijia
     * @Date  2022/11/13
     * @Param [response]
     * @Return void
     * @Update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ProductDesign> util = new ExcelUtil<ProductDesign>(ProductDesign.class);
        util.importTemplateExcel(response, "产品设计数据");
    }
}
