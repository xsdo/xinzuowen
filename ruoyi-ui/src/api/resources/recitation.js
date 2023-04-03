import request from '@/utils/request'

// 查询朗读者列表
export function listRecitation(query) {
  return request({
    url: '/resources/recitation/list',
    method: 'get',
    params: query
  })
}

// 查询朗读者详细
export function getRecitation(id) {
  return request({
    url: '/resources/recitation/' + id,
    method: 'get'
  })
}

// 新增朗读者
export function addRecitation(data) {
  return request({
    url: '/resources/recitation',
    method: 'post',
    data: data
  })
}

// 修改朗读者
export function updateRecitation(data) {
  return request({
    url: '/resources/recitation',
    method: 'put',
    data: data
  })
}

// 删除朗读者
export function delRecitation(id) {
  return request({
    url: '/resources/recitation/' + id,
    method: 'delete'
  })
}
