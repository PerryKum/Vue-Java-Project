import request from '@/utils/request'

// 查询Lot设备管理列表
export function listDevices(query) {
  return request({
    url: '/lot/devices/list',
    method: 'get',
    params: query
  })
}

// 查询Lot设备管理详细
export function getDevices(deviceId) {
  return request({
    url: '/lot/devices/' + deviceId,
    method: 'get'
  })
}

// 新增Lot设备管理
export function addDevices(data) {
  return request({
    url: '/lot/devices',
    method: 'post',
    data: data
  })
}

// 修改Lot设备管理
export function updateDevices(data) {
  return request({
    url: '/lot/devices',
    method: 'put',
    data: data
  })
}

// 删除Lot设备管理
export function delDevices(deviceId) {
  return request({
    url: '/lot/devices/' + deviceId,
    method: 'delete'
  })
}
