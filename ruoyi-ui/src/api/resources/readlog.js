import request from '@/utils/request'

// 查询阅读记录列表
export function listReadlog(query) {
  return request({
    url: '/resources/readlog/list',
    method: 'get',
    params: query
  })
}

// 查询阅读记录详细
export function getReadlog(id) {
  return request({
    url: '/resources/readlog/' + id,
    method: 'get'
  })
}

// 新增阅读记录
export function addReadlog(data) {
  return request({
    url: '/resources/readlog',
    method: 'post',
    data: data
  })
}

// 修改阅读记录
export function updateReadlog(data) {
  return request({
    url: '/resources/readlog',
    method: 'put',
    data: data
  })
}

// 删除阅读记录
export function delReadlog(id) {
  return request({
    url: '/resources/readlog/' + id,
    method: 'delete'
  })
}
