import request from '@/utils/request'

// 查询消息通知列表
export function listNotice(query) {
  return request({
    url: '/users/notice/list',
    method: 'get',
    params: query
  })
}

// 查询消息通知详细
export function getNotice(id) {
  return request({
    url: '/users/notice/' + id,
    method: 'get'
  })
}

// 新增消息通知
export function addNotice(data) {
  return request({
    url: '/users/notice',
    method: 'post',
    data: data
  })
}

// 修改消息通知
export function updateNotice(data) {
  return request({
    url: '/users/notice',
    method: 'put',
    data: data
  })
}

// 删除消息通知
export function delNotice(id) {
  return request({
    url: '/users/notice/' + id,
    method: 'delete'
  })
}
