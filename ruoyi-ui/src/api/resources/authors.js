import request from '@/utils/request'

// 查询作者列表
export function listAuthors(query) {
  return request({
    url: '/resources/authors/list',
    method: 'get',
    params: query
  })
}

// 查询作者详细
export function getAuthors(id) {
  return request({
    url: '/resources/authors/' + id,
    method: 'get'
  })
}

// 新增作者
export function addAuthors(data) {
  return request({
    url: '/resources/authors',
    method: 'post',
    data: data
  })
}

// 修改作者
export function updateAuthors(data) {
  return request({
    url: '/resources/authors',
    method: 'put',
    data: data
  })
}

// 删除作者
export function delAuthors(id) {
  return request({
    url: '/resources/authors/' + id,
    method: 'delete'
  })
}
