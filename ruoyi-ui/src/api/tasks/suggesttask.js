import request from '@/utils/request'

// 查询推荐作文列表
export function listSuggesttask(query) {
  return request({
    url: '/tasks/suggesttask/list',
    method: 'get',
    params: query
  })
}

// 查询推荐作文详细
export function getSuggesttask(id) {
  return request({
    url: '/tasks/suggesttask/' + id,
    method: 'get'
  })
}

// 新增推荐作文
export function addSuggesttask(data) {
  return request({
    url: '/tasks/suggesttask',
    method: 'post',
    data: data
  })
}

// 修改推荐作文
export function updateSuggesttask(data) {
  return request({
    url: '/tasks/suggesttask',
    method: 'put',
    data: data
  })
}

// 删除推荐作文
export function delSuggesttask(id) {
  return request({
    url: '/tasks/suggesttask/' + id,
    method: 'delete'
  })
}
