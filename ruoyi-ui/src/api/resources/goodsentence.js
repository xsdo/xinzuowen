import request from '@/utils/request'

// 查询部编好句列表
export function listGoodsentence(query) {
  return request({
    url: '/resources/goodsentence/list',
    method: 'get',
    params: query
  })
}

// 查询部编好句详细
export function getGoodsentence(id) {
  return request({
    url: '/resources/goodsentence/' + id,
    method: 'get'
  })
}

// 新增部编好句
export function addGoodsentence(data) {
  return request({
    url: '/resources/goodsentence',
    method: 'post',
    data: data
  })
}

// 修改部编好句
export function updateGoodsentence(data) {
  return request({
    url: '/resources/goodsentence',
    method: 'put',
    data: data
  })
}

// 删除部编好句
export function delGoodsentence(id) {
  return request({
    url: '/resources/goodsentence/' + id,
    method: 'delete'
  })
}
