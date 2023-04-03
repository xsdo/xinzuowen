import request from '@/utils/request'

// 查询用户属性列表
export function listAttribute(query) {
  return request({
    url: '/users/attribute/list',
    method: 'get',
    params: query
  })
}

// 查询用户属性详细
export function getAttribute(id) {
  return request({
    url: '/users/attribute/' + id,
    method: 'get'
  })
}

// 新增用户属性
export function addAttribute(data) {
  return request({
    url: '/users/attribute',
    method: 'post',
    data: data
  })
}

// 修改用户属性
export function updateAttribute(data) {
  return request({
    url: '/users/attribute',
    method: 'put',
    data: data
  })
}

// 删除用户属性
export function delAttribute(id) {
  return request({
    url: '/users/attribute/' + id,
    method: 'delete'
  })
}
