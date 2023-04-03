import request from '@/utils/request'

// 查询用户粉丝列表
export function listFans(query) {
  return request({
    url: '/users/fans/list',
    method: 'get',
    params: query
  })
}

// 查询用户粉丝详细
export function getFans(id) {
  return request({
    url: '/users/fans/' + id,
    method: 'get'
  })
}

// 新增用户粉丝
export function addFans(data) {
  return request({
    url: '/users/fans',
    method: 'post',
    data: data
  })
}

// 修改用户粉丝
export function updateFans(data) {
  return request({
    url: '/users/fans',
    method: 'put',
    data: data
  })
}

// 删除用户粉丝
export function delFans(id) {
  return request({
    url: '/users/fans/' + id,
    method: 'delete'
  })
}
