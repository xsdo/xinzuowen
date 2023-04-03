import request from '@/utils/request'

// 查询部编好词列表
export function listGoodwords(query) {
  return request({
    url: '/resources/goodwords/list',
    method: 'get',
    params: query
  })
}

// 查询部编好词详细
export function getGoodwords(id) {
  return request({
    url: '/resources/goodwords/' + id,
    method: 'get'
  })
}

// 新增部编好词
export function addGoodwords(data) {
  return request({
    url: '/resources/goodwords',
    method: 'post',
    data: data
  })
}

// 修改部编好词
export function updateGoodwords(data) {
  return request({
    url: '/resources/goodwords',
    method: 'put',
    data: data
  })
}

// 删除部编好词
export function delGoodwords(id) {
  return request({
    url: '/resources/goodwords/' + id,
    method: 'delete'
  })
}
