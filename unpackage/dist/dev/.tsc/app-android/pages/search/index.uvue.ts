import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import _easycom_rice_search from '@/uni_modules/rice-ui/components/rice-search/rice-search.uvue'
import { setTheme } from "@/uni_modules/rice-ui"
	import { state } from '@/store/index.uts'
	import { searchHistoryList, SearchHistoryItem } from '@/data/book'

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const keywords = ref('')

	const searchHistoryLists = ref<SearchHistoryItem[]>([])

	const onBack = () => {
		uni.navigateBack()
	}

	const onClickAction = () => {
		uni.showToast({
			title: '搜索' + keywords.value
		})
	}

	const onSearchItem = (item : SearchHistoryItem) => {
		keywords.value = item.text
		onClickAction()
	}

	const initData = () => {
		const list : SearchHistoryItem[] = []
		const books = ['三体', '活着', '百年孤独', '红楼梦', '西游记', '斗破苍穹', '盗墓笔记', '解忧杂货店']
		for (let i = 1; i <= 200; i++) {
			const text = books[i % books.length] as string
			list.push({ id: `${i}`, text })
		}
		searchHistoryLists.value = list
	}

	initData()

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)
const _component_rice_search = resolveEasyComponent("rice-search",_easycom_rice_search)

  return _cE("view", _uM({
    class: _nC([`rice-theme-${unref(state).appTheme}`, 'page']),
    style: _nS(_uM({ paddingTop:`${unref(state).statusBarHeight}px`}))
  }), [
    _cE("view", _uM({
      class: "page-navbar",
      style: _nS(_uM({ height:`${unref(state).navbarHeight}px`, top:`${unref(state).statusBarHeight}px`}))
    }), [
      _cE("view", _uM({
        class: "page-navbar-left",
        onClick: onBack
      }), [
        _cV(_component_rice_icon, _uM({
          name: "arrow-left",
          size: "20",
          color: "var(--text-color4)"
        }))
      ]),
      _cV(_component_rice_search, _uM({
        modelValue: unref(keywords),
        "onUpdate:modelValue": $event => {trySetRefValue(keywords, $event)},
        placeholder: "请输入搜索关键词",
        "show-action": "",
        onSearch: onClickAction,
        onClickAction: onClickAction
      }), null, 8 /* PROPS */, ["modelValue"])
    ], 4 /* STYLE */),
    _cE("view", _uM({
      class: "card",
      style: _nS(_uM({ marginTop:`${unref(state).navbarHeight}px`, paddingBottom:`${unref(state).navbarHeight + unref(state).safeAreaInsetsHeight}px`}))
    }), [
      _cE("text", _uM({ class: "card-title" }), "历史记录"),
      _cE("scroll-view", _uM({
        direction: "vertical",
        style: _nS(_uM({"flex":"1"}))
      }), [
        _cE("view", _uM({ class: "tag-list" }), [
          _cE(Fragment, null, RenderHelpers.renderList(unref(searchHistoryLists), (item, __key, __index, _cached): any => {
            return _cE("text", _uM({
              class: "tag",
              onClick: () => {onSearchItem(item)}
            }), _tD(item.text), 9 /* TEXT, PROPS */, ["onClick"])
          }), 256 /* UNKEYED_FRAGMENT */)
        ])
      ], 4 /* STYLE */)
    ], 4 /* STYLE */)
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesSearchIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--rice-navbar-background)"], ["width", "100%"], ["height", "100%"], ["paddingBottom", 20]]))], ["page-navbar", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["justifyContent", "space-between"], ["alignItems", "center"], ["position", "fixed"], ["width", "100%"], ["zIndex", 9], ["backgroundColor", "var(--rice-navbar-background)"]]))], ["page-navbar-left", _uM([[".page-navbar ", _uM([["paddingTop", 0], ["paddingRight", 12], ["paddingBottom", 0], ["paddingLeft", 12]])]])], ["rice-search", _uM([[".page-navbar ", _uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["paddingTop", 0], ["paddingRight", 16], ["paddingBottom", 0], ["paddingLeft", 0]])]])], ["card", _pS(_uM([["paddingTop", 0], ["paddingRight", 15], ["paddingBottom", 0], ["paddingLeft", 15], ["zIndex", 0], ["height", "100%"]]))], ["card-title", _uM([[".card ", _uM([["marginTop", 12], ["marginRight", 0], ["marginBottom", 12], ["marginLeft", 0], ["color", "var(--rice-text-color)"]])]])], ["scroll-view-box", _uM([[".card ", _uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"]])]])], ["tag-list", _uM([[".card ", _uM([["display", "flex"], ["flexDirection", "row"], ["flexWrap", "wrap"], ["marginTop", 0], ["marginRight", -4], ["marginBottom", 0], ["marginLeft", -4]])]])], ["tag", _uM([[".card .tag-list ", _uM([["marginTop", 4], ["marginRight", 4], ["marginBottom", 4], ["marginLeft", 4], ["paddingTop", 4], ["paddingRight", 8], ["paddingBottom", 4], ["paddingLeft", 8], ["fontSize", 14], ["borderTopLeftRadius", 3], ["borderTopRightRadius", 3], ["borderBottomRightRadius", 3], ["borderBottomLeftRadius", 3], ["color", "var(--text-color2)"], ["backgroundColor", "var(--background-color5)"]])]])]])]
