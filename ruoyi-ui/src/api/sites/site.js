import request from '@/utils/request'

// 查询现场管理列表
export function listSite(query) {
  return request({
    url: '/sites/site/list',
    method: 'get',
    params: query
  })
}

// 查询现场管理详细
export function getSite(siteId) {
  return request({
    url: '/sites/site/' + siteId,
    method: 'get'
  })
}

// 新增现场管理
export function addSite(data) {
  return request({
    url: '/sites/site',
    method: 'post',
    data: data
  })
}

// 修改现场管理
export function updateSite(data) {
  return request({
    url: '/sites/site',
    method: 'put',
    data: data
  })
}

// 删除现场管理
export function delSite(siteId) {
  return request({
    url: '/sites/site/' + siteId,
    method: 'delete'
  })
}
