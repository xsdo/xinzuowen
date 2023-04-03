import request from '@/utils/request'

// 查询用户点赞列表
export function listLikes(query) {
  return request({
    url: '/resources/likes/list',
    method: 'get',
    params: query
  })
}

// 查询用户点赞详细
export function getLikes(id) {
  return request({
    url: '/resources/likes/' + id,
    method: 'get'
  })
}

// 新增用户点赞
export function addLikes(data) {
  return request({
    url: '/resources/likes',
    method: 'post',
    data: data
  })
}

// 修改用户点赞
export function updateLikes(data) {
  return request({
    url: '/resources/likes',
    method: 'put',
    data: data
  })
}

// 删除用户点赞
export function delLikes(id) {
  return request({
    url: '/resources/likes/' + id,
    method: 'delete'
  })
}
