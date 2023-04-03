import request from '@/utils/request'

// 查询用户会员列表
export function listVip(query) {
  return request({
    url: '/users/vip/list',
    method: 'get',
    params: query
  })
}

// 查询用户会员详细
export function getVip(id) {
  return request({
    url: '/users/vip/' + id,
    method: 'get'
  })
}

// 新增用户会员
export function addVip(data) {
  return request({
    url: '/users/vip',
    method: 'post',
    data: data
  })
}

// 修改用户会员
export function updateVip(data) {
  return request({
    url: '/users/vip',
    method: 'put',
    data: data
  })
}

// 删除用户会员
export function delVip(id) {
  return request({
    url: '/users/vip/' + id,
    method: 'delete'
  })
}
