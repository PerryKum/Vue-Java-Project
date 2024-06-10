import request from '@/utils/request'

// 查询收集参数管理列表
export function listParams(query) {
  return request({
    url: '/lot/params/list',
    method: 'get',
    params: query
  })
}

// 查询收集参数管理详细
export function getParams(valueId) {
  return request({
    url: '/lot/params/' + valueId,
    method: 'get'
  })
}

// 新增收集参数管理
export function addParams(data) {
  return request({
    url: '/lot/params',
    method: 'post',
    data: data
  })
}

// 修改收集参数管理
export function updateParams(data) {
  return request({
    url: '/lot/params',
    method: 'put',
    data: data
  })
}

// 删除收集参数管理
export function delParams(valueId) {
  return request({
    url: '/lot/params/' + valueId,
    method: 'delete'
  })
}
