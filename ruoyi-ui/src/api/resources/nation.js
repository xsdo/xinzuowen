import request from '@/utils/request'

// 查询全国作文列表
export function listNation(query) {
  return request({
    url: '/resources/nation/list',
    method: 'get',
    params: query
  })
}

// 查询全国作文详细
export function getNation(id) {
  return request({
    url: '/resources/nation/' + id,
    method: 'get'
  })
}

// 新增全国作文
export function addNation(data) {
  return request({
    url: '/resources/nation',
    method: 'post',
    data: data
  })
}

// 修改全国作文
export function updateNation(data) {
  return request({
    url: '/resources/nation',
    method: 'put',
    data: data
  })
}

// 删除全国作文
export function delNation(id) {
  return request({
    url: '/resources/nation/' + id,
    method: 'delete'
  })
}
