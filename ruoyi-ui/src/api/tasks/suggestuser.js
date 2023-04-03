import request from '@/utils/request'

// 查询推荐用户列表
export function listSuggestuser(query) {
  return request({
    url: '/tasks/suggestuser/list',
    method: 'get',
    params: query
  })
}

// 查询推荐用户详细
export function getSuggestuser(id) {
  return request({
    url: '/tasks/suggestuser/' + id,
    method: 'get'
  })
}

// 新增推荐用户
export function addSuggestuser(data) {
  return request({
    url: '/tasks/suggestuser',
    method: 'post',
    data: data
  })
}

// 修改推荐用户
export function updateSuggestuser(data) {
  return request({
    url: '/tasks/suggestuser',
    method: 'put',
    data: data
  })
}

// 删除推荐用户
export function delSuggestuser(id) {
  return request({
    url: '/tasks/suggestuser/' + id,
    method: 'delete'
  })
}
