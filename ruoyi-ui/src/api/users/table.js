import request from '@/utils/request'

// 查询用户标签列表
export function listTable(query) {
  return request({
    url: '/users/table/list',
    method: 'get',
    params: query
  })
}

// 查询用户标签详细
export function getTable(id) {
  return request({
    url: '/users/table/' + id,
    method: 'get'
  })
}

// 新增用户标签
export function addTable(data) {
  return request({
    url: '/users/table',
    method: 'post',
    data: data
  })
}

// 修改用户标签
export function updateTable(data) {
  return request({
    url: '/users/table',
    method: 'put',
    data: data
  })
}

// 删除用户标签
export function delTable(id) {
  return request({
    url: '/users/table/' + id,
    method: 'delete'
  })
}
