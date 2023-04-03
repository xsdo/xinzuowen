import request from '@/utils/request'

// 查询随机图列表
export function listImages(query) {
  return request({
    url: '/resources/images/list',
    method: 'get',
    params: query
  })
}

// 查询随机图详细
export function getImages(id) {
  return request({
    url: '/resources/images/' + id,
    method: 'get'
  })
}

// 新增随机图
export function addImages(data) {
  return request({
    url: '/resources/images',
    method: 'post',
    data: data
  })
}

// 修改随机图
export function updateImages(data) {
  return request({
    url: '/resources/images',
    method: 'put',
    data: data
  })
}

// 删除随机图
export function delImages(id) {
  return request({
    url: '/resources/images/' + id,
    method: 'delete'
  })
}
