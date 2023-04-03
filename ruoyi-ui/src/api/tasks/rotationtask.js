import request from '@/utils/request'

// 查询轮播图列表
export function listRotationtask(query) {
  return request({
    url: '/tasks/rotationtask/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图详细
export function getRotationtask(id) {
  return request({
    url: '/tasks/rotationtask/' + id,
    method: 'get'
  })
}

// 新增轮播图
export function addRotationtask(data) {
  return request({
    url: '/tasks/rotationtask',
    method: 'post',
    data: data
  })
}

// 修改轮播图
export function updateRotationtask(data) {
  return request({
    url: '/tasks/rotationtask',
    method: 'put',
    data: data
  })
}

// 删除轮播图
export function delRotationtask(id) {
  return request({
    url: '/tasks/rotationtask/' + id,
    method: 'delete'
  })
}
