export type DiscussItem = {
	id : string;
	avatar : string;
	name : string;
	content : string;
	goodNum : number;
	viewNum : number;
	likeNum : number;
	shareNum : number;
	isGood : boolean;
	isView : boolean;
	isLike : boolean;
	isShare : boolean;
};

export const discussList : DiscussItem[] = [
	{
		id: "1",
		avatar: "",
		name: "体",
		content: "测试",
		likeNum: 1,
		viewNum: 2,
		goodNum: 3,
		shareNum: 4,
		isLike: false,
		isView: true,
		isGood: false,
		isShare: true,
	},
];

const getCharLen = (len : number) : string => {
	let str = ''
	for (let i = 0; i < len; i++) {
		str += String.fromCharCode(Math.floor(Math.random() * (0x67FF - 0x4e00 + 1)) + 0x4e00)
	}
	return str
}

export const discussListFun = () : DiscussItem[] => {

	const aa : DiscussItem[] = []
	for (let i = 0; i < 10; i++) {
		aa.push({
			id: `${i}`,
			avatar: "",
			name: getCharLen(Math.floor(Math.random() * 10)),
			content: getCharLen(Math.floor(Math.random() * 200)),
			likeNum: Math.floor(Math.random() * 100),
			viewNum: Math.floor(Math.random() * 100),
			goodNum: Math.floor(Math.random() * 100),
			shareNum: Math.floor(Math.random() * 100),
			isLike: Math.random() > 0.5,
			isView: Math.random() > 0.5,
			isGood: Math.random() > 0.5,
			isShare: Math.random() > 0.5,
		})
	}
	return aa
}