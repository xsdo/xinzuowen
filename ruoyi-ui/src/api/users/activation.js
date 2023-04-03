import request from '@/utils/request'

// 查询激活码列表
export function listActivation(query) {
  return request({
    url: '/users/activation/list',
    method: 'get',
    params: query
  })
}

// 查询激活码详细
export function getActivation(id) {
  return request({
    url: '/users/activation/' + id,
    method: 'get'
  })
}

// 新增激活码
export function addActivation(data) {
  return request({
    url: '/users/activation',
    method: 'post',
    data: data
  })
}

// 修改激活码
export function updateActivation(data) {
  return request({
    url: '/users/activation',
    method: 'put',
    data: data
  })
}

// 删除激活码
export function delActivation(id) {
  return request({
    url: '/users/activation/' + id,
    method: 'delete'
  })
}
