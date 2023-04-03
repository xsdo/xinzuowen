import request from '@/utils/request'

// 查询投稿列表
export function listSubmit(query) {
  return request({
    url: '/resources/submit/list',
    method: 'get',
    params: query
  })
}

// 查询投稿详细
export function getSubmit(id) {
  return request({
    url: '/resources/submit/' + id,
    method: 'get'
  })
}

// 新增投稿
export function addSubmit(data) {
  return request({
    url: '/resources/submit',
    method: 'post',
    data: data
  })
}

// 修改投稿
export function updateSubmit(data) {
  return request({
    url: '/resources/submit',
    method: 'put',
    data: data
  })
}

// 删除投稿
export function delSubmit(id) {
  return request({
    url: '/resources/submit/' + id,
    method: 'delete'
  })
}
