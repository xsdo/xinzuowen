import request from '@/utils/request'

// 查询禁言列表
export function listMuted(query) {
  return request({
    url: '/resources/muted/list',
    method: 'get',
    params: query
  })
}

// 查询禁言详细
export function getMuted(id) {
  return request({
    url: '/resources/muted/' + id,
    method: 'get'
  })
}

// 新增禁言
export function addMuted(data) {
  return request({
    url: '/resources/muted',
    method: 'post',
    data: data
  })
}

// 修改禁言
export function updateMuted(data) {
  return request({
    url: '/resources/muted',
    method: 'put',
    data: data
  })
}

// 删除禁言
export function delMuted(id) {
  return request({
    url: '/resources/muted/' + id,
    method: 'delete'
  })
}
