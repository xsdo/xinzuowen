import request from '@/utils/request'

// 查询活动任务列表
export function listActivetask(query) {
  return request({
    url: '/tasks/activetask/list',
    method: 'get',
    params: query
  })
}

// 查询活动任务详细
export function getActivetask(id) {
  return request({
    url: '/tasks/activetask/' + id,
    method: 'get'
  })
}

// 新增活动任务
export function addActivetask(data) {
  return request({
    url: '/tasks/activetask',
    method: 'post',
    data: data
  })
}

// 修改活动任务
export function updateActivetask(data) {
  return request({
    url: '/tasks/activetask',
    method: 'put',
    data: data
  })
}

// 删除活动任务
export function delActivetask(id) {
  return request({
    url: '/tasks/activetask/' + id,
    method: 'delete'
  })
}
