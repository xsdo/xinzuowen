import request from '@/utils/request'

// 查询收藏夹文件列表
export function listCollectlog(query) {
  return request({
    url: '/resources/collectlog/list',
    method: 'get',
    params: query
  })
}

// 查询收藏夹文件详细
export function getCollectlog(id) {
  return request({
    url: '/resources/collectlog/' + id,
    method: 'get'
  })
}

// 新增收藏夹文件
export function addCollectlog(data) {
  return request({
    url: '/resources/collectlog',
    method: 'post',
    data: data
  })
}

// 修改收藏夹文件
export function updateCollectlog(data) {
  return request({
    url: '/resources/collectlog',
    method: 'put',
    data: data
  })
}

// 删除收藏夹文件
export function delCollectlog(id) {
  return request({
    url: '/resources/collectlog/' + id,
    method: 'delete'
  })
}
