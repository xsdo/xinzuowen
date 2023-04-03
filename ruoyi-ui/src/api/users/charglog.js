import request from '@/utils/request'

// 查询充值记录列表
export function listCharglog(query) {
  return request({
    url: '/users/charglog/list',
    method: 'get',
    params: query
  })
}

// 查询充值记录详细
export function getCharglog(id) {
  return request({
    url: '/users/charglog/' + id,
    method: 'get'
  })
}

// 新增充值记录
export function addCharglog(data) {
  return request({
    url: '/users/charglog',
    method: 'post',
    data: data
  })
}

// 修改充值记录
export function updateCharglog(data) {
  return request({
    url: '/users/charglog',
    method: 'put',
    data: data
  })
}

// 删除充值记录
export function delCharglog(id) {
  return request({
    url: '/users/charglog/' + id,
    method: 'delete'
  })
}
