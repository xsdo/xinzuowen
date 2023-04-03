import request from '@/utils/request'

// 查询阅读任务列表
export function listReadtask(query) {
  return request({
    url: '/tasks/readtask/list',
    method: 'get',
    params: query
  })
}

// 查询阅读任务详细
export function getReadtask(id) {
  return request({
    url: '/tasks/readtask/' + id,
    method: 'get'
  })
}

// 新增阅读任务
export function addReadtask(data) {
  return request({
    url: '/tasks/readtask',
    method: 'post',
    data: data
  })
}

// 修改阅读任务
export function updateReadtask(data) {
  return request({
    url: '/tasks/readtask',
    method: 'put',
    data: data
  })
}

// 删除阅读任务
export function delReadtask(id) {
  return request({
    url: '/tasks/readtask/' + id,
    method: 'delete'
  })
}
