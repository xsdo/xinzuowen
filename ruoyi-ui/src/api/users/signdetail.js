import request from '@/utils/request'

// 查询签到明细列表
export function listSigndetail(query) {
  return request({
    url: '/users/signdetail/list',
    method: 'get',
    params: query
  })
}

// 查询签到明细详细
export function getSigndetail(id) {
  return request({
    url: '/users/signdetail/' + id,
    method: 'get'
  })
}

// 新增签到明细
export function addSigndetail(data) {
  return request({
    url: '/users/signdetail',
    method: 'post',
    data: data
  })
}

// 修改签到明细
export function updateSigndetail(data) {
  return request({
    url: '/users/signdetail',
    method: 'put',
    data: data
  })
}

// 删除签到明细
export function delSigndetail(id) {
  return request({
    url: '/users/signdetail/' + id,
    method: 'delete'
  })
}
