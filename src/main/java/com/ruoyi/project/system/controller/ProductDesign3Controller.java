package com.ruoyi.project.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
//import org.junit.Test;
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
import com.ruoyi.project.system.domain.ProductDesign3;
import com.ruoyi.project.system.service.IProductDesign3Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 成品件设计数据Controller
 *
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system/prodeuctDesign3")
public class ProductDesign3Controller extends BaseController
{
    @Autowired
    private IProductDesign3Service productDesign3Service;

    /**
     * 查询成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductDesign3 productDesign3)
    {
        startPage();
        List<ProductDesign3> list = productDesign3Service.selectProductDesign3List(productDesign3);
        return getDataTable(list);
    }


    static class XYObject{
        private  String finishedName;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date modifyTime;
        public void setFinishedName(String finishedName)
        {
            this.finishedName = finishedName;
        }
        public String getFinishedName()
        {
            return finishedName;
        }
        public void setModifyTime(Date modifyTime)
        {
            this.modifyTime = modifyTime;
        }
        public Date getModifyTime()
        {
            return modifyTime;
        }
    }


    @GetMapping("/xyobject")
    public List<XYObject> xyobject(ProductDesign3 productDesign3)
    {
        List<ProductDesign3> list = productDesign3Service.selectProductDesign3List(productDesign3);
        List<XYObject> listxy = new ArrayList<>();
        for(ProductDesign3 p : list){
            XYObject xy = new XYObject();
            xy.setFinishedName(p.getFinishedName());
            xy.setModifyTime(p.getModifyTime());
            listxy.add(xy);
        }
        //对listxy进行排序
        for(int i=0;i<listxy.size();i++){
            for(int j=0;j<listxy.size()-1-i;j++){
                if(listxy.get(j).getModifyTime().compareTo(listxy.get(j+1).getModifyTime())>0){
                    XYObject obj = new XYObject();
                    obj.setModifyTime(listxy.get(j).getModifyTime());
                    obj.setFinishedName(listxy.get(j).getFinishedName());
                    listxy.get(j).setFinishedName(listxy.get(j+1).getFinishedName());
                    listxy.get(j).setModifyTime(listxy.get(j+1).getModifyTime());
                    listxy.get(j+1).setFinishedName(obj.getFinishedName());
                    listxy.get(j+1).setModifyTime(obj.getModifyTime());
                }
            }
        }
        return listxy;
    }






    /**
     * 导出成品件设计数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:export')")
    @Log(title = "成品件设计数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductDesign3 productDesign3)
    {
        List<ProductDesign3> list = productDesign3Service.selectProductDesign3List(productDesign3);
        ExcelUtil<ProductDesign3> util = new ExcelUtil<ProductDesign3>(ProductDesign3.class);
        util.exportExcel(response, list, "成品件设计数据数据");
    }

    /**
     * 获取成品件设计数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productDesign3Service.selectProductDesign3ById(id));
    }

    /**
     * 新增成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:add')")
    @Log(title = "成品件设计数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductDesign3 productDesign3)
    {
        return toAjax(productDesign3Service.insertProductDesign3(productDesign3));
    }

    /**
     * 修改成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:edit')")
    @Log(title = "成品件设计数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductDesign3 productDesign3)
    {
        return toAjax(productDesign3Service.updateProductDesign3(productDesign3));
    }

    /**
     * 删除成品件设计数据
     */
    @PreAuthorize("@ss.hasPermi('system:prodeuctDesign3:remove')")
    @Log(title = "成品件设计数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productDesign3Service.deleteProductDesign3ByIds(ids));
    }
}
