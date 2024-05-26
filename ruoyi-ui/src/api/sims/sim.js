import request from '@/utils/request'

// 查询SIM 卡管理列表
export function listSim(query) {
  return request({
    url: '/sims/sim/list',
    method: 'get',
    params: query
  })
}

// 查询SIM 卡管理详细
export function getSim(cardId) {
  return request({
    url: '/sims/sim/' + cardId,
    method: 'get'
  })
}

// 新增SIM 卡管理
export function addSim(data) {
  return request({
    url: '/sims/sim',
    method: 'post',
    data: data
  })
}

// 修改SIM 卡管理
export function updateSim(data) {
  return request({
    url: '/sims/sim',
    method: 'put',
    data: data
  })
}

// 删除SIM 卡管理
export function delSim(cardId) {
  return request({
    url: '/sims/sim/' + cardId,
    method: 'delete'
  })
}
