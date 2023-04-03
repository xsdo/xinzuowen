import request from '@/utils/request'

// 查询绑定班级列表
export function listBinding(query) {
  return request({
    url: '/users/binding/list',
    method: 'get',
    params: query
  })
}

// 查询绑定班级详细
export function getBinding(id) {
  return request({
    url: '/users/binding/' + id,
    method: 'get'
  })
}

// 新增绑定班级
export function addBinding(data) {
  return request({
    url: '/users/binding',
    method: 'post',
    data: data
  })
}

// 修改绑定班级
export function updateBinding(data) {
  return request({
    url: '/users/binding',
    method: 'put',
    data: data
  })
}

// 删除绑定班级
export function delBinding(id) {
  return request({
    url: '/users/binding/' + id,
    method: 'delete'
  })
}
