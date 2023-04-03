import request from '@/utils/request'

// 查询问题反馈列表
export function listQuestion(query) {
  return request({
    url: '/users/question/list',
    method: 'get',
    params: query
  })
}

// 查询问题反馈详细
export function getQuestion(id) {
  return request({
    url: '/users/question/' + id,
    method: 'get'
  })
}

// 新增问题反馈
export function addQuestion(data) {
  return request({
    url: '/users/question',
    method: 'post',
    data: data
  })
}

// 修改问题反馈
export function updateQuestion(data) {
  return request({
    url: '/users/question',
    method: 'put',
    data: data
  })
}

// 删除问题反馈
export function delQuestion(id) {
  return request({
    url: '/users/question/' + id,
    method: 'delete'
  })
}
