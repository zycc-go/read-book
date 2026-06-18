import { state } from '@/store/index.uts'

export const getRandomDigits = (n : number) : string => {
	let result = '';
	// 1. 先确定第一位 (1-9)，防止出现 0 开头导致位数不够
	result += Math.floor(Math.random() * 9) + 1;

	// 2. 剩下的直接循环拼接，避开浮点数乘法
	for (let i = 1; i < n; i++) {
		result += Math.floor(Math.random() * 10);
	}
	return result;
}

// 添加单位
export const addUnit = (value : number | string) => {
	const isNumeric = typeof value == 'number' || /^\d+(\.\d+)?$/.test(value)
	return isNumeric ? `${value}${state.unit}` : value.toString()
}

// 判断字符串是否有值
export const hasStrValue = (val ?: string | number | null) => {
	if (val == null) return false
	if (typeof val != 'string') {
		val = val.toString()
	}
	return val.trim().length > 0
}