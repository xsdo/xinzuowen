import request from '@/utils/request'

// 查询校园作文列表
export function listSchool(query) {
  return request({
    url: '/resources/school/list',
    method: 'get',
    params: query
  })
}

// 查询校园作文详细
export function getSchool(id) {
  return request({
    url: '/resources/school/' + id,
    method: 'get'
  })
}

// 新增校园作文
export function addSchool(data) {
  return request({
    url: '/resources/school',
    method: 'post',
    data: data
  })
}

// 修改校园作文
export function updateSchool(data) {
  return request({
    url: '/resources/school',
    method: 'put',
    data: data
  })
}

// 删除校园作文
export function delSchool(id) {
  return request({
    url: '/resources/school/' + id,
    method: 'delete'
  })
}
