import request from '@/utils/request'

// 查询用户学校列表
export function listSchool(query) {
  return request({
    url: '/users/school/list',
    method: 'get',
    params: query
  })
}

// 查询用户学校详细
export function getSchool(id) {
  return request({
    url: '/users/school/' + id,
    method: 'get'
  })
}

// 新增用户学校
export function addSchool(data) {
  return request({
    url: '/users/school',
    method: 'post',
    data: data
  })
}

// 修改用户学校
export function updateSchool(data) {
  return request({
    url: '/users/school',
    method: 'put',
    data: data
  })
}

// 删除用户学校
export function delSchool(id) {
  return request({
    url: '/users/school/' + id,
    method: 'delete'
  })
}
