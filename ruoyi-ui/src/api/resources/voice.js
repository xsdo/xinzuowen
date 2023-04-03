import request from '@/utils/request'

// 查询音频列表
export function listVoice(query) {
  return request({
    url: '/resources/voice/list',
    method: 'get',
    params: query
  })
}

// 查询音频详细
export function getVoice(id) {
  return request({
    url: '/resources/voice/' + id,
    method: 'get'
  })
}

// 新增音频
export function addVoice(data) {
  return request({
    url: '/resources/voice',
    method: 'post',
    data: data
  })
}

// 修改音频
export function updateVoice(data) {
  return request({
    url: '/resources/voice',
    method: 'put',
    data: data
  })
}

// 删除音频
export function delVoice(id) {
  return request({
    url: '/resources/voice/' + id,
    method: 'delete'
  })
}
