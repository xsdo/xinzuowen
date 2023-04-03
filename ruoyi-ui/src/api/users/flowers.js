import request from '@/utils/request'

// 查询鲜花列表
export function listFlowers(query) {
  return request({
    url: '/users/flowers/list',
    method: 'get',
    params: query
  })
}

// 查询鲜花详细
export function getFlowers(id) {
  return request({
    url: '/users/flowers/' + id,
    method: 'get'
  })
}

// 新增鲜花
export function addFlowers(data) {
  return request({
    url: '/users/flowers',
    method: 'post',
    data: data
  })
}

// 修改鲜花
export function updateFlowers(data) {
  return request({
    url: '/users/flowers',
    method: 'put',
    data: data
  })
}

// 删除鲜花
export function delFlowers(id) {
  return request({
    url: '/users/flowers/' + id,
    method: 'delete'
  })
}
