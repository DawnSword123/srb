package com.dck.srb.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dck.srb.core.pojo.dto.ExcelDictDTO;
import com.dck.srb.core.pojo.entity.Dict;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author Dawn
 * @since 2023-11-29
 */
public interface DictMapper extends BaseMapper<Dict> {
    void insertBatch(List<ExcelDictDTO> list);
}
