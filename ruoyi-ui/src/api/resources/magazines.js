import request from '@/utils/request'

// 查询杂志栏目列表
export function listMagazines(query) {
  return request({
    url: '/resources/magazines/list',
    method: 'get',
    params: query
  })
}

// 查询杂志栏目详细
export function getMagazines(id) {
  return request({
    url: '/resources/magazines/' + id,
    method: 'get'
  })
}

// 新增杂志栏目
export function addMagazines(data) {
  return request({
    url: '/resources/magazines',
    method: 'post',
    data: data
  })
}

// 修改杂志栏目
export function updateMagazines(data) {
  return request({
    url: '/resources/magazines',
    method: 'put',
    data: data
  })
}

// 删除杂志栏目
export function delMagazines(id) {
  return request({
    url: '/resources/magazines/' + id,
    method: 'delete'
  })
}
