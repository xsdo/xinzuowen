import request from '@/utils/request'

// 查询视频列表
export function listVideos(query) {
  return request({
    url: '/resources/videos/list',
    method: 'get',
    params: query
  })
}

// 查询视频详细
export function getVideos(id) {
  return request({
    url: '/resources/videos/' + id,
    method: 'get'
  })
}

// 新增视频
export function addVideos(data) {
  return request({
    url: '/resources/videos',
    method: 'post',
    data: data
  })
}

// 修改视频
export function updateVideos(data) {
  return request({
    url: '/resources/videos',
    method: 'put',
    data: data
  })
}

// 删除视频
export function delVideos(id) {
  return request({
    url: '/resources/videos/' + id,
    method: 'delete'
  })
}
