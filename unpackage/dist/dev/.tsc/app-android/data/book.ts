export type BookItem =  {
  id: string
  title: string
  author: string
  hasUnread?: boolean
  lastChapter: string
  lastUpdateTime: string
  readChapter: string
}

export type SearchHistoryItem = {
  id: string
  text: string
}

export const bookList: BookItem[] = [
  {
    id: "1",
    title: "三体",
    author: "刘慈欣",
    hasUnread: true,
    lastChapter: "第三部 死神永生 第27章",
    lastUpdateTime: "5小时前",
    readChapter: "第二部 死神诞生 第2章",
  },
  {
    id: "2",
    title: "活着",
    author: "余华",
    lastChapter: "全文完",
    lastUpdateTime: "3小时前",
    readChapter: "第20章",
  },
  {
    id: "3",
    title: "百年孤独",
    author: "加西亚·马尔克斯",
    hasUnread: true,
    lastChapter: "第二章",
    lastUpdateTime: "1天前",
    readChapter: "第一章",
  },
];

export const searchHistoryList: SearchHistoryItem[] = [
  { id: "1", text: "三体" },
  { id: "2", text: "活着" },
  { id: "3", text: "百年孤独" },
  { id: "4", text: "三体" },
  { id: "5", text: "活着" },
  { id: "6", text: "百年孤独" },
];
