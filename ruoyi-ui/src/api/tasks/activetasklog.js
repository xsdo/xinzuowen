import request from '@/utils/request'

// 查询活动用户记录列表
export function listActivetasklog(query) {
  return request({
    url: '/tasks/activetasklog/list',
    method: 'get',
    params: query
  })
}

// 查询活动用户记录详细
export function getActivetasklog(id) {
  return request({
    url: '/tasks/activetasklog/' + id,
    method: 'get'
  })
}

// 新增活动用户记录
export function addActivetasklog(data) {
  return request({
    url: '/tasks/activetasklog',
    method: 'post',
    data: data
  })
}

// 修改活动用户记录
export function updateActivetasklog(data) {
  return request({
    url: '/tasks/activetasklog',
    method: 'put',
    data: data
  })
}

// 删除活动用户记录
export function delActivetasklog(id) {
  return request({
    url: '/tasks/activetasklog/' + id,
    method: 'delete'
  })
}
