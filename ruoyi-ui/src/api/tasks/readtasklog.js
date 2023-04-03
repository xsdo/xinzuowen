import request from '@/utils/request'

// 查询阅读任务记录列表
export function listReadtasklog(query) {
  return request({
    url: '/tasks/readtasklog/list',
    method: 'get',
    params: query
  })
}

// 查询阅读任务记录详细
export function getReadtasklog(id) {
  return request({
    url: '/tasks/readtasklog/' + id,
    method: 'get'
  })
}

// 新增阅读任务记录
export function addReadtasklog(data) {
  return request({
    url: '/tasks/readtasklog',
    method: 'post',
    data: data
  })
}

// 修改阅读任务记录
export function updateReadtasklog(data) {
  return request({
    url: '/tasks/readtasklog',
    method: 'put',
    data: data
  })
}

// 删除阅读任务记录
export function delReadtasklog(id) {
  return request({
    url: '/tasks/readtasklog/' + id,
    method: 'delete'
  })
}
