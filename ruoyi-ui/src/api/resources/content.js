import request from '@/utils/request'

// 查询杂志内容列表
export function listContent(query) {
  return request({
    url: '/resources/content/list',
    method: 'get',
    params: query
  })
}

// 查询杂志内容详细
export function getContent(id) {
  return request({
    url: '/resources/content/' + id,
    method: 'get'
  })
}

// 新增杂志内容
export function addContent(data) {
  return request({
    url: '/resources/content',
    method: 'post',
    data: data
  })
}

// 修改杂志内容
export function updateContent(data) {
  return request({
    url: '/resources/content',
    method: 'put',
    data: data
  })
}

// 删除杂志内容
export function delContent(id) {
  return request({
    url: '/resources/content/' + id,
    method: 'delete'
  })
}
