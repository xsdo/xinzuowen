import request from '@/utils/request'

// 查询认证用户记录列表
export function listAuthtasklog(query) {
  return request({
    url: '/tasks/authtasklog/list',
    method: 'get',
    params: query
  })
}

// 查询认证用户记录详细
export function getAuthtasklog(id) {
  return request({
    url: '/tasks/authtasklog/' + id,
    method: 'get'
  })
}

// 新增认证用户记录
export function addAuthtasklog(data) {
  return request({
    url: '/tasks/authtasklog',
    method: 'post',
    data: data
  })
}

// 修改认证用户记录
export function updateAuthtasklog(data) {
  return request({
    url: '/tasks/authtasklog',
    method: 'put',
    data: data
  })
}

// 删除认证用户记录
export function delAuthtasklog(id) {
  return request({
    url: '/tasks/authtasklog/' + id,
    method: 'delete'
  })
}
