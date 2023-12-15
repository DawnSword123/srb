package com.dck.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dck.srb.core.pojo.dto.ExcelDictDTO;
import com.dck.srb.core.pojo.entity.Dict;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
public interface DictService extends IService<Dict> {
    void importData(InputStream inputStream);


    List<ExcelDictDTO> listDictData();

    List<Dict> listByParentId(Long parentId);

    List<Dict> findByDictCode(String dictCode);
}
