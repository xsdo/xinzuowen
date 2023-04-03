package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CCollectlog;

/**
 * 收藏夹文件Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CCollectlogMapper
{
    /**
     * 查询收藏夹文件
     *
     * @param id 收藏夹文件主键
     * @return 收藏夹文件
     */
    public CCollectlog selectCCollectlogById(Long id);

    /**
     * 查询收藏夹文件列表
     *
     * @param cCollectlog 收藏夹文件
     * @return 收藏夹文件集合
     */
    public List<CCollectlog> selectCCollectlogList(CCollectlog cCollectlog);

    /**
     * 新增收藏夹文件
     *
     * @param cCollectlog 收藏夹文件
     * @return 结果
     */
    public int insertCCollectlog(CCollectlog cCollectlog);

    /**
     * 修改收藏夹文件
     *
     * @param cCollectlog 收藏夹文件
     * @return 结果
     */
    public int updateCCollectlog(CCollectlog cCollectlog);

    /**
     * 删除收藏夹文件
     *
     * @param id 收藏夹文件主键
     * @return 结果
     */
    public int deleteCCollectlogById(Long id);

    /**
     * 批量删除收藏夹文件
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCCollectlogByIds(Long[] ids);
}
