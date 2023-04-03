import request from '@/utils/request'

// 查询部编同步作文列表
export function listDepartment(query) {
  return request({
    url: '/resources/department/list',
    method: 'get',
    params: query
  })
}

// 查询部编同步作文详细
export function getDepartment(id) {
  return request({
    url: '/resources/department/' + id,
    method: 'get'
  })
}

// 新增部编同步作文
export function addDepartment(data) {
  return request({
    url: '/resources/department',
    method: 'post',
    data: data
  })
}

// 修改部编同步作文
export function updateDepartment(data) {
  return request({
    url: '/resources/department',
    method: 'put',
    data: data
  })
}

// 删除部编同步作文
export function delDepartment(id) {
  return request({
    url: '/resources/department/' + id,
    method: 'delete'
  })
}
