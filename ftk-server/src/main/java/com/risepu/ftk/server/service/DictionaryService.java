package com.risepu.ftk.server.service;

import com.risepu.ftk.server.domain.Dictionary;
import com.risepu.ftk.server.domain.DictionaryData;
import com.risepu.ftk.utils.PageResult;

import java.util.List;

/**
 * @author ronghaohua
 */
public interface DictionaryService {


    /**
     * 根据参数查询行业分类列表
     * @param key
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Dictionary> queryIndustryClassByParam(String key, Integer pageNo, Integer pageSize);

    /**
     * 添加行业分类
     * @param dictionary
     */
    void addIndustryClass(Dictionary dictionary);

    /**
     * 修改行业分类
     * @param dictionary
     */
    void updataIndustryClass(Dictionary dictionary);

    /**
     * 根据行业编码查询行业分类
     * @param dictCode
     * @return
     */
    Dictionary findIndustryClassByCode(String dictCode);

    /**
     * 根据id查询行业分类
     * @param id
     * @return
     */
    Dictionary findIndustryClassById(Long id);

    /**
     * 根据父id和参数查询行业详情分类
     * @param key
     * @param dictId 行业分类id
     * @return
     */
    List<DictionaryData> queryIndustryDetailByParam(String key, Integer dictId);

    /**
     * 根据父id查询行业详情
     * @param dictId 行业分类字典id
     * @return
     */

    List<DictionaryData> queryAllData(Integer dictId);

    /**
     * 增加行业
     * @param dictionaryData 行业数据
     */
    void addIndustry(DictionaryData dictionaryData);

    /**
     * 根据行业编号查询行业
     * @param code 行业编号
     * @return
     */
    DictionaryData findIndustryByCode(String code);

    /**
     * 修改行业
     * @param dictionaryData
     */
    void editIndustry(DictionaryData dictionaryData);

    /**
     * 根据id 修改行业为删除状态
     * @param l
     */
    void delIndustryById(long l);
}