import request from '@/utils/request'

// 查询LOT 传感器管理列表
export function listSensors(query) {
  return request({
    url: '/lot/sensors/list',
    method: 'get',
    params: query
  })
}

// 查询LOT 传感器管理详细
export function getSensors(sensorId) {
  return request({
    url: '/lot/sensors/' + sensorId,
    method: 'get'
  })
}

// 新增LOT 传感器管理
export function addSensors(data) {
  return request({
    url: '/lot/sensors',
    method: 'post',
    data: data
  })
}

// 修改LOT 传感器管理
export function updateSensors(data) {
  return request({
    url: '/lot/sensors',
    method: 'put',
    data: data
  })
}

// 删除LOT 传感器管理
export function delSensors(sensorId) {
  return request({
    url: '/lot/sensors/' + sensorId,
    method: 'delete'
  })
}
