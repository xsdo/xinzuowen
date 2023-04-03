import request from '@/utils/request'

// 查询圈子列表
export function listCircle(query) {
  return request({
    url: '/resources/circle/list',
    method: 'get',
    params: query
  })
}

// 查询圈子详细
export function getCircle(id) {
  return request({
    url: '/resources/circle/' + id,
    method: 'get'
  })
}

// 新增圈子
export function addCircle(data) {
  return request({
    url: '/resources/circle',
    method: 'post',
    data: data
  })
}

// 修改圈子
export function updateCircle(data) {
  return request({
    url: '/resources/circle',
    method: 'put',
    data: data
  })
}

// 删除圈子
export function delCircle(id) {
  return request({
    url: '/resources/circle/' + id,
    method: 'delete'
  })
}
