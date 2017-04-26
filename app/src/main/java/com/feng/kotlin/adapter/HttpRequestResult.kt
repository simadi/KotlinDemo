package com.feng.kotlin.adapter

/**
 * description：
 * 作者：ldm
 * 时间：20162016/8/6 10:13
 * 邮箱：1786911211@qq.com
 */
//http://ip.taobao.com/service/getIpInfo.php?ip=202.168.0.123
// 返回结果 {"code":0,"data":{"country":"澳大利亚","country_id":"AU","area":"","area_id":"","region":"","region_id":"","city":"","city_id":"","county":"",
// "county_id":"","isp":"","isp_id":"","ip":"202.168.0.123"}}

class ResultIp(val code: Int ,val data :IpInfo)
//实体类IpInfo字段：
/**
 * country:国家
 * country_id:国家id
 * area:地区
 * area_id：地区id
 * ip:ip地址
 */
class IpInfo(val country: String,val country_id: String,val area: String,val area_id: String,val ip: String)