import request from '@/utils/request'

// 查询教师班级列表
export function listTeacher(query) {
  return request({
    url: '/users/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询教师班级详细
export function getTeacher(id) {
  return request({
    url: '/users/teacher/' + id,
    method: 'get'
  })
}

// 新增教师班级
export function addTeacher(data) {
  return request({
    url: '/users/teacher',
    method: 'post',
    data: data
  })
}

// 修改教师班级
export function updateTeacher(data) {
  return request({
    url: '/users/teacher',
    method: 'put',
    data: data
  })
}

// 删除教师班级
export function delTeacher(id) {
  return request({
    url: '/users/teacher/' + id,
    method: 'delete'
  })
}
