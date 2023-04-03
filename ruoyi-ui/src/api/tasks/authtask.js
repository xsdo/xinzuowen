import request from '@/utils/request'

// 查询认证任务列表
export function listAuthtask(query) {
  return request({
    url: '/tasks/authtask/list',
    method: 'get',
    params: query
  })
}

// 查询认证任务详细
export function getAuthtask(id) {
  return request({
    url: '/tasks/authtask/' + id,
    method: 'get'
  })
}

// 新增认证任务
export function addAuthtask(data) {
  return request({
    url: '/tasks/authtask',
    method: 'post',
    data: data
  })
}

// 修改认证任务
export function updateAuthtask(data) {
  return request({
    url: '/tasks/authtask',
    method: 'put',
    data: data
  })
}

// 删除认证任务
export function delAuthtask(id) {
  return request({
    url: '/tasks/authtask/' + id,
    method: 'delete'
  })
}
