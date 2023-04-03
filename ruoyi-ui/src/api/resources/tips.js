import request from '@/utils/request'

// 查询举报列表
export function listTips(query) {
  return request({
    url: '/resources/tips/list',
    method: 'get',
    params: query
  })
}

// 查询举报详细
export function getTips(id) {
  return request({
    url: '/resources/tips/' + id,
    method: 'get'
  })
}

// 新增举报
export function addTips(data) {
  return request({
    url: '/resources/tips',
    method: 'post',
    data: data
  })
}

// 修改举报
export function updateTips(data) {
  return request({
    url: '/resources/tips',
    method: 'put',
    data: data
  })
}

// 删除举报
export function delTips(id) {
  return request({
    url: '/resources/tips/' + id,
    method: 'delete'
  })
}
